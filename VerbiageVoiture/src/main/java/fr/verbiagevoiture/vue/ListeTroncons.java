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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ListeTroncons {

	protected Shell shlMesTroncons;
	private Text numTronconPaiement;
	private Text numTronconMonte;
	private Text numTronconDescente;
	protected static MyConnection myco;
	protected boolean changeWindow = false;
	
	public ListeTroncons (MyConnection m) {
		myco = m;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListeTroncons window = new ListeTroncons(myco);
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
		shlMesTroncons.open();
		shlMesTroncons.layout();
		while (!shlMesTroncons.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMesTroncons = new Shell();
		shlMesTroncons.addListener(SWT.Close, new Listener() {
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
		shlMesTroncons.setSize(700, 500);
		shlMesTroncons.setText("Mes tronçons - VerbiageVoiture");
		
		Label lblMesTronons = new Label(shlMesTroncons, SWT.NONE);
		lblMesTronons.setText("Mes tronçons");
		lblMesTronons.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblMesTronons.setAlignment(SWT.CENTER);
		lblMesTronons.setBounds(173, 31, 344, 57);
		
		Label lblListeDesTronons = new Label(shlMesTroncons, SWT.WRAP);
		lblListeDesTronons.setText("Liste des tronçons empruntés en tant qu'usager retournée grâce à la méthode toString()");
		lblListeDesTronons.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblListeDesTronons.setBounds(10, 91, 680, 300);
		
		Button btnRetour = new Button(shlMesTroncons, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesTroncons.close();
				MenuPrincipal window = new MenuPrincipal(myco);
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 430, 96, 27);
		
		Label lblPayerLeTronon = new Label(shlMesTroncons, SWT.NONE);
		lblPayerLeTronon.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblPayerLeTronon.setBounds(10, 432, 140, 19);
		lblPayerLeTronon.setText("Payer le tronçon n°");
		
		numTronconPaiement = new Text(shlMesTroncons, SWT.BORDER);
		numTronconPaiement.setBounds(144, 438, 100, 19);
		
		Button btnPayer = new Button(shlMesTroncons, SWT.NONE);
		btnPayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesTroncons.close();
				PaiementTroncon window = new PaiementTroncon();
				window.open();
			}
		});
		btnPayer.setBounds(250, 430, 96, 27);
		btnPayer.setText("Payer");
		
		Label lblConfirmationMonteTronon = new Label(shlMesTroncons, SWT.NONE);
		lblConfirmationMonteTronon.setText("Confirmation montée tronçon n°");
		lblConfirmationMonteTronon.setAlignment(SWT.RIGHT);
		lblConfirmationMonteTronon.setBounds(10, 404, 193, 20);
		
		numTronconMonte = new Text(shlMesTroncons, SWT.BORDER);
		numTronconMonte.setBounds(209, 403, 64, 19);
		
		Button btnValider = new Button(shlMesTroncons, SWT.NONE);
		btnValider.setText("Valider");
		btnValider.setBounds(276, 397, 70, 27);
		
		Label lblConfirmationDescenteTronon = new Label(shlMesTroncons, SWT.NONE);
		lblConfirmationDescenteTronon.setText("Confirmation descente tronçon n°");
		lblConfirmationDescenteTronon.setAlignment(SWT.RIGHT);
		lblConfirmationDescenteTronon.setBounds(352, 404, 195, 20);
		
		numTronconDescente = new Text(shlMesTroncons, SWT.BORDER);
		numTronconDescente.setBounds(553, 403, 64, 19);
		
		Button btnValider_1 = new Button(shlMesTroncons, SWT.NONE);
		btnValider_1.setText("Valider");
		btnValider_1.setBounds(620, 397, 70, 27);

	}
	
	protected void ChangeWindow() {
		changeWindow = true;
		shlMesTroncons.close();
		changeWindow = false;
	}

}
