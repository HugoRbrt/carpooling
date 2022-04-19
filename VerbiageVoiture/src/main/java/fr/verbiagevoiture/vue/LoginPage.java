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

public class LoginPage {

	protected Shell shlSeConnecter;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginPage window = new LoginPage();
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
		shlSeConnecter.setSize(700, 500);
		shlSeConnecter.setText("Se connecter - VerbiageVoiture");
		
		Label lblEmail = new Label(shlSeConnecter, SWT.NONE);
		lblEmail.setAlignment(SWT.CENTER);
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setBounds(128, 164, 107, 29);
		lblEmail.setText("E-mail");
		
		text = new Text(shlSeConnecter, SWT.BORDER);
		text.setBounds(253, 169, 300, 20);
		
		Label lblMotDePasse = new Label(shlSeConnecter, SWT.NONE);
		lblMotDePasse.setText("Mot de passe");
		lblMotDePasse.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblMotDePasse.setAlignment(SWT.CENTER);
		lblMotDePasse.setBounds(106, 232, 129, 29);
		
		text_1 = new Text(shlSeConnecter, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(253, 237, 300, 20);
		
		Button btnSeConnecter = new Button(shlSeConnecter, SWT.NONE);
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlSeConnecter.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnSeConnecter.setBounds(289, 368, 120, 27);
		btnSeConnecter.setText("Se connecter");

	}
}
