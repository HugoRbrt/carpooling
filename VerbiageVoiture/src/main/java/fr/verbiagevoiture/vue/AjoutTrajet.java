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

import fr.verbiagevoiture.controleur.ToTimestamp;
import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AjoutTrajet {

	protected Shell shlNouveauTrajet;
	private Spinner nbPlaces;
	private Spinner nbTroncon;
	private Combo vehicule;
	private DateTime dateDep;
	private DateTime timeDep;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public AjoutTrajet (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AjoutTrajet window = new AjoutTrajet(new MyConnection());
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
		shlNouveauTrajet.open();
		shlNouveauTrajet.layout();
		while (!shlNouveauTrajet.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNouveauTrajet = new Shell();
		shlNouveauTrajet.addListener(SWT.Close, new Listener() {
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
		shlNouveauTrajet.setSize(700, 500);
		shlNouveauTrajet.setText("Nouveau trajet - VerbiageVoiture");
		
		Label lblNouveauTrajet = new Label(shlNouveauTrajet, SWT.NONE);
		lblNouveauTrajet.setAlignment(SWT.CENTER);
		lblNouveauTrajet.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblNouveauTrajet.setBounds(192, 51, 321, 49);
		lblNouveauTrajet.setText("Nouveau trajet");
		
		Label lblEmail = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail.setText("Date de départ");
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(80, 126, 216, 29);
		
		Label lblEmail_1 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1.setText("Heure de départ");
		lblEmail_1.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1.setAlignment(SWT.RIGHT);
		lblEmail_1.setBounds(80, 174, 216, 29);
		
		Label lblEmail_1_1 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1_1.setText("Nombre de places au départ");
		lblEmail_1_1.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1_1.setAlignment(SWT.RIGHT);
		lblEmail_1_1.setBounds(10, 223, 286, 29);
		
		nbPlaces = new Spinner(shlNouveauTrajet, SWT.BORDER);
		nbPlaces.setBounds(302, 228, 270, 20);
		
		Label lblEmail_1_2 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1_2.setText("Véhicule");
		lblEmail_1_2.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1_2.setAlignment(SWT.RIGHT);
		lblEmail_1_2.setBounds(80, 273, 216, 29);
		
		Label lblEmail_1_3 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1_3.setText("Nombre de tronçons du trajet");
		lblEmail_1_3.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1_3.setAlignment(SWT.RIGHT);
		lblEmail_1_3.setBounds(10, 323, 286, 29);
		
		nbTroncon = new Spinner(shlNouveauTrajet, SWT.BORDER);
		nbTroncon.setBounds(302, 328, 270, 20);
		
		vehicule = new Combo(shlNouveauTrajet, SWT.READ_ONLY);
		//TODO : afficher la liste des véhicules
		ArrayList<String> listVehicule = myco.getMyVehicule();
		String[] arrayVehicule = new String[listVehicule.size()];
		for(int i = 0; i < listVehicule.size(); i++) {
			arrayVehicule[i] = listVehicule.get(i);
		}
		vehicule.setItems(arrayVehicule);
		vehicule.setBounds(302, 273, 270, 22);
		
		dateDep = new DateTime(shlNouveauTrajet, SWT.BORDER);
		dateDep.setBounds(302, 127, 270, 28);
		
		timeDep = new DateTime(shlNouveauTrajet, SWT.BORDER | SWT.TIME | SWT.SHORT);
		timeDep.setBounds(302, 174, 270, 28);
		
		Button btnSuivant = new Button(shlNouveauTrajet, SWT.NONE);
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(nbPlaces.getSelection()<1 || nbTroncon.getSelection()<1 || vehicule.getText().isBlank() ) {
					return ;
				}

				shlNouveauTrajet.setEnabled(false);
				int k = nbTroncon.getSelection();
				ArrayList<AjoutTroncon> tr = new ArrayList<AjoutTroncon>();
				for(int i=1;i<=k;i++) {
					AjoutTroncon window = new AjoutTroncon(myco);
					tr.add(window);
					window.open();
				}
				for(int i=1;i<=k;i++) {//we verify that each troncon were validated
					if(!tr.get(i).validate) {
						return;
					}
				}
				//we add sql instructions
				ajoutTrajet(tr);
				System.out.println("taille:"+tr.size());
				for(int i=0;i<tr.size();i++) {
					tr.get(i).ChangeWindow();
				}
				ChangeWindow();
				ListeTrajets window2 = new ListeTrajets(myco);
				window2.open();
				
			}
		});
		btnSuivant.setText("Suivant");
		btnSuivant.setBounds(10, 436, 96, 27);
		
		Button btnAnnuler = new Button(shlNouveauTrajet, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				MenuPrincipal window = new MenuPrincipal(myco);
				window.open();
			}
		});
		btnAnnuler.setText("Annuler");
		btnAnnuler.setBounds(590, 436, 96, 27);
	}
	
	protected boolean ajoutTrajet(ArrayList<AjoutTroncon> tr){
		//TODO : gestion des dates arrive/depart
		return myco.ajoutTrajet( nbPlaces.getSelection(),  vehicule.getText(), ToTimestamp.fromInt(2022,6,17,9,30), ToTimestamp.fromDateTime(dateDep, timeDep), tr);
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlNouveauTrajet.close();
		changeWindow = false;
	}
}
