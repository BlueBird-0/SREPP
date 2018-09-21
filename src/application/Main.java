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


public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SREPP");
			
		initRootLayout();
		showPersonOverView();
	}
	
	public void initRootLayout() {
		try {
			// fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane)loader.load();
			
			// 상위 레이아웃을 포함하는 scene 을 보여준다.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 상위 레이아웃 안의 작업
	 */
	public void showPersonOverView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane)loader.load();
			rootLayout.setCenter(personOverview);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//메인 스테이지를 반환한다.
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
