package DataManager;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
	public static int STATE_NOTCHANGE = 0;
	public static int STATE_CHANGEABLE = 1; 
	public static int STATE_PISTON = 2;	//Piston
	public static int STATE_SRE = 3;	//SRE
	public int state; // 0.not change  1.changeable, 
	public StringProperty key;
	public DoubleProperty value;
	public StringProperty comment;
	
	public Data(String key, double value, String comment)
	{
		this.state = STATE_NOTCHANGE;
		this.key = new SimpleStringProperty(key);
		this.value = new SimpleDoubleProperty(value);
		this.comment = new SimpleStringProperty(comment);
	}
	public Data(int state, String key, double value, String comment)
	{
		this.state = state;
		this.key = new SimpleStringProperty(key);
		this.value = new SimpleDoubleProperty(value);
		this.comment = new SimpleStringProperty(comment);
	}
	public Data(StringProperty key, DoubleProperty value, StringProperty comment)
	{
		this.state = STATE_NOTCHANGE;
		this.key = key;
		this.value = value;
		this.comment = comment;
	}
	public Data(int state, StringProperty key, DoubleProperty value, StringProperty comment)
	{
		this.state = state;
		this.key = key;
		this.value = value;
		this.comment = comment;
	}
	public StringProperty getKey() {	return key;	}
	public DoubleProperty getValue() {	return value;	}
	public StringProperty getComment() {	return comment;	}
}