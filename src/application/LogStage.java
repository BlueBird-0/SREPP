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
		LogManager.print("wowowowowow ���⼭ ���� �߰� : "+ 10);
		LogManager.println("�ι� ° ���� �߰� : "+ 20);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.println("����° ���� �߰�"+ 30);
		LogManager.print("������ �߰� : "+ 40);
		
		 
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

		// ���� ���̾ƿ��� �����ϴ� scene �� �����ش�.
		this.setScene(logScene);
		this.show();
	}

}
