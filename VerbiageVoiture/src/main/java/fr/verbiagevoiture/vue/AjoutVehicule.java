package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AjoutVehicule {

	protected Shell shlNouveauVehicule;
	private Text immatriculation;
	private Text marque;
	private Text modele;
	private Text pFiscale;
	private Text nbPlaces;
	private Combo energieUtillise;
	//Combo combo contains the value of "energie utilise"
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public AjoutVehicule (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		myco = new MyConnection();
		try {
			AjoutVehicule window = new AjoutVehicule(myco);
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
		shlNouveauVehicule.open();
		shlNouveauVehicule.layout();
		while (!shlNouveauVehicule.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNouveauVehicule = new Shell();
		shlNouveauVehicule.addListener(SWT.Close, new Listener() {
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
		shlNouveauVehicule.setSize(700, 500);
		shlNouveauVehicule.setText("Nouveau véhicule - VerbiageVoiture");
		
		Label lblNouveauVhicule = new Label(shlNouveauVehicule, SWT.NONE);
		lblNouveauVhicule.setAlignment(SWT.CENTER);
		lblNouveauVhicule.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblNouveauVhicule.setBounds(168, 43, 357, 56);
		lblNouveauVhicule.setText("Nouveau véhicule");
		
		Label lblImmatriculation = new Label(shlNouveauVehicule, SWT.NONE);
		lblImmatriculation.setText("Immatriculation");
		lblImmatriculation.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblImmatriculation.setAlignment(SWT.RIGHT);
		lblImmatriculation.setBounds(53, 105, 174, 29);
		
		immatriculation = new Text(shlNouveauVehicule, SWT.BORDER);
		immatriculation.setBounds(245, 110, 300, 20);
		
		Label lblMarque = new Label(shlNouveauVehicule, SWT.NONE);
		lblMarque.setText("Marque");
		lblMarque.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblMarque.setAlignment(SWT.RIGHT);
		lblMarque.setBounds(120, 150, 107, 29);
		
		marque = new Text(shlNouveauVehicule, SWT.BORDER);
		marque.setBounds(245, 155, 300, 20);
		
		Label lblModle = new Label(shlNouveauVehicule, SWT.NONE);
		lblModle.setText("Modèle");
		lblModle.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblModle.setAlignment(SWT.RIGHT);
		lblModle.setBounds(120, 201, 107, 29);
		
		modele = new Text(shlNouveauVehicule, SWT.BORDER);
		modele.setBounds(245, 206, 300, 20);
		
		Label lblPuissanceFiscale = new Label(shlNouveauVehicule, SWT.NONE);
		lblPuissanceFiscale.setText("Puissance fiscale");
		lblPuissanceFiscale.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblPuissanceFiscale.setAlignment(SWT.RIGHT);
		lblPuissanceFiscale.setBounds(53, 250, 174, 29);
		
		pFiscale = new Text(shlNouveauVehicule, SWT.BORDER);
		pFiscale.setBounds(245, 255, 150, 20);
		
		Label lblnergieUtlise = new Label(shlNouveauVehicule, SWT.NONE);
		lblnergieUtlise.setText("Énergie utlisée");
		lblnergieUtlise.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblnergieUtlise.setAlignment(SWT.RIGHT);
		lblnergieUtlise.setBounds(37, 299, 190, 29);
		
		Label lblNombreDePlaces = new Label(shlNouveauVehicule, SWT.NONE);
		lblNombreDePlaces.setText("Nombre de places");
		lblNombreDePlaces.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblNombreDePlaces.setAlignment(SWT.RIGHT);
		lblNombreDePlaces.setBounds(37, 348, 190, 29);
		
		nbPlaces = new Text(shlNouveauVehicule, SWT.BORDER);
		nbPlaces.setBounds(245, 353, 300, 20);
		
		Label lblCv = new Label(shlNouveauVehicule, SWT.NONE);
		lblCv.setFont(SWTResourceManager.getFont("Arial", 16, SWT.NORMAL));
		lblCv.setBounds(401, 254, 67, 24);
		lblCv.setText("cv");
		
		energieUtillise = new Combo(shlNouveauVehicule, SWT.READ_ONLY);
		energieUtillise.setItems(new String[] {"essence", "diesel", "hybride", "electrique"});
		energieUtillise.setBounds(245, 306, 150, 22);
		
		Button btnAjouter = new Button(shlNouveauVehicule, SWT.NONE);
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try {
					if(AjouterVehicule()) {
						ChangeWindow();
						ListeVehicules window = new ListeVehicules(myco);
						window.open();
					}	
				} catch (Exception excep) {
					Message window = new Message("un champ est vide ET/OU rentrer un entier dans les champs 'puissance fiscale' et 'nombre de places'");
					window.open();
				}
			}
		});
		btnAjouter.setBounds(10, 431, 96, 27);
		btnAjouter.setText("Ajouter");
		
		Button btnAnnuler = new Button(shlNouveauVehicule, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				ListeVehicules window = new ListeVehicules(myco);
				window.open();
			}
		});
		btnAnnuler.setBounds(590, 431, 96, 27);
		btnAnnuler.setText("Annuler");

	}
	
	protected boolean AjouterVehicule() {
		
		return myco.addVehicule(immatriculation.getText(), marque.getText(), modele.getText(), Integer.parseInt(pFiscale.getText()), Integer.parseInt(nbPlaces.getText()), energieUtillise.getText());
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlNouveauVehicule.close();
		changeWindow = false;
	}
}
