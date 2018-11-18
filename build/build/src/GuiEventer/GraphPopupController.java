package GuiEventer;

import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GraphPopupController implements Initializable{

	/* 왼쪽 창 아이디 */
	@FXML	private LineChart<Double, Double> graphView;
	@FXML	private NumberAxis xView;
	@FXML	private NumberAxis yView;
	@FXML	private Text legendText1;
	@FXML	private Text legendText2;
	@FXML	private Line legendLine1;
	@FXML	private Line legendLine2;
	
	public Stage stage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("그래프 출력");
		
		//defining the axes
		ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList();
		
		/*
		 * 그래프 차트 설명
		 * Series1 : 하단 피스톤 엔진
		 * Series2 : 하단SRE 엔진
		 * Series3 : 상단 피스톤 엔진
		 * Series4 : 상단 SRE엔진
		 * Series5 : 좌측 (세로) 피스톤 엔진
		 * Series6 : 좌측 (세로) SRE 엔진
		 * 
		 * 
		 */
		
		
		LineChart.Series<Double, Double> series1 = new LineChart.Series<Double, Double>();
		series1.setName("Series 1");
		set1(series1);
		
		lineChartData.add(series1);
		
		LineChart.Series<Double, Double> series2 = new LineChart.Series<Double, Double>();
		series2.setName("Series 2");
		set2(series2);
		
		lineChartData.add(series2);

		
		LineChart.Series<Double, Double> series3 = new LineChart.Series<Double, Double>();
		series3.setName("Series 3");
		set3(series3);
		
		lineChartData.add(series3);
		
		LineChart.Series<Double, Double> series4 = new LineChart.Series<Double, Double>();
		series4.setName("Series 4");
		set4(series4);
		
		lineChartData.add(series4);
		
		
		//세로라인
		LineChart.Series<Double, Double> series5 = new LineChart.Series<Double, Double>();
		series5.setName("Series 5");
		set5(series5);
		lineChartData.add(series5);

		LineChart.Series<Double, Double> series6 = new LineChart.Series<Double, Double>();
		series6.setName("Series 6");
		set6(series6);
		lineChartData.add(series6);

		LineChart.Series<Double, Double> series7 = new LineChart.Series<Double, Double>();
		series7.setName("Series 7");
		set7(series7);
		lineChartData.add(series7);

		LineChart.Series<Double, Double> series8 = new LineChart.Series<Double, Double>();
		series8.setName("Series 8");
		set8(series8);
		lineChartData.add(series8);
		
		
		xView.setAutoRanging(false);
		xView.setTickUnit(2);
		xView.setLowerBound(0);
		xView.setUpperBound(14);
		yView.setAutoRanging(false);
		yView.setTickUnit(20);
		yView.setLowerBound(0); 
		yView.setUpperBound(140);
		 
		xView.setLabel("Compression(or Expansion) Ratio"); 
		yView.setLabel("Pressure(bar)");
		legendText1.setText("Piston Engine");
		legendText1.setFill(Color.GREEN);
		legendText2.setText("SRE");
		legendText2.setFill(Color.RED);
		
		
		graphView.setLegendVisible(false); 
		graphView.setCreateSymbols(false);
		
		
		graphView.setData(lineChartData);
	}
	
	public void set1(LineChart.Series<Double, Double> series)
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
	int piston_maximum;
	public void set3(LineChart.Series<Double, Double> series)
	{
		for(piston_maximum=0 ;DataManager.resultDataList.get(piston_maximum).g(26)<=10; piston_maximum++)
		{
			ResultData data = DataManager.resultDataList.get(piston_maximum);
			series.getData().add(new XYChart.Data<Double, Double>(data.g(26), data.g(28)));
		}
		return ;
	}
	public void set4(LineChart.Series<Double, Double> series)
	{
		for(ResultData data : DataManager.resultDataList)
		{
			series.getData().add(new XYChart.Data<Double, Double>(data.g(26), data.g(30)));
		}
		return ;
	}
	

	//세로라인
	public void set5(LineChart.Series<Double, Double> series)
	{
		ResultData bottomData = DataManager.resultDataList.get(540);
		ResultData topData = DataManager.resultDataList.get(0);
		series.getData().add(new XYChart.Data<Double, Double>(bottomData.g(25), bottomData.g(27)));
		series.getData().add(new XYChart.Data<Double, Double>(topData.g(26), topData.g(28)));
		return ;
	}
	public void set6(LineChart.Series<Double, Double> series)
	{
		ResultData bottomData = DataManager.resultDataList.get(540);
		ResultData topData = DataManager.resultDataList.get(0);
		series.getData().add(new XYChart.Data<Double, Double>(bottomData.g(25), bottomData.g(29)));
		series.getData().add(new XYChart.Data<Double, Double>(topData.g(26), topData.g(30)));
		return ;
	}
	public void set7(LineChart.Series<Double, Double> series)
	{
		ResultData bottomData = DataManager.resultDataList.get(0);
		ResultData topData = DataManager.resultDataList.get(piston_maximum);
		series.getData().add(new XYChart.Data<Double, Double>(bottomData.g(25), bottomData.g(29)));
		series.getData().add(new XYChart.Data<Double, Double>(topData.g(26), topData.g(30)));
		return ;
	}
	public void set8(LineChart.Series<Double, Double> series)
	{
		ResultData bottomData = DataManager.resultDataList.get(0);
		ResultData topData = DataManager.resultDataList.get(540);
		series.getData().add(new XYChart.Data<Double, Double>(bottomData.g(25), bottomData.g(29)));
		series.getData().add(new XYChart.Data<Double, Double>(topData.g(26), bottomData.g(29)));
		series.getData().add(new XYChart.Data<Double, Double>(topData.g(26), topData.g(30)));
		return ;
	}
}
 