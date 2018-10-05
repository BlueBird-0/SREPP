package application;
import view.*;

import java.awt.BorderLayout;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainProgramManager extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SREPP");
			
		initRootLayout();
		showPersonOverView();
		
		//���Ŀ� ���� ����
		ComputeManager.pressCompute();

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
			loader.setLocation(MainProgramManager.class.getResource("/view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane)loader.load();
			rootLayout.setCenter(personOverview);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//���� ���������� ��ȯ�Ѵ�.
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}