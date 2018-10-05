package DataManager;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;

public class ResultData {
	public static DoubleProperty value[] = new DoubleProperty[31];
	
	public DoubleProperty getValue(int index) {	return value[index];	}
	public void setValue(int index, double value) { this.value[index] = new SimpleDoubleProperty(value);	}
	public DoubleProperty[] getValueList() {	return value;	}
	public void setValueList(DoubleProperty[] values) { this.value = values;	}
	
	public double g(int index) {	return value[index].get();	}
	
	
	public ResultData()
	{
		for(int i=0; i<31; i++)
		{
			value[i] = new SimpleDoubleProperty(i);
		}
	}

}
