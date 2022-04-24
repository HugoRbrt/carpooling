package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ListeVehicules {

	protected Shell shlMesVehicules;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public ListeVehicules (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		myco = new MyConnection();
		try {
			ListeVehicules window = new ListeVehicules(myco);
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
		shlMesVehicules.open();
		shlMesVehicules.layout();
		while (!shlMesVehicules.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMesVehicules = new Shell();
		shlMesVehicules.addListener(SWT.Close, new Listener() {
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
		shlMesVehicules.setSize(700, 500);
		shlMesVehicules.setText("Mes véhicules - VerbiageVoiture");
		
		Label lblMesVhicules = new Label(shlMesVehicules, SWT.NONE);
		lblMesVhicules.setAlignment(SWT.CENTER);
		lblMesVhicules.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblMesVhicules.setBounds(173, 53, 344, 57);
		lblMesVhicules.setText("Mes véhicules");
		
		Label lblNewLabel = new Label(shlMesVehicules, SWT.WRAP);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblNewLabel.setBounds(10, 113, 680, 300);
		String texte = "Liste des véhicules : \n";
		ArrayList<String> liste = myco.getMyVehicule();
		Iterator<String> listeVehicule = liste.iterator();
		while(listeVehicule.hasNext()) {
			texte+=listeVehicule.next()+"\n";
		}
		lblNewLabel.setText(texte);
		
		Button btnRetour = new Button(shlMesVehicules, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				MenuPrincipal window = new MenuPrincipal(myco);
				window.open();
			}
		});
		btnRetour.setBounds(594, 436, 96, 27);
		btnRetour.setText("Retour");
		
		Button btnAjouterUnVhicule = new Button(shlMesVehicules, SWT.NONE);
		btnAjouterUnVhicule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				AjoutVehicule window = new AjoutVehicule(myco);
				window.open();
			}
		});
		btnAjouterUnVhicule.setBounds(10, 436, 150, 27);
		btnAjouterUnVhicule.setText("Ajouter un véhicule");

	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlMesVehicules.close();
		changeWindow = false;
	}

}
