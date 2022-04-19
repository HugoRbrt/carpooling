package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AjoutVehicule {

	protected Shell shlNouveauVehicule;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AjoutVehicule window = new AjoutVehicule();
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
		shlNouveauVehicule.open();
		shlNouveauVehicule.layout();
		while (!shlNouveauVehicule.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNouveauVehicule = new Shell();
		shlNouveauVehicule.setSize(700, 500);
		shlNouveauVehicule.setText("Nouveau véhicule - VerbiageVoiture");
		
		Label lblNouveauVhicule = new Label(shlNouveauVehicule, SWT.NONE);
		lblNouveauVhicule.setAlignment(SWT.CENTER);
		lblNouveauVhicule.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblNouveauVhicule.setBounds(168, 43, 357, 56);
		lblNouveauVhicule.setText("Nouveau véhicule");
		
		Label lblEmail = new Label(shlNouveauVehicule, SWT.NONE);
		lblEmail.setText("Immatriculation");
		lblEmail.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(53, 105, 174, 29);
		
		text = new Text(shlNouveauVehicule, SWT.BORDER);
		text.setBounds(245, 110, 300, 20);
		
		Label lblMarque = new Label(shlNouveauVehicule, SWT.NONE);
		lblMarque.setText("Marque");
		lblMarque.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblMarque.setAlignment(SWT.RIGHT);
		lblMarque.setBounds(120, 150, 107, 29);
		
		text_1 = new Text(shlNouveauVehicule, SWT.BORDER);
		text_1.setBounds(245, 155, 300, 20);
		
		Label lblModle = new Label(shlNouveauVehicule, SWT.NONE);
		lblModle.setText("Modèle");
		lblModle.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblModle.setAlignment(SWT.RIGHT);
		lblModle.setBounds(120, 201, 107, 29);
		
		text_2 = new Text(shlNouveauVehicule, SWT.BORDER);
		text_2.setBounds(245, 206, 300, 20);
		
		Label lblPuissanceFiscale = new Label(shlNouveauVehicule, SWT.NONE);
		lblPuissanceFiscale.setText("Puissance fiscale");
		lblPuissanceFiscale.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblPuissanceFiscale.setAlignment(SWT.RIGHT);
		lblPuissanceFiscale.setBounds(53, 250, 174, 29);
		
		text_3 = new Text(shlNouveauVehicule, SWT.BORDER);
		text_3.setBounds(245, 255, 150, 20);
		
		Label lblnergieUtlise = new Label(shlNouveauVehicule, SWT.NONE);
		lblnergieUtlise.setText("Énergie utlisée");
		lblnergieUtlise.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblnergieUtlise.setAlignment(SWT.RIGHT);
		lblnergieUtlise.setBounds(37, 299, 190, 29);
		
		Label lblNombreDePlaces = new Label(shlNouveauVehicule, SWT.NONE);
		lblNombreDePlaces.setText("Nombre de places");
		lblNombreDePlaces.setFont(SWTResourceManager.getFont("Arial", 20, SWT.NORMAL));
		lblNombreDePlaces.setAlignment(SWT.RIGHT);
		lblNombreDePlaces.setBounds(37, 348, 190, 29);
		
		text_5 = new Text(shlNouveauVehicule, SWT.BORDER);
		text_5.setBounds(245, 353, 300, 20);
		
		Label lblCv = new Label(shlNouveauVehicule, SWT.NONE);
		lblCv.setFont(SWTResourceManager.getFont("Arial", 16, SWT.NORMAL));
		lblCv.setBounds(401, 254, 67, 24);
		lblCv.setText("cv");
		
		Combo combo = new Combo(shlNouveauVehicule, SWT.READ_ONLY);
		combo.setItems(new String[] {"Essence", "Diesel", "Hybride", "Électrique"});
		combo.setBounds(245, 306, 150, 22);
		
		Button btnAjouter = new Button(shlNouveauVehicule, SWT.NONE);
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlNouveauVehicule.close();
				ListeVehicules window = new ListeVehicules();
				window.open();
			}
		});
		btnAjouter.setBounds(10, 431, 96, 27);
		btnAjouter.setText("Ajouter");
		
		Button btnAnnuler = new Button(shlNouveauVehicule, SWT.NONE);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlNouveauVehicule.close();
				ListeVehicules window = new ListeVehicules();
				window.open();
			}
		});
		btnAnnuler.setBounds(590, 431, 96, 27);
		btnAnnuler.setText("Annuler");

	}
}
