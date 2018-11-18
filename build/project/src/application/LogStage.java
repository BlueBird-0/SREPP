package application;

import java.io.IOException;

import GuiEventer.LogController;
import LogManager.LogManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogStage extends Stage{
	
	public LogStage() {
		 
		this.setTitle("Calculation Process");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainProgramManager.class.getResource("/view/LogView.fxml"));
		
		AnchorPane popup = null;
		try {
			popup = (AnchorPane)loader.load();					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene logScene = new Scene(popup);						

		LogController controller = loader.getController();

		// 상위 레이아웃을 포함하는 scene 을 보여준다.
		this.setScene(logScene);
		this.show();
	}

}
