package GuiEventer;

import java.net.URL;
import java.util.ResourceBundle;

import DataManager.Data;
import DataManager.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlterPopupController implements Initializable {

	/* 왼쪽 창 아이디 */
	/*
	@FXML
	private TableView<Data> parameterTableView;
	@FXML
	private TableColumn<Data, String> keyColumn;
	@FXML
	private TableColumn<Data, Double> valueColumn;
	@FXML
	private TableColumn<Data, String> commentColumn;
	*/
	@FXML	private AnchorPane popupPane;
	@FXML	private TextField edit_key;
	@FXML	private TextField edit_value;
	@FXML	private TextArea edit_comment;

	public Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public final void setData(Data data) {
		edit_key.setText(data.key.get());
		edit_value.setText(data.value.asString().get());
		edit_comment.setText(data.comment.get());
	}
	
	//그래픽 처리 함수
	public void onDraw()
	{		
		
	}
	
	@FXML
	public void handleBtnAlter(ActionEvent event) {
		DataManager.setData(edit_key.getText(), Double.parseDouble(edit_value.getText()), edit_comment.getText());
		System.out.println("변수변경 : "+edit_key.getText()+"\t"+edit_value.getText()+"\t"+edit_comment.getText());
		stage.hide();
	}
	

	@FXML
	public void handleBtnCancle(ActionEvent event) {
		stage.hide();
	}


}
