package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

public class WelcomeScreen {

	protected Shell shlVerbiagevoiture;
	protected static MyConnection myco;
	protected boolean changeWindow = false;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		myco = new MyConnection();
		try {
			WelcomeScreen window = new WelcomeScreen();
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
		shlVerbiagevoiture.open();
		shlVerbiagevoiture.layout();
		while (!shlVerbiagevoiture.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlVerbiagevoiture = new Shell();
		shlVerbiagevoiture.addListener(SWT.Close, new Listener() {
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
		shlVerbiagevoiture.setBackground(SWTResourceManager.getColor(236, 236, 236));
		shlVerbiagevoiture.setSize(700, 500);
		shlVerbiagevoiture.setText("VerbiageVoiture");
		
		Label lblVerbiagevoiture = new Label(shlVerbiagevoiture, SWT.NONE);
		lblVerbiagevoiture.setAlignment(SWT.CENTER);
		lblVerbiagevoiture.setFont(SWTResourceManager.getFont("Arial", 52, SWT.BOLD));
		lblVerbiagevoiture.setBounds(10, 56, 675, 110);
		lblVerbiagevoiture.setText("VerbiageVoiture");
		
		Button btnSeConnecter = new Button(shlVerbiagevoiture, SWT.NONE);
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				LoginPage window = new LoginPage(myco);
				window.open();
			}
		});
		btnSeConnecter.setBounds(285, 197, 120, 40);
		btnSeConnecter.setText("Se connecter");
		
		Button btnSenregistrer = new Button(shlVerbiagevoiture, SWT.NONE);
		btnSenregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				SignUpScreen window = new SignUpScreen(myco);
				window.open();

			}
		});
		btnSenregistrer.setBounds(285, 275, 120, 40);
		btnSenregistrer.setText("S'enregistrer");
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlVerbiagevoiture.close();
		changeWindow = false;
	}
}
