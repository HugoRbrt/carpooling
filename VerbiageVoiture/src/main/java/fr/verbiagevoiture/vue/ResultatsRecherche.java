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

public class ResultatsRecherche {

	protected Shell shlResultatsRecherche;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ResultatsRecherche window = new ResultatsRecherche();
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
		shlResultatsRecherche.open();
		shlResultatsRecherche.layout();
		while (!shlResultatsRecherche.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlResultatsRecherche = new Shell();
		shlResultatsRecherche.setSize(700, 500);
		shlResultatsRecherche.setText("Résultats recherche - VerbiageVoiture");
		
		Label lblRsultatsRecherche = new Label(shlResultatsRecherche, SWT.NONE);
		lblRsultatsRecherche.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblRsultatsRecherche.setBounds(217, 44, 271, 34);
		lblRsultatsRecherche.setText("Résultats recherche");
		
		Label lblListeDesTrajets = new Label(shlResultatsRecherche, SWT.WRAP);
		lblListeDesTrajets.setText("Liste des parcours possibles retournée grâce à la méthode toString()");
		lblListeDesTrajets.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblListeDesTrajets.setBounds(10, 84, 680, 300);
		
		Button btnRetour = new Button(shlResultatsRecherche, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlResultatsRecherche.close();
				RechercheParcours window = new RechercheParcours();
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 423, 96, 27);
		
		Label lblRserverLeParcours = new Label(shlResultatsRecherche, SWT.NONE);
		lblRserverLeParcours.setAlignment(SWT.RIGHT);
		lblRserverLeParcours.setText("Réserver le parcours n°");
		lblRserverLeParcours.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblRserverLeParcours.setBounds(10, 425, 174, 19);
		
		text = new Text(shlResultatsRecherche, SWT.BORDER);
		text.setBounds(190, 431, 100, 19);
		
		Button btnNewButton = new Button(shlResultatsRecherche, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlResultatsRecherche.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnNewButton.setText("Réserver");
		btnNewButton.setBounds(296, 423, 96, 27);

	}

}
