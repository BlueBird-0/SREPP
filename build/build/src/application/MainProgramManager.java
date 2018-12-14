package application;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainProgramManager extends Application {
	static private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) throws UnsupportedEncodingException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SREPP");
			
		initRootLayout();
		showPersonOverView();
	}
	public void initRootLayout() {
		try {
			// fxml ���Ͽ��� ���� ���̾ƿ��� �����´�.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainProgramManager.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane)loader.load();
			// ���� ���̾ƿ��� �����ϴ� scene �� �����ش�.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show(); 
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���� ���̾ƿ� ���� �۾�
	 */
	public void showPersonOverView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainProgramManager.class.getResource("/view/MainOverview.fxml"));
			AnchorPane personOverview = (AnchorPane)loader.load();
			rootLayout.setCenter(personOverview);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//���� ���������� ��ȯ�Ѵ�.
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
