package GuiEventer;

import java.net.URL;
import java.util.ResourceBundle;

import DataManager.Data;
import DataManager.DataManager;
import LogManager.LogManager;
import application.ComputeManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlterPopupController implements Initializable {

	/* 왼쪽 창 아이디 */
	/*
	 * @FXML private TableView<Data> parameterTableView;
	 * 
	 * @FXML private TableColumn<Data, String> keyColumn;
	 * 
	 * @FXML private TableColumn<Data, Double> valueColumn;
	 * 
	 * @FXML private TableColumn<Data, String> commentColumn;
	 */
	@FXML
	private AnchorPane popupPane;
	@FXML
	private TextField edit_key;
	@FXML
	private TextField edit_value;
	@FXML
	private TextArea edit_comment;

	public Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	public void setKeyEventer() {
		Scene dialogScene = stage.getScene();

		dialogScene.setOnKeyPressed((final KeyEvent keyEvent) -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				System.out.println("엔터키 입력");
			} else if (keyEvent.getCode() == KeyCode.ESCAPE) {
				stage.hide();
			}
		});
	}

	public final void setData(Data data) {
		if (data.changeAble != true) {
			System.out.println("금지!");
			edit_value.setDisable(true);
		}
		edit_key.setText(data.key.get());
		edit_value.setText(data.value.asString().get());
		edit_comment.setText(data.comment.get());
	}

	@FXML
	public void handleBtnAlter(ActionEvent event) {
		String past = DataManager.getData(edit_key.getText()).key.get()
				+ DataManager.getData(edit_key.getText()).value.get();
		DataManager.setData(edit_key.getText(), Double.parseDouble(edit_value.getText()), edit_comment.getText());

		LogManager.println("");
		LogManager.println("변수변경 전 : " + past);
		LogManager.println(
				"변수변경 후 : " + edit_key.getText() + "\t" + edit_value.getText() + "\t" + edit_comment.getText());
		ComputeManager.initCompute();
		ComputeManager.pressCompute();
		stage.hide();
	}

	@FXML
	public void handleBtnCancle(ActionEvent event) {
		stage.hide();
	}

}