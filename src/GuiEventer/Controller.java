package GuiEventer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataManager.Data;
import DataManager.DataManager;
import DataManager.ResultData;
import FileSystem.FileSystem;
import application.ComputeManager;
import application.MainProgramManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller implements Initializable {

	/* ���� â ���̵� */
	@FXML	private TableView<Data> parameterTableView;
	@FXML	private TableColumn<Data, String> keyColumn;
	@FXML	private TableColumn<Data, Double> valueColumn;
	@FXML	private TableColumn<Data, String> commentColumn;

	/* ������ ���â */
	@FXML	private TableView<ResultData> resultTableView;
	@FXML	private TableColumn<ResultData, Double> result01Column;
	@FXML	private TableColumn<ResultData, Double> result02Column;
	@FXML	private TableColumn<ResultData, Double> result03Column;
	@FXML	private TableColumn<ResultData, Double> result04Column;
	@FXML	private TableColumn<ResultData, Double> result05Column;
	@FXML	private TableColumn<ResultData, Double> result06Column;
	@FXML	private TableColumn<ResultData, Double> result07Column;
	@FXML	private TableColumn<ResultData, Double> result08Column;
	@FXML	private TableColumn<ResultData, Double> result09Column;
	@FXML	private TableColumn<ResultData, Double> result10Column;
	@FXML	private TableColumn<ResultData, Double> result11Column;
	@FXML	private TableColumn<ResultData, Double> result12Column;
	@FXML	private TableColumn<ResultData, Double> result13Column;
	@FXML	private TableColumn<ResultData, Double> result14Column;
	@FXML	private TableColumn<ResultData, Double> result15Column;
	@FXML	private TableColumn<ResultData, Double> result16Column;
	@FXML	private TableColumn<ResultData, Double> result17Column;
	@FXML	private TableColumn<ResultData, Double> result18Column;
	@FXML	private TableColumn<ResultData, Double> result19Column;
	@FXML	private TableColumn<ResultData, Double> result20Column;
	@FXML	private TableColumn<ResultData, Double> result21Column;
	@FXML	private TableColumn<ResultData, Double> result22Column;
	@FXML	private TableColumn<ResultData, Double> result23Column;
	@FXML	private TableColumn<ResultData, Double> result24Column;
	@FXML	private TableColumn<ResultData, Double> result25Column;
	@FXML	private TableColumn<ResultData, Double> result26Column;
	@FXML	private TableColumn<ResultData, Double> result27Column;
	@FXML	private TableColumn<ResultData, Double> result28Column;
	@FXML	private TableColumn<ResultData, Double> result29Column;
	@FXML	private TableColumn<ResultData, Double> result30Column;
	@FXML	private TableColumn<ResultData, Double> result31Column;
	
	@FXML	public Text calculatingNotice;
	
	ObservableList<Data> oDataList = FXCollections.observableArrayList();
	ObservableList<ResultData> oResultDataList = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DataManager.initData();
		ComputeManager.resultCompute();

		keyColumn.setCellValueFactory(cellData -> cellData.getValue().getKey());
		valueColumn.setCellValueFactory(cellData -> cellData.getValue().getValue().asObject());
		commentColumn.setCellValueFactory(cellData -> cellData.getValue().getComment());
		

		TableColumn<ResultData, Double> resultColumnList[] = new TableColumn[] { result01Column, result02Column,
				result03Column, result04Column, result05Column, result06Column, result07Column, result08Column,
				result09Column, result10Column, result11Column, result12Column, result13Column, result14Column,
				result15Column, result16Column, result17Column, result18Column, result19Column, result20Column,
				result21Column, result22Column, result23Column, result24Column, result25Column, result26Column,
				result27Column, result28Column, result29Column, result30Column, result31Column };
		
		parameterTableView.setRowFactory(tv->{
			TableRow<Data> row = new TableRow<>();
				row.setOnMouseClicked(event ->{
					if(event.getClickCount() == 2 && (!row.isEmpty())) {
						Data data = row.getItem();
						System.out.println(data.key + data.value.toString() + data.comment);
						//�˾�â ����
						final Stage dialog = new Stage();
						dialog.initModality(Modality.APPLICATION_MODAL);
						dialog.setTitle("�Է� �� ����");
						dialog.setResizable(false);
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(MainProgramManager.class.getResource("/view/AlterPopup.fxml"));
						AnchorPane popup = null; 
						try {
							popup = (AnchorPane)loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Scene dialogScene = new Scene(popup);
						AlterPopupController controller = loader.getController();
						controller.setData(data);
						controller.stage = dialog;
						// ���� ���̾ƿ��� �����ϴ� scene �� �����ش�.
						dialog.setScene(dialogScene);
						dialog.show();
						dialog.setOnHidden(event_c->{
							onDraw();
						});
					}
				});
			return row;
		});
		
		
		
		
		for (int i = 0; i < 31; i++) {
			final int index = i;
			resultColumnList[i].setCellValueFactory(cellData -> cellData.getValue().getValue(index).asObject());
		}

		
		
		for (ResultData data : DataManager.resultDataList) {
			oResultDataList.add(data);
		}
		parameterTableView.setItems(oDataList);
		resultTableView.setItems(oResultDataList);
		
		onDraw();
	}

	@FXML
	public void handleBtnAll(ActionEvent event) {
		if (event.getSource() instanceof CheckBox) {
			CheckBox chk = (CheckBox) event.getSource();
			if (chk.isSelected()) {
				FileSystem.checkedAllList = true;
			} else {
				FileSystem.checkedAllList = false;
			}
			onDraw();
		}
	}
	
	//�׷��� ó�� �Լ�
	public void onDraw()
	{
		//'��ü����' üũ�ڽ��� ���� ����Ʈ ����
		oDataList.clear();
		if(FileSystem.checkedAllList)
			for(Data data : DataManager.getAllList())
				oDataList.add(data);
		else
			for(Data data : DataManager.getChangeableList())
				oDataList.add(data);
		
		runComputeThread();
	}
	

	public void runComputeThread()
	{              
	    Thread thread = new Thread() {
	        @Override
	        public void run() {
	        	System.out.println("calculate thread run");
	            while (ComputeManager.CalculatingStatus) {
	                Platform.runLater(() -> {
	                	if(calculatingNotice.getText().equals("Calculating.  "))
	                	{
	                		calculatingNotice.setText("Calculating.. ");
	                	}else if(calculatingNotice.getText().equals("Calculating.. "))
	                	{
	                		calculatingNotice.setText("Calculating...");
	                	}else if(calculatingNotice.getText().equals("Calculating..."))
	                	{
	                		calculatingNotice.setText("Calculating.  ");
	                	}
	                });
	                try { Thread.sleep(700); } catch (InterruptedException e) {}
	            }
	            calculatingNotice.setVisible(false);
	        }
	    };
	    thread.setDaemon(true);
	    thread.start();
	}
}
