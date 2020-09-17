import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCS_SharedString {
	private String theString;
	private PropertyChangeSupport support;

	public PCS_SharedString() {
		support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void setTheString(String value) {
		support.firePropertyChange("theString", this.theString, value);
		this.theString = value;
	}

	public String getTheString() {
		return theString;
	}
}
