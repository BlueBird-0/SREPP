package GuiEventer;

import java.net.URL;
import java.util.ResourceBundle;
 
import LogManager.LogManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class LogController implements Initializable{

	@FXML	private TextArea logTextFiled;
 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		for(String str: LogManager.Log)
		{
			logTextFiled.setText(logTextFiled.getText()+ str);
		}

		logTextFiled.positionCaret(logTextFiled.getLength());
	}
}
