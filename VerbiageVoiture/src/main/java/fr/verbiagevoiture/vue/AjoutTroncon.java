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

public class AjoutTroncon {

	protected Shell shlNouveauTroncon;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AjoutTroncon window = new AjoutTroncon();
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
		shlNouveauTroncon.open();
		shlNouveauTroncon.layout();
		while (!shlNouveauTroncon.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNouveauTroncon = new Shell();
		shlNouveauTroncon.setSize(700, 500);
		shlNouveauTroncon.setText("Nouveau tronçon - VerbiageVoiture");
		
		Label lblNouveauTronon = new Label(shlNouveauTroncon, SWT.NONE);
		lblNouveauTronon.setAlignment(SWT.CENTER);
		lblNouveauTronon.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblNouveauTronon.setBounds(210, 44, 291, 47);
		lblNouveauTronon.setText("Nouveau tronçon");
		
		Label lblVilleDeDpart = new Label(shlNouveauTroncon, SWT.NONE);
		lblVilleDeDpart.setText("Ville de départ");
		lblVilleDeDpart.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblVilleDeDpart.setAlignment(SWT.RIGHT);
		lblVilleDeDpart.setBounds(65, 111, 236, 29);
		
		text = new Text(shlNouveauTroncon, SWT.BORDER);
		text.setBounds(307, 116, 250, 20);
		
		Label lblVilleDarrive = new Label(shlNouveauTroncon, SWT.NONE);
		lblVilleDarrive.setText("Ville d'arrivée");
		lblVilleDarrive.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblVilleDarrive.setAlignment(SWT.RIGHT);
		lblVilleDarrive.setBounds(65, 157, 236, 29);
		
		text_1 = new Text(shlNouveauTroncon, SWT.BORDER);
		text_1.setBounds(307, 162, 250, 20);
		
		Label lblCoordonnesGpsDe = new Label(shlNouveauTroncon, SWT.NONE);
		lblCoordonnesGpsDe.setText("Coordonnées GPS de départ");
		lblCoordonnesGpsDe.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblCoordonnesGpsDe.setAlignment(SWT.RIGHT);
		lblCoordonnesGpsDe.setBounds(10, 203, 291, 29);
		
		text_2 = new Text(shlNouveauTroncon, SWT.BORDER);
		text_2.setBounds(307, 208, 250, 20);
		
		Label lblCoordonnesGpsDarrive = new Label(shlNouveauTroncon, SWT.NONE);
		lblCoordonnesGpsDarrive.setText("Coordonnées GPS d'arrivée");
		lblCoordonnesGpsDarrive.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblCoordonnesGpsDarrive.setAlignment(SWT.RIGHT);
		lblCoordonnesGpsDarrive.setBounds(10, 248, 291, 29);
		
		text_3 = new Text(shlNouveauTroncon, SWT.BORDER);
		text_3.setBounds(307, 253, 250, 20);
		
		Label lblDistanceParcourue = new Label(shlNouveauTroncon, SWT.NONE);
		lblDistanceParcourue.setText("Distance parcourue");
		lblDistanceParcourue.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblDistanceParcourue.setAlignment(SWT.RIGHT);
		lblDistanceParcourue.setBounds(65, 293, 236, 29);
		
		text_4 = new Text(shlNouveauTroncon, SWT.BORDER);
		text_4.setBounds(307, 298, 250, 20);
		
		Label lblTempsDeParcours = new Label(shlNouveauTroncon, SWT.NONE);
		lblTempsDeParcours.setText("Temps de parcours estimé");
		lblTempsDeParcours.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblTempsDeParcours.setAlignment(SWT.RIGHT);
		lblTempsDeParcours.setBounds(31, 338, 270, 29);
		
		text_5 = new Text(shlNouveauTroncon, SWT.BORDER);
		text_5.setBounds(307, 343, 250, 20);
		
		Button btnNewButton = new Button(shlNouveauTroncon, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlNouveauTroncon.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnNewButton.setBounds(590, 430, 96, 27);
		btnNewButton.setText("Valider");
		
		Label lblDureDattenteMax = new Label(shlNouveauTroncon, SWT.NONE);
		lblDureDattenteMax.setText("Durée d'attente max départ");
		lblDureDattenteMax.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblDureDattenteMax.setAlignment(SWT.RIGHT);
		lblDureDattenteMax.setBounds(31, 381, 270, 29);
		
		text_6 = new Text(shlNouveauTroncon, SWT.BORDER);
		text_6.setBounds(307, 386, 250, 20);

	}

}
