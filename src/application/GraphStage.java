package application;

import java.io.IOException;

import GuiEventer.GraphPopupController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GraphStage extends Stage {
	
	public GraphStage() {
		// 팝업창 실행
		this.setTitle("SREPP Graph");

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(MainProgramManager.class.getResource("/view/GraphPopup.fxml"));

		AnchorPane popup = null;
		try {
			popup = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scene dialogScene = new Scene(popup);

		GraphPopupController controller = loader.getController();

		// 상위 레이아웃을 포함하는 scene 을 보여준다.
		this.setScene(dialogScene);
		this.show();
		this.setOnHidden(event_c -> {
			// onDraw();
		});
	}

}
