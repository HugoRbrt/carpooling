package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class WelcomeScreen {

	protected Shell shlVerbiagevoiture;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
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
				shlVerbiagevoiture.close();
				LoginPage window = new LoginPage();
				window.open();
			}
		});
		btnSeConnecter.setBounds(285, 197, 120, 40);
		btnSeConnecter.setText("Se connecter");
		
		Button btnSenregistrer = new Button(shlVerbiagevoiture, SWT.NONE);
		btnSenregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlVerbiagevoiture.close();
				SignUpScreen window = new SignUpScreen();
				window.open();

			}
		});
		btnSenregistrer.setBounds(285, 275, 120, 40);
		btnSenregistrer.setText("S'enregistrer");

	}
}
