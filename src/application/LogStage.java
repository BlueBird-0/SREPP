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
		LogManager.print("wowowowowow 여기서 문자 추가 : "+ 10);
		LogManager.println("두번 째 문자 추가 : "+ 20);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.println("세번째 문자 추가"+ 30);
		LogManager.print("마지막 추가 : "+ 40);
		
		 
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
