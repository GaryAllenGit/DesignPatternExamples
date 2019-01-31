import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DemoGUI extends javax.swing.JFrame implements Runnable, Observer {
	private JButton setButton;
	private JTextField sharedTextTF;

	private SharedString sharedText;


	@Override
	public void run() {
		this.setVisible(true);
	}

	public DemoGUI(SharedString initialSharedText) {
		super();

		// initialise the shared string and add 'this' GUI as an observer to it	
		sharedText = initialSharedText;
		sharedText.addObserver(this);

		initGUI();
		updateSharedTextTF();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setTitle("GUI Threads Demo");

		setButton = new JButton();
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
	public void update(Observable arg0, Object arg1) {
		// the method called when the shared string changes - update the GUI
		updateSharedTextTF();
	}

	private void updateSharedTextTF() {
		sharedTextTF.setText(sharedText.getTheString());
	}
}
