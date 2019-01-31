
public class ObserverDemo {
	public static void main(String args[]){

		// create the shared string object
		SharedString sharedString = new SharedString();
		sharedString.setTheString("Shared Value");
		
		// create the GUI objects, passing the shared string as a parameter
		DemoGUI gui1 = new DemoGUI(sharedString);
		DemoGUI gui2 = new DemoGUI(sharedString);
		DemoGUI gui3 = new DemoGUI(sharedString);

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
