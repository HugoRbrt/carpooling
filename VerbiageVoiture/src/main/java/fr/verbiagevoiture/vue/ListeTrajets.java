package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ListeTrajets {

	protected Shell shlMesTrajets;
	private Spinner confirmationDep;
	private Spinner confirmationAr;
	private Text annulation;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public ListeTrajets (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListeTrajets window = new ListeTrajets(myco);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMesTrajets.open();
		shlMesTrajets.layout();
		while (!shlMesTrajets.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMesTrajets = new Shell();
		shlMesTrajets.addListener(SWT.Close, new Listener() {
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
		shlMesTrajets.setSize(700, 500);
		shlMesTrajets.setText("Mes trajets - VerbiageVoiture");
		
		Label lblMesTrajets = new Label(shlMesTrajets, SWT.NONE);
		lblMesTrajets.setText("Mes trajets");
		lblMesTrajets.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblMesTrajets.setAlignment(SWT.CENTER);
		lblMesTrajets.setBounds(173, 50, 344, 57);
		
		Label lblListeDesTrajets = new Label(shlMesTrajets, SWT.WRAP);
		ArrayList<String []> listMyTrajet = myco.getMyTrajet();
		String MyTrajets = new String();
		for(int i = 0; i < listMyTrajet.size(); i++) {
			MyTrajets+="numero : ";MyTrajets+=listMyTrajet.get(i)[0];
			MyTrajets+=", à : ";MyTrajets+=listMyTrajet.get(i)[4];
			MyTrajets+=", immatriculé : ";MyTrajets+=listMyTrajet.get(i)[2];MyTrajets+=".\n";
		}
		
		lblListeDesTrajets.setText(MyTrajets.toString());
		lblListeDesTrajets.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblListeDesTrajets.setBounds(10, 110, 680, 290);
		
		Button btnRetour = new Button(shlMesTrajets, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				MenuPrincipal window = new MenuPrincipal(myco);
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 433, 96, 27);
		
		Button btnAjouterUnTrajet = new Button(shlMesTrajets, SWT.NONE);
		btnAjouterUnTrajet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				AjoutTrajet window = new AjoutTrajet(myco);
				window.open();
			}
		});
		btnAjouterUnTrajet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAjouterUnTrajet.setText("Ajouter un trajet");
		btnAjouterUnTrajet.setBounds(10, 433, 130, 27);
		
		Label lblConfirmationDpartTrajet = new Label(shlMesTrajets, SWT.NONE);
		lblConfirmationDpartTrajet.setAlignment(SWT.RIGHT);
		lblConfirmationDpartTrajet.setBounds(10, 407, 170, 20);
		lblConfirmationDpartTrajet.setText("Confirmation départ trajet n°");
		
		confirmationDep = new Spinner(shlMesTrajets, SWT.BORDER);
		confirmationDep.setBounds(186, 406, 64, 19);
		
		Button btnValiderDebutTrajet = new Button(shlMesTrajets, SWT.NONE);
		btnValiderDebutTrajet.setBounds(253, 400, 70, 27);
		btnValiderDebutTrajet.setText("Valider");
		btnValiderDebutTrajet.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseUp(MouseEvent e) {
				myco.validerDebutTrajet(confirmationDep.getSelection());
			}
		}); 
		
		Label lblConfirmationArriveTrajet = new Label(shlMesTrajets, SWT.NONE);
		lblConfirmationArriveTrajet.setAlignment(SWT.RIGHT);
		lblConfirmationArriveTrajet.setText("Confirmation arrivée trajet n°");
		lblConfirmationArriveTrajet.setBounds(387, 407, 170, 20);
		
		confirmationAr = new Spinner(shlMesTrajets, SWT.BORDER);
		confirmationAr.setBounds(563, 406, 64, 19);
		
		Button btnValiderFinTrajet = new Button(shlMesTrajets, SWT.NONE);
		btnValiderFinTrajet.setText("Valider");
		btnValiderFinTrajet.setBounds(630, 400, 70, 27);
		btnValiderFinTrajet.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseUp(MouseEvent e) {
				myco.validerFinTrajet(confirmationAr.getSelection());
			}
		});
		Label lblAnnulationTrajetN = new Label(shlMesTrajets, SWT.NONE);
		lblAnnulationTrajetN.setText("Annulation trajet n°");
		lblAnnulationTrajetN.setAlignment(SWT.RIGHT);
		lblAnnulationTrajetN.setBounds(210, 440, 120, 20);
		
		annulation = new Text(shlMesTrajets, SWT.BORDER);
		annulation.setBounds(334, 435, 64, 19);
		
		Button btnValider_annulation = new Button(shlMesTrajets, SWT.NONE);
		btnValider_annulation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//TODO : success prend la valeur de retour de la suppression
				boolean success = deleteTrajetwithTroncon();
				if(success) {
					ChangeWindow();
					ListeTrajets window = new ListeTrajets(myco);
					window.open();
				}
			}
		});
		btnValider_annulation.setText("Valider");
		btnValider_annulation.setBounds(404, 433, 70, 27);

	}
	
	protected boolean deleteTrajetwithTroncon() {
		return myco.deleteTrajetwithTroncon(Integer.parseInt(annulation.getText()));
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlMesTrajets.close();
		changeWindow = false;
	}

}
