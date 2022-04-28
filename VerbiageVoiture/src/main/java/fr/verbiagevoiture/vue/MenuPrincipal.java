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

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MenuPrincipal {

	protected Shell shlMenuPrincipal;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public MenuPrincipal (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		myco = new MyConnection();
		try {
			MenuPrincipal window = new MenuPrincipal(myco);
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
		shlMenuPrincipal.open();
		shlMenuPrincipal.layout();
		while (!shlMenuPrincipal.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuPrincipal = new Shell();
		shlMenuPrincipal.addListener(SWT.Close, new Listener() {
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
		shlMenuPrincipal.setSize(700, 500);
		shlMenuPrincipal.setText("Menu Principal - VerbiageVoiture");
		
		Label lblVerbiagevoiture = new Label(shlMenuPrincipal, SWT.NONE);
		lblVerbiagevoiture.setText("VerbiageVoiture");
		lblVerbiagevoiture.setFont(SWTResourceManager.getFont("Arial", 52, SWT.BOLD));
		lblVerbiagevoiture.setAlignment(SWT.CENTER);
		lblVerbiagevoiture.setBounds(10, 53, 675, 110);
		
		Button btnRechercheTronon = new Button(shlMenuPrincipal, SWT.NONE);
		btnRechercheTronon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				RechercheParcours window = new RechercheParcours();
				window.open();
			}
		});
		btnRechercheTronon.setText("Recherche tronçon");
		btnRechercheTronon.setBounds(268, 159, 175, 40);
		
		Button btnMesVhicules = new Button(shlMenuPrincipal, SWT.NONE);
		btnMesVhicules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				ListeVehicules window = new ListeVehicules(myco);
				window.open();
			}
		});
		btnMesVhicules.setText("Mes véhicules");
		btnMesVhicules.setBounds(268, 219, 175, 40);
		
		Button btnMesTrajets = new Button(shlMenuPrincipal, SWT.NONE);
		btnMesTrajets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				ListeTrajets window = new ListeTrajets(myco);
				window.open();
			}
		});
		btnMesTrajets.setText("Mes trajets");
		btnMesTrajets.setBounds(268, 277, 175, 40);
		
		Button btnMesTrononsEmprunts = new Button(shlMenuPrincipal, SWT.NONE);
		btnMesTrononsEmprunts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				ListeTroncons window = new ListeTroncons(myco);
				window.open();
			}
		});
		btnMesTrononsEmprunts.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMesTrononsEmprunts.setText("Mes tronçons empruntés");
		btnMesTrononsEmprunts.setBounds(268, 335, 175, 40);
		
		Button btnMonSolde = new Button(shlMenuPrincipal, SWT.NONE);
		btnMonSolde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				Solde window = new Solde(myco);
				window.open();
			}
		});
		btnMonSolde.setText("Mon solde");
		btnMonSolde.setBounds(268, 394, 175, 40);

	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlMenuPrincipal.close();
		changeWindow = false;
	}

}
