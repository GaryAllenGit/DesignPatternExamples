import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class PCS_DemoGUI extends javax.swing.JFrame implements Runnable, PropertyChangeListener {
	private JTextField sharedTextTF;
	private PCS_SharedString sharedText;

	@Override
	public void run() {
		this.setVisible(true);
	}

	public PCS_DemoGUI(PCS_SharedString initialSharedText) {
		// initialise the shared string and add 'this' GUI as an observer to it
		sharedText = initialSharedText;

		initGUI();
		updateSharedTextTF(sharedText.getTheString());
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setTitle("GUI Threads Demo");

		JButton setButton = new JButton();
		getContentPane().add(setButton);
		setButton.setText("Set Shared Text");
		setButton.setBounds(31, 35, 157, 28);
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sharedText.setTheString(sharedTextTF.getText());
			}
		});

		sharedTextTF = new JTextField();
		getContentPane().add(sharedTextTF);
		sharedTextTF.setBounds(199, 34, 160, 31);

		pack();
		this.setSize(387, 156);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// the method called when the shared string changes - update the GUI
		updateSharedTextTF((String) evt.getNewValue());
	}

	private void updateSharedTextTF(String s) {
		sharedTextTF.setText(s);
	}
}
