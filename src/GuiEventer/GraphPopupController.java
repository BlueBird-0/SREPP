package GuiEventer;

import java.net.URL;
import java.util.ResourceBundle;

import DataManager.DataManager;
import DataManager.ResultData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class GraphPopupController implements Initializable{

	/* 왼쪽 창 아이디 */
	@FXML	private LineChart<Double, Double> graphView;
	@FXML	private NumberAxis xView;
	@FXML	private NumberAxis yView;
	
	public Stage stage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("그래프 출력");
		//defining the axes
		ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList();
		
		LineChart.Series<Double, Double> series1 = new LineChart.Series<Double, Double>();
		series1.setName("Series 1");
		set2(series1);
		
		lineChartData.add(series1);
		
		LineChart.Series<Double, Double> series2 = new LineChart.Series<Double, Double>();
		series2.setName("Series 2");
		set(series2);
		
		lineChartData.add(series2);

		
		LineChart.Series<Double, Double> series3 = new LineChart.Series<Double, Double>();
		series3.setName("Series 3");
		set3(series3);
		
		lineChartData.add(series3);
		
		LineChart.Series<Double, Double> series4 = new LineChart.Series<Double, Double>();
		series4.setName("Series 4");
		set4(series4);
		
		lineChartData.add(series4);
		
		xView.setLabel("Compression(or Expansion) Ratio"); 
		yView.setLabel("Pressure(bar)");
		graphView.setCreateSymbols(false);
		graphView.setData(lineChartData);
	}
	
	public void set(LineChart.Series<Double, Double> series)
	{
		for(ResultData data : DataManager.resultDataList)
		{
			series.getData().add(new XYChart.Data<Double, Double>(data.g(25), data.g(27)));
		}
		return ;
	}
	public void set2(LineChart.Series<Double, Double> series)
	{
		for(ResultData data : DataManager.resultDataList)
		{
			series.getData().add(new XYChart.Data<Double, Double>(data.g(25), data.g(29)));
		}
		return ;
	}
	public void set3(LineChart.Series<Double, Double> series)
	{
		for(ResultData data : DataManager.resultDataList)
		{
			series.getData().add(new XYChart.Data<Double, Double>(data.g(26), data.g(30)));
		}
		return ;
	}
	public void set4(LineChart.Series<Double, Double> series)
	{
		for(ResultData data : DataManager.resultDataList)
		{
			series.getData().add(new XYChart.Data<Double, Double>(data.g(26), data.g(28)));
		}
		return ;
	}
}
 