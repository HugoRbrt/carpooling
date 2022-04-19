package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ListeTrajets {

	protected Shell shlMesTrajets;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListeTrajets window = new ListeTrajets();
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
		shlMesTrajets.open();
		shlMesTrajets.layout();
		while (!shlMesTrajets.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMesTrajets = new Shell();
		shlMesTrajets.setSize(700, 500);
		shlMesTrajets.setText("Mes trajets - VerbiageVoiture");
		
		Label lblMesTrajets = new Label(shlMesTrajets, SWT.NONE);
		lblMesTrajets.setText("Mes trajets");
		lblMesTrajets.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblMesTrajets.setAlignment(SWT.CENTER);
		lblMesTrajets.setBounds(173, 50, 344, 57);
		
		Label lblListeDesTrajets = new Label(shlMesTrajets, SWT.WRAP);
		lblListeDesTrajets.setText("Liste des trajets incluant les tronçons retournée grâce à la méthode toString()");
		lblListeDesTrajets.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblListeDesTrajets.setBounds(10, 110, 680, 290);
		
		Button btnRetour = new Button(shlMesTrajets, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesTrajets.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnRetour.setText("Retour");
		btnRetour.setBounds(594, 433, 96, 27);
		
		Button btnAjouterUnTrajet = new Button(shlMesTrajets, SWT.NONE);
		btnAjouterUnTrajet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesTrajets.close();
				AjoutTrajet window = new AjoutTrajet();
				window.open();
			}
		});
		btnAjouterUnTrajet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAjouterUnTrajet.setText("Ajouter un trajet");
		btnAjouterUnTrajet.setBounds(10, 433, 130, 27);
		
		Label lblConfirmationDpartTrajet = new Label(shlMesTrajets, SWT.NONE);
		lblConfirmationDpartTrajet.setAlignment(SWT.RIGHT);
		lblConfirmationDpartTrajet.setBounds(10, 407, 170, 20);
		lblConfirmationDpartTrajet.setText("Confirmation départ trajet n°");
		
		text = new Text(shlMesTrajets, SWT.BORDER);
		text.setBounds(186, 406, 64, 19);
		
		Button btnValider = new Button(shlMesTrajets, SWT.NONE);
		btnValider.setBounds(253, 400, 70, 27);
		btnValider.setText("Valider");
		
		Label lblConfirmationArriveTrajet = new Label(shlMesTrajets, SWT.NONE);
		lblConfirmationArriveTrajet.setAlignment(SWT.RIGHT);
		lblConfirmationArriveTrajet.setText("Confirmation arrivée trajet n°");
		lblConfirmationArriveTrajet.setBounds(387, 407, 170, 20);
		
		text_1 = new Text(shlMesTrajets, SWT.BORDER);
		text_1.setBounds(563, 406, 64, 19);
		
		Button btnValider_1 = new Button(shlMesTrajets, SWT.NONE);
		btnValider_1.setText("Valider");
		btnValider_1.setBounds(630, 400, 70, 27);
		
		Label lblAnnulationTrajetN = new Label(shlMesTrajets, SWT.NONE);
		lblAnnulationTrajetN.setText("Annulation trajet n°");
		lblAnnulationTrajetN.setAlignment(SWT.RIGHT);
		lblAnnulationTrajetN.setBounds(210, 440, 120, 20);
		
		text_2 = new Text(shlMesTrajets, SWT.BORDER);
		text_2.setBounds(334, 435, 64, 19);
		
		Button btnValider_2 = new Button(shlMesTrajets, SWT.NONE);
		btnValider_2.setText("Valider");
		btnValider_2.setBounds(404, 433, 70, 27);

	}

}
