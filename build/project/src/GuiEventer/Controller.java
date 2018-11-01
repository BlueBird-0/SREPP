package GuiEventer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.jdi.event.Event;

import DataManager.Data;
import DataManager.DataManager;
import DataManager.ResultData;
import FileSystem.FileSystem;
import application.ComputeManager;
import application.MainProgramManager;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

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
	
	@FXML	public Text calculatingNotice;	ObservableList<Data> oDataList = FXCollections.observableArrayList();
	ObservableList<ResultData> oResultDataList = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DataManager.initData();
		ComputeManager.initCompute();
		ComputeManager.pressCompute();

		keyColumn.setCellValueFactory(cellData -> cellData.getValue().getKey());
		valueColumn.setCellValueFactory(cellData -> cellData.getValue().getValue().asObject());
		commentColumn.setCellValueFactory(cellData -> cellData.getValue().getComment());
		commentColumn.getStyleClass().add("leftAlignedTableColumnHeader");
		 
		System.out.println(parameterTableView.getPrefWidth() );
		System.out.println(keyColumn.getPrefWidth()); 
		System.out.println(valueColumn.getPrefWidth()); 
		commentColumn.setPrefWidth(parameterTableView.getPrefWidth() - keyColumn.getPrefWidth() - valueColumn.getPrefWidth());
		System.out.println(parameterTableView.getPrefWidth() - keyColumn.getPrefWidth() - valueColumn.getPrefWidth());
		
		TableColumn<ResultData, String> resultColumnList[] = new TableColumn[] { result01Column, result02Column,
				result03Column, result04Column, result05Column, result06Column, result07Column, result08Column,
				result09Column, result10Column, result11Column, result12Column, result13Column, result14Column,
				result15Column, result16Column, result17Column, result18Column, result19Column, result20Column,
				result21Column, result22Column, result23Column, result24Column, result25Column, result26Column,
				result27Column, result28Column, result29Column, result30Column, result31Column };
	
		parameterTableView.setRowFactory(new Callback<TableView<Data>, TableRow<Data>>(){
			@Override
			public TableRow<Data> call(TableView<Data> param) {
				final TableRow<Data> row = new TableRow<Data>() {
					@Override
					protected void updateItem(Data row, boolean empty) {
						super.updateItem(row, empty);
						//���� �Ұ����� ���� �� ��,
						BooleanProperty selected = new SimpleBooleanProperty(false);
						if(empty != true)
							if(row.state != Data.STATE_CHANGEABLE)
								selected = new SimpleBooleanProperty(true);
						
						if(!empty)
							styleProperty().bind(Bindings.when(selected)
									.then("-fx-opacity: 0.5;")
									.otherwise(""));
					}
				};
				// ���콺 Ŭ�� �̺�Ʈ
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
						controller.setKeyEventer();	//Ű���� �̺��� ����
						dialog.show();
						dialog.setOnHidden(event_c->{
							onDraw();
						});
					}
				});
				return row;
			}
		});

		
		//����� �� ���� ���� ����
		/*
		parameterTableView.setRowFactory(tv -> {
		    TableRow<Data> row = new TableRow<>();
		    if(!row.isEmpty())
		    {
		    	System.out.println("1��");
				if ( row.getItem().state != Data.STATE_CHANGEABLE )
			    {
					System.out.println("2��");
			    	row.setDisable(false);
			    	row.setOpacity(0.5);
			    }
		    }
		    
		    return row ;
		});
		*/
		
		
		resultColumnList[0].setCellValueFactory(cellData -> Bindings.format("%.1f", cellData.getValue().getValue(0)));
		resultColumnList[1].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(1)));
		resultColumnList[2].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(2)));
		resultColumnList[3].setCellValueFactory(cellData -> Bindings.format("%.1f", cellData.getValue().getValue(3)));
		resultColumnList[4].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(4)));
		resultColumnList[5].setCellValueFactory(cellData -> Bindings.format("%.4f", cellData.getValue().getValue(5)));
		resultColumnList[6].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(6)));
		resultColumnList[7].setCellValueFactory(cellData -> Bindings.format("%.1f", cellData.getValue().getValue(7)));
		resultColumnList[8].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(8)));
		resultColumnList[9].setCellValueFactory(cellData -> Bindings.format("%.1f", cellData.getValue().getValue(9)));
		resultColumnList[10].setCellValueFactory(cellData -> Bindings.format("%.7f", cellData.getValue().getValue(10)));
		resultColumnList[11].setCellValueFactory(cellData -> Bindings.format("%.0f", cellData.getValue().getValue(11)));
		resultColumnList[12].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(12)));
		resultColumnList[13].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(13)));
		resultColumnList[14].setCellValueFactory(cellData -> Bindings.format("%.6f", cellData.getValue().getValue(14)));
		resultColumnList[15].setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getValue(15)));
		resultColumnList[16].setCellValueFactory(cellData -> Bindings.format("%.7f", cellData.getValue().getValue(16)));
		resultColumnList[17].setCellValueFactory(cellData -> Bindings.format("%.0f", cellData.getValue().getValue(17)));
		resultColumnList[18].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(18)));
		resultColumnList[19].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(19)));
		resultColumnList[20].setCellValueFactory(cellData -> Bindings.format("%.4f", cellData.getValue().getValue(20)));
		resultColumnList[21].setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getValue(21)));
		resultColumnList[22].setCellValueFactory(cellData -> Bindings.format("%.4f", cellData.getValue().getValue(22)));
		resultColumnList[23].setCellValueFactory(cellData -> Bindings.format("%.1f", cellData.getValue().getValue(23)));
		resultColumnList[24].setCellValueFactory(cellData -> Bindings.format("%.7f", cellData.getValue().getValue(24)));
		resultColumnList[25].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(25)));
		resultColumnList[26].setCellValueFactory(cellData -> Bindings.format("%.5f", cellData.getValue().getValue(26)));
		resultColumnList[27].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(27)));
		resultColumnList[28].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(28)));
		resultColumnList[29].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(29)));
		resultColumnList[30].setCellValueFactory(cellData -> Bindings.format("%.3f", cellData.getValue().getValue(30)));
		
		
		for (ResultData data : DataManager.resultDataList) {
			oResultDataList.add(data);
		}
		//parameterTableView.setItems(oDataList);	
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
	
	@FXML
	public void handleBtnGraph(ActionEvent event) { 
		if(event.getSource() instanceof Button) {
			Button btn = (Button) event.getSource();
			System.out.println("�׷��� ���");
			//�˾�â ����
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.setTitle("SREPP Graph");
			dialog.setResizable(false);

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainProgramManager.class.getResource("/view/GraphPopup.fxml"));

			AnchorPane popup = null; 
			try {
				popup = (AnchorPane)loader.load();					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Scene dialogScene = new Scene(popup);						

			GraphPopupController controller = loader.getController();

			// ���� ���̾ƿ��� �����ϴ� scene �� �����ش�.

			dialog.setScene(dialogScene);
			dialog.show();
			dialog.setOnHidden(event_c->{
				onDraw();
			});
		}
	}

	//Properties button
	@FXML
	public void handleBtnMenuProperties(ActionEvent event) { 
		if(event.getSource() instanceof MenuItem) {
			MenuItem item = (MenuItem)event.getSource();

			//�˾�â ����
			final Stage properties = new Stage();
			properties.initModality(Modality.APPLICATION_MODAL);
			properties.setTitle("Properties");
			properties.setResizable(false);

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainProgramManager.class.getResource("/view/PropertiesPopup.fxml"));

			AnchorPane popup = null; 
			try {
				popup = (AnchorPane)loader.load();					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Scene propertiesScene = new Scene(popup);						

			GraphPopupController controller = loader.getController();

			// ���� ���̾ƿ��� �����ϴ� scene �� �����ش�.

			properties.setScene(propertiesScene);
			properties.show();
			// fxml ���Ͽ��� ���� ���̾ƿ��� �����´�.
		
		}
	}
    
	//Exit button
	@FXML
	public void handleBtnMenuExit(ActionEvent event) {
		if(event.getSource() instanceof MenuItem) {
			MenuItem item = (MenuItem)event.getSource();
			Platform.exit();
		}
	}
	
	//Open button
	@FXML
	public void handleBtnMenuOpen(ActionEvent event) { 
		FileSystem.fileOpen();
		ComputeManager.initCompute();
		ComputeManager.pressCompute();
		onDraw();
	}
	//Save button
	@FXML
	public void handleBtnMenuSave(ActionEvent event) {
		FileSystem.fileSave();
	}
	//SaveAs button
	@FXML
	public void handleBtnMenuSaveAs(ActionEvent event) {
		FileSystem.fileSaveAs();
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
		
		//����� ��� ����Ʈ �ٽú����ֱ�
		oResultDataList.clear();
		for(ResultData data : DataManager.resultDataList)
			oResultDataList.add(data);
		
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
