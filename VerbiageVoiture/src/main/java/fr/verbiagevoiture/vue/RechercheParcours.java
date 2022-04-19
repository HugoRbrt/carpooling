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

public class RechercheParcours {

	protected Shell shlRechercheParcours;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RechercheParcours window = new RechercheParcours();
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
		shlRechercheParcours.open();
		shlRechercheParcours.layout();
		while (!shlRechercheParcours.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRechercheParcours = new Shell();
		shlRechercheParcours.setSize(700, 500);
		shlRechercheParcours.setText("Recherche parcours - VerbiageVoiture");
		
		Label lblRechercheParcours = new Label(shlRechercheParcours, SWT.NONE);
		lblRechercheParcours.setAlignment(SWT.CENTER);
		lblRechercheParcours.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblRechercheParcours.setBounds(201, 38, 301, 42);
		lblRechercheParcours.setText("Recherche parcours");
		
		Label lblVilleDeDpart = new Label(shlRechercheParcours, SWT.NONE);
		lblVilleDeDpart.setText("Ville de départ");
		lblVilleDeDpart.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblVilleDeDpart.setAlignment(SWT.RIGHT);
		lblVilleDeDpart.setBounds(116, 117, 236, 29);
		
		text = new Text(shlRechercheParcours, SWT.BORDER);
		text.setBounds(358, 122, 250, 20);
		
		Label lblVilleDarrive = new Label(shlRechercheParcours, SWT.NONE);
		lblVilleDarrive.setText("Ville d'arrivée");
		lblVilleDarrive.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblVilleDarrive.setAlignment(SWT.RIGHT);
		lblVilleDarrive.setBounds(116, 163, 236, 29);
		
		text_1 = new Text(shlRechercheParcours, SWT.BORDER);
		text_1.setBounds(358, 168, 250, 20);
		
		Label lblCoordonnesGpsDe = new Label(shlRechercheParcours, SWT.NONE);
		lblCoordonnesGpsDe.setText("Coordonnées GPS de départ");
		lblCoordonnesGpsDe.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblCoordonnesGpsDe.setAlignment(SWT.RIGHT);
		lblCoordonnesGpsDe.setBounds(61, 254, 291, 29);
		
		text_2 = new Text(shlRechercheParcours, SWT.BORDER);
		text_2.setBounds(358, 259, 250, 20);
		
		Label lblCoordonnesGpsDarrive = new Label(shlRechercheParcours, SWT.NONE);
		lblCoordonnesGpsDarrive.setText("Coordonnées GPS d'arrivée");
		lblCoordonnesGpsDarrive.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblCoordonnesGpsDarrive.setAlignment(SWT.RIGHT);
		lblCoordonnesGpsDarrive.setBounds(61, 299, 291, 29);
		
		text_3 = new Text(shlRechercheParcours, SWT.BORDER);
		text_3.setBounds(358, 304, 250, 20);
		
		Label lblEtou = new Label(shlRechercheParcours, SWT.NONE);
		lblEtou.setAlignment(SWT.CENTER);
		lblEtou.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEtou.setBounds(328, 212, 70, 28);
		lblEtou.setText("ET/OU");
		
		Button btnRechercher = new Button(shlRechercheParcours, SWT.NONE);
		btnRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlRechercheParcours.close();
				ResultatsRecherche window = new ResultatsRecherche();
				window.open();
			}
		});
		btnRechercher.setBounds(10, 430, 96, 27);
		btnRechercher.setText("Rechercher");
		
		Button btnAnnuler = new Button(shlRechercheParcours, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlRechercheParcours.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnAnnuler.setBounds(590, 430, 96, 27);
		btnAnnuler.setText("Annuler");

	}

}
