package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Solde {

	protected Shell shlMonSolde;
	private Spinner monSolde;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public Solde (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		myco = new MyConnection();
		try {
			Solde window = new Solde(myco);
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
		shlMonSolde.open();
		shlMonSolde.layout();
		while (!shlMonSolde.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMonSolde = new Shell();
		shlMonSolde.addListener(SWT.Close, new Listener() {
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
		shlMonSolde.setSize(700, 500);
		shlMonSolde.setText("Mon solde - VerbiageVoiture");
		
		Label lblSoldeActuel = new Label(shlMonSolde, SWT.NONE);
		lblSoldeActuel.setAlignment(SWT.CENTER);
		lblSoldeActuel.setFont(SWTResourceManager.getFont("Arial", 30, SWT.BOLD));
		lblSoldeActuel.setBounds(212, 76, 259, 57);
		lblSoldeActuel.setText("Solde actuel");
		
		Label lblXx = new Label(shlMonSolde, SWT.NONE);
		lblXx.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblXx.setAlignment(SWT.CENTER);
		lblXx.setBounds(281, 139, 132, 40);
		lblXx.setText(AfficherSolde() + " €");
		
		Label lblRecharger = new Label(shlMonSolde, SWT.NONE);
		lblRecharger.setText("Recharger");
		lblRecharger.setFont(SWTResourceManager.getFont("Arial", 30, SWT.BOLD));
		lblRecharger.setAlignment(SWT.CENTER);
		lblRecharger.setBounds(212, 229, 259, 57);
		
		monSolde = new Spinner(shlMonSolde, SWT.BORDER);
		monSolde.setBounds(234, 302, 64, 19);
		monSolde.setDigits(2);
		
		Label label = new Label(shlMonSolde, SWT.NONE);
		label.setBounds(303, 305, 33, 14);
		label.setText("€");
		
		Button btnRecharger = new Button(shlMonSolde, SWT.NONE);
		btnRecharger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//TODO : clear le champ, incrementer le porte monnaie puis reafficher le solde actuel
				boolean success = Recharger();
				if(success) {
					ChangeWindow();
					open();
				}
			}
		});
		btnRecharger.setBounds(348, 300, 96, 27);
		btnRecharger.setText("Recharger");
		
		
		Button btnOk = new Button(shlMonSolde, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				MenuPrincipal window = new MenuPrincipal(myco);
				window.open();
			}
		});
		btnOk.setBounds(566, 425, 96, 27);
		btnOk.setText("OK");

	}
	
	protected boolean Recharger() {
		
		return myco.RechargerSolde(Float.parseFloat(monSolde.getText()));
	}
	
	protected String AfficherSolde() {
		return myco.AfficherSolde();
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlMonSolde.close();
		changeWindow = false;
	}

}
