package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class SignUpScreen {

	protected Shell shlSenregistrer;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SignUpScreen window = new SignUpScreen();
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
		shlSenregistrer.setSize(700, 500);
		shlSenregistrer.setText("S'enregistrer - VerbiageVoiture");
		
		Label lblEmail = new Label(shlSenregistrer, SWT.NONE);
		lblEmail.setText("E-mail");
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(121, 92, 107, 29);
		
		text = new Text(shlSenregistrer, SWT.BORDER);
		text.setBounds(246, 97, 300, 20);
		
		Label lblNom = new Label(shlSenregistrer, SWT.NONE);
		lblNom.setText("Nom");
		lblNom.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblNom.setAlignment(SWT.RIGHT);
		lblNom.setBounds(121, 149, 107, 29);
		
		text_1 = new Text(shlSenregistrer, SWT.BORDER);
		text_1.setBounds(246, 154, 300, 20);
		
		Label lblPrnom = new Label(shlSenregistrer, SWT.NONE);
		lblPrnom.setText("Prénom");
		lblPrnom.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblPrnom.setAlignment(SWT.RIGHT);
		lblPrnom.setBounds(121, 206, 107, 29);
		
		text_2 = new Text(shlSenregistrer, SWT.BORDER);
		text_2.setBounds(246, 211, 300, 20);
		
		Label lblVilleDeRsidence = new Label(shlSenregistrer, SWT.NONE);
		lblVilleDeRsidence.setText("Ville de résidence");
		lblVilleDeRsidence.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblVilleDeRsidence.setAlignment(SWT.RIGHT);
		lblVilleDeRsidence.setBounds(39, 261, 189, 29);
		
		text_3 = new Text(shlSenregistrer, SWT.BORDER);
		text_3.setBounds(246, 266, 300, 20);
		
		Label lblMotDePasse = new Label(shlSenregistrer, SWT.NONE);
		lblMotDePasse.setText("Mot de passe");
		lblMotDePasse.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblMotDePasse.setAlignment(SWT.CENTER);
		lblMotDePasse.setBounds(99, 318, 129, 29);
		
		text_4 = new Text(shlSenregistrer, SWT.BORDER | SWT.PASSWORD);
		text_4.setBounds(246, 323, 300, 20);
		
		Button btnSenregistrer = new Button(shlSenregistrer, SWT.NONE);
		btnSenregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlSenregistrer.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnSenregistrer.setText("S'enregistrer");
		btnSenregistrer.setBounds(298, 396, 120, 27);

	}

}
