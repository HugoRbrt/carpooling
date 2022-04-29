package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

public class ListeTroncons {

	protected Shell shlMesTroncons;
	private ArrayList<int []> res;
	private Spinner trajet_number;
	private Spinner troncon_number;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public ListeTroncons (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListeTroncons window = new ListeTroncons(myco);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		res = myco.getTronconEmprunte();
		Display display = Display.getDefault();
		createContents();
		shlMesTroncons.open();
		shlMesTroncons.layout();
		while (!shlMesTroncons.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMesTroncons = new Shell();
		shlMesTroncons.addListener(SWT.Close, new Listener() {
		      public void handleEvent(Event event) {
		    	  if(!changeWindow) {
		    		  //we add the event "close the connection to DB" only if
		    		  //we close definitively the app (and not when we change the window)
			    	  try {
				    	  myco.closeConnection();
			    	  } catch (SQLException e) {
			              System.err.println("failed");
			              e.printStackTrace(System.err);
			              myco.conn = null;
			          }
		    	  }
		      }
		    });
		shlMesTroncons.setSize(700, 500);
		shlMesTroncons.setText("Mes tronçons - VerbiageVoiture");
		
		Label lblMesTronons = new Label(shlMesTroncons, SWT.NONE);
		lblMesTronons.setText("Mes tronçons");
		lblMesTronons.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblMesTronons.setAlignment(SWT.CENTER);
		lblMesTronons.setBounds(173, 31, 344, 57);
		
		Label lblListeDesTronons = new Label(shlMesTroncons, SWT.WRAP);

		String MyTrajets = new String();
		for(int i = 0; i < res.size(); i++) {
			MyTrajets+="id : ";MyTrajets+=res.get(i)[0];
			MyTrajets+="du troncon : ";MyTrajets+=res.get(i)[1];MyTrajets+=".\n";
		}
		
		lblListeDesTronons.setText(MyTrajets);
		lblListeDesTronons.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblListeDesTronons.setBounds(10, 91, 680, 300);
		
		Button btnRetour = new Button(shlMesTroncons, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				MenuPrincipal window = new MenuPrincipal(myco);
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 430, 96, 27);
		
		Button btnPayer = new Button(shlMesTroncons, SWT.NONE);
		btnPayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!trajet_number.getText().isBlank()) {
					int idTrajet = trajet_number.getSelection();
					int num_troncon = troncon_number.getSelection();
					float prix = 0;
					for(int i=0;i<res.size();i++) {
						if(res.get(i)[0]==idTrajet && res.get(i)[1]==num_troncon){
							prix=myco.coutTroncon(res.get(i)[1],res.get(i)[0]);
						}
					}
					if(prix>0) {
						
						ChangeWindow();
						PaiementTroncon window = new PaiementTroncon(myco, prix, res, idTrajet, num_troncon);
						window.open();
						
					}
					
					
				}
			}
		});
		btnPayer.setBounds(322, 430, 150, 27);
		btnPayer.setText("Payer");
		
		Label lblTrajetN = new Label(shlMesTroncons, SWT.NONE);
		lblTrajetN.setFont(SWTResourceManager.getFont("Arial", 16, SWT.NORMAL));
		lblTrajetN.setBounds(10, 397, 65, 18);
		lblTrajetN.setText("Trajet n°");
		
		trajet_number = new Spinner(shlMesTroncons, SWT.BORDER);
		trajet_number.setBounds(81, 397, 80, 22);
		
		Label lblTronconN = new Label(shlMesTroncons, SWT.NONE);
		lblTronconN.setFont(SWTResourceManager.getFont("Arial", 16, SWT.NORMAL));
		lblTronconN.setBounds(170, 397, 100, 18);
		lblTronconN.setText("du tronçon n°");
		
		troncon_number = new Spinner(shlMesTroncons, SWT.BORDER);
		troncon_number.setBounds(276, 397, 80, 22);


		Button btnValiderMontee = new Button(shlMesTroncons, SWT.NONE);
		btnValiderMontee.setText("Valider Montée");
		btnValiderMontee.setBounds(10, 430, 150, 27);
		
		btnValiderMontee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				myco.validerMonteeTroncon(troncon_number.getSelection(), trajet_number.getSelection());
				return;
			}
		}); 

		Button btnValiderDescente = new Button(shlMesTroncons, SWT.NONE);
		btnValiderDescente.setText("Valider Descente");
		btnValiderDescente.setBounds(166, 430, 150, 27);
		
		btnValiderDescente.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseUp(MouseEvent e) {
				myco.validerDescenteTroncon(troncon_number.getSelection(), trajet_number.getSelection());
			}
		}); 

		
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlMesTroncons.close();
		changeWindow = false;
	}
}
