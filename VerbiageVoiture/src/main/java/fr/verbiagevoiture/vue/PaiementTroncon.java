package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;

public class PaiementTroncon {

	protected Shell shlPaiementTroncon;
	protected static MyConnection myco;
	private ArrayList<int []> res;
	private int idTrajet;
	private int num_troncon;
	protected float prix;
	float monSolde;
	protected boolean changeWindow = false;

	public PaiementTroncon (MyConnection m, float value, ArrayList<int []> r, int id, int num) {
		num_troncon = num;
		idTrajet = id;
		res = r;
		prix = value;
		myco = m;
		monSolde = Float.parseFloat(myco.AfficherSolde());
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PaiementTroncon window = new PaiementTroncon(new MyConnection(), 0, null, -1, 0);
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
		shlPaiementTroncon.open();
		shlPaiementTroncon.layout();
		while (!shlPaiementTroncon.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPaiementTroncon = new Shell();
		shlPaiementTroncon.addListener(SWT.Close, new Listener() {
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
		shlPaiementTroncon.setSize(700, 500);
		shlPaiementTroncon.setText("Paiement Tronçon - VerbiageVoiture");
		
		Label lblPaiementTrononXxx = new Label(shlPaiementTroncon, SWT.NONE);
		lblPaiementTrononXxx.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblPaiementTrononXxx.setBounds(206, 39, 293, 34);
		lblPaiementTrononXxx.setText("Paiement tronçon " + idTrajet + "." + num_troncon);
		
		Label lblSolde = new Label(shlPaiementTroncon, SWT.NONE);
		lblSolde.setAlignment(SWT.RIGHT);
		lblSolde.setFont(SWTResourceManager.getFont("Arial", 20, SWT.BOLD));
		lblSolde.setBounds(275, 140, 59, 34);
		lblSolde.setText("Solde");
		
		Label lblXx = new Label(shlPaiementTroncon, SWT.NONE);
		lblXx.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblXx.setBounds(396, 140, 150, 34);
		lblXx.setText(monSolde+" €");
		
		Label lblPrixPayer = new Label(shlPaiementTroncon, SWT.NONE);
		lblPrixPayer.setAlignment(SWT.RIGHT);
		lblPrixPayer.setText("Prix à payer");
		lblPrixPayer.setFont(SWTResourceManager.getFont("Arial", 20, SWT.BOLD));
		lblPrixPayer.setBounds(203, 203, 131, 34);
		
		Label lblXx_1 = new Label(shlPaiementTroncon, SWT.NONE);
		lblXx_1.setText(prix+" €");
		lblXx_1.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblXx_1.setBounds(396, 203, 150, 34);
		
		Button btnPayer = new Button(shlPaiementTroncon, SWT.NONE);
		btnPayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				
				if(monSolde>=prix) {

					myco.DebiterSolde(prix);
					for(int i=0;i<res.size();i++) {
						if(res.get(i)[0]==idTrajet && res.get(i)[1]==num_troncon){
							myco.deleteEmprunte(res.get(i)[1],res.get(i)[0]);
						}
					}
					
					ChangeWindow();
					MenuPrincipal window = new MenuPrincipal(myco);
					window.open();
				}
				else {
					
					Message window = new Message("Vous ne possédez pas un solde suffisant pour pouvoir payer ce tronçon !");
					window.open();

					ChangeWindow();
					Solde window2 = new Solde(myco);
					window2.open();
				}
			}
		});
		btnPayer.setBounds(238, 324, 96, 27);
		btnPayer.setText("Payer");
		
		Button btnRecharger = new Button(shlPaiementTroncon, SWT.NONE);
		btnRecharger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				Solde window = new Solde(myco);
				window.open();
			}
		});
		btnRecharger.setBounds(396, 324, 96, 27);
		btnRecharger.setText("Recharger");
		
		Button btnAnnuler = new Button(shlPaiementTroncon, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ChangeWindow();
				ListeTroncons window = new ListeTroncons(myco);
				window.open();
			}
		});
		btnAnnuler.setBounds(590, 430, 96, 27);
		btnAnnuler.setText("Annuler");

	}

	protected void ChangeWindow() {
		changeWindow = true;
		shlPaiementTroncon.close();
		changeWindow = false;
	}

}
