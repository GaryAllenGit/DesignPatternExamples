import java.util.Observable;

public class SharedString extends Observable {
	private String theString;

	public SharedString() {
		super();
	}
	
	public String getTheString() {
		return theString;
	}

	public void setTheString(String theString) {
		this.theString = theString;
		
		// fire notifications to any registered Observers
		setChanged();
		notifyObservers();
	}
}
