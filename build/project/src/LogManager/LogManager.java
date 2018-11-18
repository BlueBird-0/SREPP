package LogManager;

import java.util.ArrayList;
import java.util.logging.Logger;

import application.MainProgramManager;
import javafx.util.converter.LongStringConverter;

public class LogManager {
	public static ArrayList<String> Log = new ArrayList<>();
	
	public static void println(String str)
	{
		Log.add(str+ "\n");
	}
	public static void print(String str)
	{
		Log.add(str);
	}
	
	
}
