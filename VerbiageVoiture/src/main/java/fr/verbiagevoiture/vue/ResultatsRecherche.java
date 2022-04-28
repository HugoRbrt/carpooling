package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

public class ResultatsRecherche {

	protected Shell shlResultatsRecherche;
	private Spinner value;
	private ArrayList<String []> res;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public ResultatsRecherche (MyConnection m, ArrayList<String []> resultats) {
		res = resultats;
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ResultatsRecherche window = new ResultatsRecherche(myco, null);
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
		shlResultatsRecherche.open();
		shlResultatsRecherche.layout();
		while (!shlResultatsRecherche.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlResultatsRecherche = new Shell();
		shlResultatsRecherche.setBackground(new Color(70, 150, 230));
		shlResultatsRecherche.addListener(SWT.Close, new Listener() {
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
		shlResultatsRecherche.setSize(700, 500);
		shlResultatsRecherche.setText("Résultats recherche - VerbiageVoiture");
		
		Label lblRsultatsRecherche = new Label(shlResultatsRecherche, SWT.NONE);
		lblRsultatsRecherche.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblRsultatsRecherche.setBounds(217, 44, 271, 34);
		lblRsultatsRecherche.setText("Résultats recherche");
		
		Label lblListeDesTrajets = new Label(shlResultatsRecherche, SWT.WRAP);
		String MyTrajets = new String();
		for(int i = 0; i < res.size(); i++) {
			MyTrajets+="id : ";MyTrajets+=res.get(i)[0];
			MyTrajets+="du troncon : ";MyTrajets+=res.get(i)[1];
			MyTrajets+=" jusqu'à : ";MyTrajets+=res.get(i)[2];MyTrajets+=".\n";
		}
		lblListeDesTrajets.setText(MyTrajets);
		lblListeDesTrajets.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblListeDesTrajets.setBounds(10, 84, 680, 300);
		
		Button btnRetour = new Button(shlResultatsRecherche, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				RechercheParcours window = new RechercheParcours(myco);
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 423, 96, 27);
		
		Label lblRserverLeParcours = new Label(shlResultatsRecherche, SWT.NONE);
		lblRserverLeParcours.setAlignment(SWT.RIGHT);
		lblRserverLeParcours.setText("Réserver le parcours n°");
		lblRserverLeParcours.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblRserverLeParcours.setBounds(10, 425, 174, 19);
		
		value = new Spinner(shlResultatsRecherche, SWT.BORDER);
		value.setBounds(190, 431, 100, 19);
		
		Button btnNewButton = new Button(shlResultatsRecherche, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!value.getText().isBlank()) {
					int idTrajet = value.getSelection();
					int indice = -1;
					for(int i=0;i<res.size();i++) {
						if(Integer.valueOf(res.get(i)[0])==idTrajet){
							indice = i;
						}
					}
					System.out.println("indice:"+indice);
					if(indice>=0) {
						for(int k=Integer.valueOf(res.get(indice)[1]);k<=Integer.valueOf(res.get(indice)[2]);k++) {
							if(Emprunte(k,idTrajet)) {
								System.out.println("ajoute!");
							}
						}
						ChangeWindow();
						MenuPrincipal window = new MenuPrincipal(myco);
						window.open();
					}
					
					
				}
			}
		});
		btnNewButton.setText("Réserver");
		btnNewButton.setBounds(296, 423, 96, 27);

	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlResultatsRecherche.close();
		changeWindow = false;
	}
	
	protected boolean Emprunte(int num, int idTrajet) {
		return myco.addEmprunte(num, idTrajet);
	}

}
