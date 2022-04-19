package fr.verbiagevoiture.vue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Message {

	protected Shell shlMessage;
	
	String msg;
	
	public Message(String msg) {
		this.msg = String.copyValueOf(msg.toCharArray());
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Message window = new Message("Programme lancé depuis la classe Message");
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
		shlMessage.open();
		shlMessage.layout();
		while (!shlMessage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMessage = new Shell();
		shlMessage.setSize(450, 300);
		shlMessage.setText("Message - VerbiageVoiture");
		
		Label lblVousNePouvez = new Label(shlMessage, SWT.WRAP);
		lblVousNePouvez.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblVousNePouvez.setAlignment(SWT.CENTER);
		lblVousNePouvez.setBounds(10, 44, 430, 190);
		lblVousNePouvez.setText(msg);
		
		Button btnOk = new Button(shlMessage, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMessage.close();
			}
		});
		btnOk.setBounds(344, 240, 96, 27);
		btnOk.setText("OK");

	}

}
