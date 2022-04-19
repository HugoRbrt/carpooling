package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AjoutTrajet {

	protected Shell shlNouveauTrajet;
	private Text text_2;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AjoutTrajet window = new AjoutTrajet();
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
		shlNouveauTrajet.open();
		shlNouveauTrajet.layout();
		while (!shlNouveauTrajet.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNouveauTrajet = new Shell();
		shlNouveauTrajet.setSize(700, 500);
		shlNouveauTrajet.setText("Nouveau trajet - VerbiageVoiture");
		
		Label lblNouveauTrajet = new Label(shlNouveauTrajet, SWT.NONE);
		lblNouveauTrajet.setAlignment(SWT.CENTER);
		lblNouveauTrajet.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblNouveauTrajet.setBounds(192, 51, 321, 49);
		lblNouveauTrajet.setText("Nouveau trajet");
		
		Label lblEmail = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail.setText("Date de départ");
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(80, 126, 216, 29);
		
		Label lblEmail_1 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1.setText("Heure de départ");
		lblEmail_1.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1.setAlignment(SWT.RIGHT);
		lblEmail_1.setBounds(80, 174, 216, 29);
		
		Label lblEmail_1_1 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1_1.setText("Nombre de places au départ");
		lblEmail_1_1.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1_1.setAlignment(SWT.RIGHT);
		lblEmail_1_1.setBounds(10, 223, 286, 29);
		
		text_2 = new Text(shlNouveauTrajet, SWT.BORDER);
		text_2.setBounds(302, 228, 270, 20);
		
		Label lblEmail_1_2 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1_2.setText("Véhicule");
		lblEmail_1_2.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1_2.setAlignment(SWT.RIGHT);
		lblEmail_1_2.setBounds(80, 273, 216, 29);
		
		Label lblEmail_1_3 = new Label(shlNouveauTrajet, SWT.NONE);
		lblEmail_1_3.setText("Nombre de tronçons du trajet");
		lblEmail_1_3.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail_1_3.setAlignment(SWT.RIGHT);
		lblEmail_1_3.setBounds(10, 323, 286, 29);
		
		text_4 = new Text(shlNouveauTrajet, SWT.BORDER);
		text_4.setBounds(302, 328, 270, 20);
		
		Combo combo = new Combo(shlNouveauTrajet, SWT.READ_ONLY);
		combo.setItems(new String[] {"Voiture 1", "Voiture 2", "Voiture 3"});
		combo.setBounds(302, 273, 270, 22);
		
		DateTime dateTime = new DateTime(shlNouveauTrajet, SWT.BORDER);
		dateTime.setBounds(302, 127, 270, 28);
		
		DateTime dateTime_1 = new DateTime(shlNouveauTrajet, SWT.BORDER | SWT.TIME | SWT.SHORT);
		dateTime_1.setBounds(302, 174, 270, 28);
		
		Button btnSuivant = new Button(shlNouveauTrajet, SWT.NONE);
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlNouveauTrajet.close();
				AjoutTroncon window = new AjoutTroncon();
				window.open();
			}
		});
		btnSuivant.setText("Suivant");
		btnSuivant.setBounds(10, 436, 96, 27);
		
		Button btnAnnuler = new Button(shlNouveauTrajet, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlNouveauTrajet.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnAnnuler.setText("Annuler");
		btnAnnuler.setBounds(590, 436, 96, 27);

	}
}
