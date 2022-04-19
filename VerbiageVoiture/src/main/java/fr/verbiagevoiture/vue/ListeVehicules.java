package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ListeVehicules {

	protected Shell shlMesVehicules;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListeVehicules window = new ListeVehicules();
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
		shlMesVehicules.open();
		shlMesVehicules.layout();
		while (!shlMesVehicules.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMesVehicules = new Shell();
		shlMesVehicules.setSize(700, 500);
		shlMesVehicules.setText("Mes véhicules - VerbiageVoiture");
		
		Label lblMesVhicules = new Label(shlMesVehicules, SWT.NONE);
		lblMesVhicules.setAlignment(SWT.CENTER);
		lblMesVhicules.setFont(SWTResourceManager.getFont("Arial", 30, SWT.NORMAL));
		lblMesVhicules.setBounds(173, 53, 344, 57);
		lblMesVhicules.setText("Mes véhicules");
		
		Label lblNewLabel = new Label(shlMesVehicules, SWT.WRAP);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblNewLabel.setBounds(10, 113, 680, 300);
		lblNewLabel.setText("Liste des véhicules retournée grâce à la méthode toString()");
		
		Button btnRetour = new Button(shlMesVehicules, SWT.NONE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesVehicules.close();
				MenuPrincipal window = new MenuPrincipal();
				window.open();
			}
		});
		btnRetour.setBounds(594, 436, 96, 27);
		btnRetour.setText("Retour");
		
		Button btnAjouterUnVhicule = new Button(shlMesVehicules, SWT.NONE);
		btnAjouterUnVhicule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMesVehicules.close();
				AjoutVehicule window = new AjoutVehicule();
				window.open();
			}
		});
		btnAjouterUnVhicule.setBounds(10, 436, 150, 27);
		btnAjouterUnVhicule.setText("Ajouter un véhicule");

	}

}
