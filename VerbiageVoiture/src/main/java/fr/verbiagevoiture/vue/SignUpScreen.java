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

public class SignUpScreen {

	protected Shell shlSenregistrer;
	private Text mail;
	private Text nom;
	private Text prenom;
	private Text ville;
	private Text mdp;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public SignUpScreen (MyConnection m) {
		myco = m;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void Main(String[] args) {
		myco = new MyConnection();
		try {
			SignUpScreen window = new SignUpScreen(myco);
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
		shlSenregistrer.open();
		shlSenregistrer.layout();
		while (!shlSenregistrer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSenregistrer = new Shell();
		shlSenregistrer.addListener(SWT.Close, new Listener() {
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
		shlSenregistrer.setSize(700, 500);
		shlSenregistrer.setText("S'enregistrer - VerbiageVoiture");
		
		Label lblEmail = new Label(shlSenregistrer, SWT.NONE);
		lblEmail.setText("E-mail");
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(121, 92, 107, 29);
		
		mail = new Text(shlSenregistrer, SWT.BORDER);
		mail.setBounds(246, 97, 300, 20);
		
		Label lblNom = new Label(shlSenregistrer, SWT.NONE);
		lblNom.setText("Nom");
		lblNom.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblNom.setAlignment(SWT.RIGHT);
		lblNom.setBounds(121, 149, 107, 29);
		
		nom = new Text(shlSenregistrer, SWT.BORDER);
		nom.setBounds(246, 154, 300, 20);
		
		Label lblPrnom = new Label(shlSenregistrer, SWT.NONE);
		lblPrnom.setText("Prénom");
		lblPrnom.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblPrnom.setAlignment(SWT.RIGHT);
		lblPrnom.setBounds(121, 206, 107, 29);
		
		prenom = new Text(shlSenregistrer, SWT.BORDER);
		prenom.setBounds(246, 211, 300, 20);
		
		Label lblVilleDeRsidence = new Label(shlSenregistrer, SWT.NONE);
		lblVilleDeRsidence.setText("Ville de résidence");
		lblVilleDeRsidence.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblVilleDeRsidence.setAlignment(SWT.RIGHT);
		lblVilleDeRsidence.setBounds(39, 261, 189, 29);
		
		ville = new Text(shlSenregistrer, SWT.BORDER);
		ville.setBounds(246, 266, 300, 20);
		
		Label lblMotDePasse = new Label(shlSenregistrer, SWT.NONE);
		lblMotDePasse.setText("Mot de passe");
		lblMotDePasse.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblMotDePasse.setAlignment(SWT.CENTER);
		lblMotDePasse.setBounds(99, 318, 129, 29);
		
		mdp = new Text(shlSenregistrer, SWT.BORDER | SWT.PASSWORD);
		mdp.setBounds(246, 323, 300, 20);
		
		Button btnSenregistrer = new Button(shlSenregistrer, SWT.NONE);
		btnSenregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean success = SignUp();
				if(success == true) {
					ChangeWindow();
					MenuPrincipal window = new MenuPrincipal(myco);
					window.open();
				}
				else {

					
					Message window = new Message("creation de compte impossible (un champ est vide ET/OU l'adresse email existe déjà pour un autre compte)");
					window.open();

					ChangeWindow();
					Solde window2 = new Solde(myco);
					window2.open();
				}
			}
		});
		btnSenregistrer.setText("S'enregistrer");
		btnSenregistrer.setBounds(298, 396, 120, 27);

	}
	
	protected boolean SignUp() {
		return myco.creerUtilisateur(mail.getText(), nom.getText(), prenom.getText(), ville.getText(), mdp.getText());
	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlSenregistrer.close();
		changeWindow = false;
	}

}
