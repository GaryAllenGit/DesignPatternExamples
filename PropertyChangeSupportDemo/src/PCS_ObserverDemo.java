
public class PCS_ObserverDemo {
	public static void main(String[] args){

		// create the shared string object (the observed object) and set an initial value
		PCS_SharedString sharedString = new PCS_SharedString();
		sharedString.setTheString("Shared Value");
		
		// create the GUI objects (the observers), passing them a reference to the shared object
		PCS_DemoGUI gui1 = new PCS_DemoGUI(sharedString);
		PCS_DemoGUI gui2 = new PCS_DemoGUI(sharedString);
		PCS_DemoGUI gui3 = new PCS_DemoGUI(sharedString);

		// create the threads to contain the GUIs
		Thread t1 = new Thread(gui1);
		Thread t2 = new Thread(gui2);
		Thread t3 = new Thread(gui3);

		// start the threads
		t1.start();
		t2.start();
		t3.start();
	}
}
