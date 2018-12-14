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
			// fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainProgramManager.class.getResource("/view/RootLayout.fxml"));
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
			loader.setLocation(MainProgramManager.class.getResource("/view/MainOverview.fxml"));
			AnchorPane personOverview = (AnchorPane)loader.load();
			rootLayout.setCenter(personOverview);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//메인 스테이지를 반환한다.
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
