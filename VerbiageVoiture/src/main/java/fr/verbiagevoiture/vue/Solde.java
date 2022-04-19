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

public class Solde {

	protected Shell shlMonSolde;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Solde window = new Solde();
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
		shlMonSolde.open();
		shlMonSolde.layout();
		while (!shlMonSolde.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMonSolde = new Shell();
		shlMonSolde.setSize(700, 500);
		shlMonSolde.setText("Mon solde - VerbiageVoiture");
		
		Label lblSoldeActuel = new Label(shlMonSolde, SWT.NONE);
		lblSoldeActuel.setAlignment(SWT.CENTER);
		lblSoldeActuel.setFont(SWTResourceManager.getFont("Arial", 30, SWT.BOLD));
		lblSoldeActuel.setBounds(212, 76, 259, 57);
		lblSoldeActuel.setText("Solde actuel");
		
		Label lblXx = new Label(shlMonSolde, SWT.NONE);
		lblXx.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblXx.setAlignment(SWT.CENTER);
		lblXx.setBounds(281, 139, 132, 40);
		lblXx.setText("xx €");
		
		Label lblRecharger = new Label(shlMonSolde, SWT.NONE);
		lblRecharger.setText("Recharger");
		lblRecharger.setFont(SWTResourceManager.getFont("Arial", 30, SWT.BOLD));
		lblRecharger.setAlignment(SWT.CENTER);
		lblRecharger.setBounds(212, 229, 259, 57);
		
		text = new Text(shlMonSolde, SWT.BORDER);
		text.setBounds(234, 302, 64, 19);
		
		Label label = new Label(shlMonSolde, SWT.NONE);
		label.setBounds(303, 305, 33, 14);
		label.setText("€");
		
		Button btnRecharger = new Button(shlMonSolde, SWT.NONE);
		btnRecharger.setBounds(348, 300, 96, 27);
		btnRecharger.setText("Recharger");
		
		Button btnOk = new Button(shlMonSolde, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMonSolde.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnOk.setBounds(566, 425, 96, 27);
		btnOk.setText("OK");

	}

}
