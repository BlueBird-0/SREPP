package DataManager;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
	//public static int STATE_NOTCHANGE = 0;
	//public static int STATE_CHANGEABLE = 1; 
	//public static int STATE_PISTON = 2;	//Piston
	//public static int STATE_SRE = 3;	//SRE
	
	public final static int STATE_ZERO = 6;
	public final static int STATE_ONE = 7;
	public final static int STATE_TWO = 8;
	public final static int STATE_THREE = 9;
	public final static int STATE_FOUR = 10;
	public final static int STATE_All = 12;
	
	public final static int STATE_NONE = 11;
	
	public int state; // 0.형상 변수, 1.엔진 운용조건 변수, 2.대기 조건, 3.특성 값, 4.가정값
	public boolean changeAble;
	public StringProperty key;
	public DoubleProperty value;
	public StringProperty comment;
	
	public Data(String key, double value, String comment)
	{
		this.state = STATE_NONE;
		this.key = new SimpleStringProperty(key);
		this.value = new SimpleDoubleProperty(value);
		this.comment = new SimpleStringProperty(comment);
		this.changeAble = false;
	}
	public Data(int state, String key, double value, String comment)
	{
		this.state = state;
		this.key = new SimpleStringProperty(key);
		this.value = new SimpleDoubleProperty(value);
		this.comment = new SimpleStringProperty(comment);
		this.changeAble = false;
	}
	public Data(String key, double value, String comment, boolean changeAble)
	{
		this.state = STATE_NONE;
		this.key = new SimpleStringProperty(key);
		this.value = new SimpleDoubleProperty(value);
		this.comment = new SimpleStringProperty(comment);
		this.changeAble = false;
		this.changeAble = changeAble;
	}
	public Data(int state, String key, double value, String comment, boolean changeAble)
	{
		this.state = state;
		this.key = new SimpleStringProperty(key);
		this.value = new SimpleDoubleProperty(value);
		this.comment = new SimpleStringProperty(comment);
		this.changeAble = changeAble;
	}
	public Data(StringProperty key, DoubleProperty value, StringProperty comment, boolean changeAble)
	{
		this.state = STATE_NONE;
		this.key = key;
		this.value = value;
		this.comment = comment;
		this.changeAble = changeAble;
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