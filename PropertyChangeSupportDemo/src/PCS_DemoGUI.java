import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        // initialise the shared string and add 'this' GUI as a listener (observer) to it
        sharedText = initialSharedText;
        sharedText.addPropertyChangeListener(this);

        initGUI();
        updateSharedTextTF(sharedText.getTheString());
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                onExit();
            }
        });
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

    private void onExit() {
    	// demoing how to clean up nicely and remove the listener before exiting the GUI
    	sharedText.removePropertyChangeListener(this);
    	this.dispose();
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
