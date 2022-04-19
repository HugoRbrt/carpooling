package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class PaiementTroncon {

	protected Shell shlPaiementTroncon;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PaiementTroncon window = new PaiementTroncon();
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
		shlPaiementTroncon.setSize(700, 500);
		shlPaiementTroncon.setText("Paiement Tronçon - VerbiageVoiture");
		
		Label lblPaiementTrononXxx = new Label(shlPaiementTroncon, SWT.NONE);
		lblPaiementTrononXxx.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblPaiementTrononXxx.setBounds(206, 39, 293, 34);
		lblPaiementTrononXxx.setText("Paiement tronçon xxx");
		
		Label lblSolde = new Label(shlPaiementTroncon, SWT.NONE);
		lblSolde.setAlignment(SWT.RIGHT);
		lblSolde.setFont(SWTResourceManager.getFont("Arial", 20, SWT.BOLD));
		lblSolde.setBounds(275, 140, 59, 34);
		lblSolde.setText("Solde");
		
		Label lblXx = new Label(shlPaiementTroncon, SWT.NONE);
		lblXx.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblXx.setBounds(396, 140, 150, 34);
		lblXx.setText("xx €");
		
		Label lblPrixPayer = new Label(shlPaiementTroncon, SWT.NONE);
		lblPrixPayer.setAlignment(SWT.RIGHT);
		lblPrixPayer.setText("Prix à payer");
		lblPrixPayer.setFont(SWTResourceManager.getFont("Arial", 20, SWT.BOLD));
		lblPrixPayer.setBounds(203, 203, 131, 34);
		
		Label lblXx_1 = new Label(shlPaiementTroncon, SWT.NONE);
		lblXx_1.setText("xx €");
		lblXx_1.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblXx_1.setBounds(396, 203, 150, 34);
		
		Button btnPayer = new Button(shlPaiementTroncon, SWT.NONE);
		btnPayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Message window = new Message("Vous ne possédez pas un solde suffisant pour pouvoir payer ce tronçon !");
				window.open();
			}
		});
		btnPayer.setBounds(238, 324, 96, 27);
		btnPayer.setText("Payer");
		
		Button btnRecharger = new Button(shlPaiementTroncon, SWT.NONE);
		btnRecharger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlPaiementTroncon.close();
				Solde window = new Solde();
				window.open();
			}
		});
		btnRecharger.setBounds(396, 324, 96, 27);
		btnRecharger.setText("Recharger");
		
		Button btnAnnuler = new Button(shlPaiementTroncon, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlPaiementTroncon.close();
				ListeTroncons window = new ListeTroncons();
				window.open();
			}
		});
		btnAnnuler.setBounds(590, 430, 96, 27);
		btnAnnuler.setText("Annuler");

	}

}
