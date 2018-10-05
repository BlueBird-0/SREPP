package GuiEventer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.spi.DirStateFactory.Result;

import DataManager.Data;
import DataManager.DataManager;
import DataManager.ResultData;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import application.*;

public class Controller implements Initializable {
	
	/* 왼쪽 창 아이디 */
	@FXML	private TableView<Data> parameterTableView;
	@FXML	private TableColumn<Data, String> keyColumn;
	@FXML	private TableColumn<Data, Double> valueColumn;
	@FXML	private TableColumn<Data, String> commentColumn;
	
	/* 오른쪽 결과창 */
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
	
	ObservableList<Data> oDataList = FXCollections.observableArrayList();
	ObservableList<ResultData> oResultDataList = FXCollections.observableArrayList();

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DataManager.initData();
		for(int i=0; i<700;i++)
		{
		ComputeManager.resultCompute();
		}
		System.out.println(DataManager.dataList.get(0).key);
		
		keyColumn.setCellValueFactory(cellData -> cellData.getValue().getKey());
		valueColumn.setCellValueFactory(cellData -> cellData.getValue().getValue().asObject());
		commentColumn.setCellValueFactory(cellData -> cellData.getValue().getComment());
		

		TableColumn<ResultData, Double> resultColumnList[] = new TableColumn[] {
				result01Column,result02Column,result03Column,result04Column,result05Column,result06Column,result07Column,result08Column,result09Column,result10Column,
				result11Column,result12Column,result13Column,result14Column,result15Column,result16Column,result17Column,result18Column,result19Column,result20Column,
				result21Column,result22Column,result23Column,result24Column,result25Column,result26Column,result27Column,result28Column,result29Column,result30Column,
				result31Column};
 
		for(int i=0; i<31; i++)
		{
			final int index = i;
			resultColumnList[i].setCellValueFactory(cellData -> cellData.getValue().getValue(index).asObject());
		}
		
		//add item to list
		for (Data data : DataManager.getChangeableList()) {
			oDataList.add(data);
		}
		for(ResultData data : DataManager.resultDataList)
		{
			oResultDataList.add(new ResultData());
		}
		
		parameterTableView.setItems(oDataList);
		resultTableView.setItems(oResultDataList);
	}
	
}
