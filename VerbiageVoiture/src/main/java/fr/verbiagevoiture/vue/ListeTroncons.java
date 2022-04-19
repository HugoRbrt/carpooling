package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ListeTroncons {

	protected Shell shlMesTroncons;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListeTroncons window = new ListeTroncons();
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
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 430, 96, 27);
		
		Label lblPayerLeTronon = new Label(shlMesTroncons, SWT.NONE);
		lblPayerLeTronon.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblPayerLeTronon.setBounds(10, 432, 140, 19);
		lblPayerLeTronon.setText("Payer le tronçon n°");
		
		text = new Text(shlMesTroncons, SWT.BORDER);
		text.setBounds(144, 438, 100, 19);
		
		Button btnNewButton = new Button(shlMesTroncons, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesTroncons.close();
				PaiementTroncon window = new PaiementTroncon();
				window.open();
			}
		});
		btnNewButton.setBounds(250, 430, 96, 27);
		btnNewButton.setText("Payer");
		
		Label lblConfirmationMonteTronon = new Label(shlMesTroncons, SWT.NONE);
		lblConfirmationMonteTronon.setText("Confirmation montée tronçon n°");
		lblConfirmationMonteTronon.setAlignment(SWT.RIGHT);
		lblConfirmationMonteTronon.setBounds(10, 404, 193, 20);
		
		text_1 = new Text(shlMesTroncons, SWT.BORDER);
		text_1.setBounds(209, 403, 64, 19);
		
		Button btnValider = new Button(shlMesTroncons, SWT.NONE);
		btnValider.setText("Valider");
		btnValider.setBounds(276, 397, 70, 27);
		
		Label lblConfirmationDescenteTronon = new Label(shlMesTroncons, SWT.NONE);
		lblConfirmationDescenteTronon.setText("Confirmation descente tronçon n°");
		lblConfirmationDescenteTronon.setAlignment(SWT.RIGHT);
		lblConfirmationDescenteTronon.setBounds(352, 404, 195, 20);
		
		text_2 = new Text(shlMesTroncons, SWT.BORDER);
		text_2.setBounds(553, 403, 64, 19);
		
		Button btnValider_1 = new Button(shlMesTroncons, SWT.NONE);
		btnValider_1.setText("Valider");
		btnValider_1.setBounds(620, 397, 70, 27);

	}

}
