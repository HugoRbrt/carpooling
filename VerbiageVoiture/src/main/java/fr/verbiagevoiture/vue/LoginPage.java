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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LoginPage {

	protected Shell shlSeConnecter;
	private Text email;
	private Text mdp;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public LoginPage (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		myco = new MyConnection();
		try {
			LoginPage window = new LoginPage(myco);
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
		shlSeConnecter.open();
		shlSeConnecter.layout();
		while (!shlSeConnecter.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSeConnecter = new Shell();
		shlSeConnecter.addListener(SWT.Close, new Listener() {
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
		shlSeConnecter.setSize(700, 500);
		shlSeConnecter.setText("Se connecter - VerbiageVoiture");
		
		Label lblEmail = new Label(shlSeConnecter, SWT.NONE);
		lblEmail.setAlignment(SWT.CENTER);
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setBounds(128, 164, 107, 29);
		lblEmail.setText("E-mail");
		
		email = new Text(shlSeConnecter, SWT.BORDER);
		email.setBounds(253, 169, 300, 20);
		
		Label lblMotDePasse = new Label(shlSeConnecter, SWT.NONE);
		lblMotDePasse.setText("Mot de passe");
		lblMotDePasse.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblMotDePasse.setAlignment(SWT.CENTER);
		lblMotDePasse.setBounds(106, 232, 129, 29);
		
		mdp = new Text(shlSeConnecter, SWT.BORDER | SWT.PASSWORD);
		mdp.setBounds(253, 237, 300, 20);
		
		Button btnSeConnecter = new Button(shlSeConnecter, SWT.NONE);
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (Login()) {//if connection success
					ChangeWindow();
					MenuPrincipal window = new MenuPrincipal(myco);
					window.open();
				}
				else {
					
					Message window = new Message("connexion impossible : adresse mail ou mot de passe incorrect");
					window.open();

					ChangeWindow();
					Solde window2 = new Solde(myco);
					window2.open();
				}
			}
		});
		btnSeConnecter.setBounds(289, 368, 120, 27);
		btnSeConnecter.setText("Se connecter");

	}
	
	protected boolean Login() {
		return myco.CheckEmailAndMDP(email.getText(), mdp.getText());
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlSeConnecter.close();
		changeWindow = false;
	}
}
