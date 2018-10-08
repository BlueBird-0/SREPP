package DataManager;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataManager {
	public static ArrayList<Data> dataList = new ArrayList<>();
	public static ArrayList<ResultData> resultDataList = new ArrayList<>();

	public static void setData(String key, double value)
	{
		for (Data data : dataList) {
			if(data.key.getValue().equals(key))
			{
				data.value = new SimpleDoubleProperty(value);
				return ;
			}
		}
	}
	public static void setData(String key, double value, String comment)
	{
		for (Data data : dataList) {
			if(data.key.getValue().equals(key))
			{
				data.value = new SimpleDoubleProperty(value);
				data.comment = new SimpleStringProperty(comment);
				return ;
			}
		}
	}
	
	public static Data getData(String key)
	{
		for (Data data : dataList)
		{
			if(data.key.getValue().equals(key ))
			{
				return data;
			}
		}
		return null;
	}

	//dataList의 'string'과 같은 key 에 들어있는 double를 얻어옴
	@SuppressWarnings("null")
	public static double g(String key)
	{
		for(Data data : dataList)
		{
			if(data.key.getValue().equals(key))
			{
				return data.value.getValue();
			}
		}
		return (Double) null;
	}
	
	
	public static ArrayList<Data> getAllList()
	{
		return dataList;
	}
	public static ArrayList<Data> getChangeableList()
	{
		ArrayList<Data> changeableList = new ArrayList<>();
		for (Data data : dataList) {
			if (data.state == 1)
			{
				changeableList.add(data);
			}
		}
		return changeableList;
	}
	
	
	public static void initData()
	{
		//1. 압축기, 연소실, 팽창기 geometry     길이: cm,  압력: N/cm^2, 온도: K
		dataList.add(new Data(1,"dt", 0.000138888888888889,"시간 증분(1200rpm으로 회전시) (=1/(1200/60)*360) sec/deg)"));
		dataList.add(new Data(1,"P_1", 10.1325,"표준대기압 (= 10.1325 N/cm^2)"));
		dataList.add(new Data(1,"T_1", 288,"표준대기온도 (=15+273 K)"));
		dataList.add(new Data(1,"rhousing", 7,"1) 하우징 내면 반경 ( 5cm)"));
		dataList.add(new Data(1,"rrotorc", 5.04,"1) compressor 로터 반경 (cm)"));
		dataList.add(new Data(1,"rrotore", 4.2,"1) expander 로터 반경 (cm)"));
		dataList.add(new Data(1,"drotorc", 7,"1) compressor 로터 두께 (5cm)"));
		dataList.add(new Data(1,"drotore", 7,"1) expander 로터 두께 (5cm)"));
		dataList.add(new Data(1,"voleff", 0.75,"1) 압축기 부피 효율(75%)"));
		dataList.add(new Data(1,"lvane", 4.55,"1) vane 길이 ( = 3.5cm)"));
		dataList.add(new Data("Irotor", 0.003556224,"1) 로터 angular momentum( = 1/2*mrotorc*(rrotroc*1.2)^2+1/2*mrotore*(rrotore*1.2)^2) kg*m^2"));
		dataList.add(new Data("rpresc", 0.0602,"compressor 로터의 공기 압축면 평균 반경 = (rrotor+rhousing)/2/100,  m"));
		dataList.add(new Data("rprese", 0.056,"expander 로터의 공기의 압력면 평균반경, m"));
		dataList.add(new Data("rvanefricc", 0.05236,"compressor vane과 rotor 접촉면의 평균반경 ( = rrotor + (rhousing-rrotor)/10),  m"));
		dataList.add(new Data("rvanefrice", 0.0448,"expander vane과 rotor 접촉면의 평균반경 ( = rrotor + (rhousing-rrotor)/10),  m"));
		dataList.add(new Data(1,"CR", 10,"2) Compression Ratio ( = 10): 설계값으로 input "));
		dataList.add(new Data(1,"T_max", 3773,"2) 연소실 연소온도 선정 값( = 2000 + 273 K)  116,133페이지참조"));
		dataList.add(new Data("V_1m2", 389.216940401485,"압축기 부피(행정체적) ( (rhousing^2-rrotorc^2)*π*drotorc*voleff  cm^3 )"));
		dataList.add(new Data("V_1", 432.463267112761,"압축기 총 부피( = V_1m2/(CR-1)*CR)"));
		dataList.add(new Data("V_2", 43.2463267112761,"연소실 부피 ( = V_1/CR cm^3)"));
		dataList.add(new Data("V_atk", 64.8694900669142,"2) Air tank의 size <= 엔진효율 높이기 위해 air tank 최적화 필요"));
		dataList.add(new Data("ER", 12.9601328903654,"팽창비=(rhousing^2-rrotore^2)*π*drotore*voleff/V_2 +1"));
		dataList.add(new Data("V_4m2", 517.2313776,"팽창기 부피(행정체적) ((rhousing^2-rrotore^2)*π*drotore*voleff  cm^3 )"));
		dataList.add(new Data("V_4", 560.4781411983,"팽창기 총 부피( = V_2*ER  cm^3)"));
		dataList.add(new Data(1,"γ_airavr", 1.4,"압축공기 250K~700K사이 γ 평균값 =AVERAGE(기체상수!C39:C48) => constant로 변경"));


		dataList.add(new Data(1,"P_2", 298.49,"3) 연소실 초기 압력 가정,  6) P_2 값 update"));
		dataList.add(new Data("P_atk", 283.5655,"air tank 압력은 초기에는 P_2와 동일하나 cooling 효과로 P_2의  "));
		dataList.add(new Data("P_5", 10.1325,"배기가스 배출 후 연소실 압력( 대기압 P_1과 동일)"));
		dataList.add(new Data("V_5", 43.2463267112761,"V_5=V_2   !air tank와 연소실 공기가 합쳐질떄 압력 및 온도 계산을 위한 V_5는 연소실 부피와 같음"));
		dataList.add(new Data("P_a5", 174.1923,"4) 압축과정에서 양방향 체크밸브가 열려 air tank 공기압(P_2)와 연소실 가스압(P_5)가 섞일떄 압력 = (P_2*V_atk+P_5*V_5)/(V_atk+V_5)"));
		dataList.add(new Data(1,"PRDopen", 235,"4) Push rod open시 압축기 로터 각도 "));


		dataList.add(new Data("p_c", 0.0,"압축기 공기압 (= IF(N73<PRDopen, S72*(P72/P73)^R73, S72*(Q72/Q73)^R73) (N/cm^2)"));
		dataList.add(new Data("P_c_excel", 298.488503374969,"5) excel 에서 읽은 압축기 최대 공기압.  P_2와 같아야 함."));


		dataList.add(new Data(1,"T_2", 918.36,"7) 연소실 초기 온도 ( K) 가정"));
		dataList.add(new Data("T_atk", 872.442,"8) T_atk = T_2*(P_atk/P_2)   "));
		dataList.add(new Data("T_3", 3773,"연소실 연소온도 =T_max"));
		dataList.add(new Data("P_3", 1226.31949344484,"폭발시 연소실 압력(N/cm^2) (= P_2*T_3/T_2)"));
		dataList.add(new Data("γ_gasavr", 1.4,"팽창가스 T3와 T4사이의 γ 평균값 =AVERAGE(기체상수!E9:E13) => constant로 변경"));
		dataList.add(new Data("T_4", 1354.07594607931,"배기가스 온도 =T_3*(1/ER)^(γ_gasavr-1)"));
		dataList.add(new Data("P_4", 33.9586483063037,"배기가스 압력 = P_3*(1/ER)^γ_gasavr"));
		dataList.add(new Data("T_4excel", 1354.07594607931,""));
		dataList.add(new Data("P_4excel", 33.9586483063037,""));
		dataList.add(new Data("T_5", 958.464933208869,"배기가스 배출 후 연소실 온도(연소가스가 대기압으로 팽창한 후 온도 K) =T_4*(P_5/P_4)^((γ_gasavr-1)/γ_gasavr) "));
		dataList.add(new Data("V_a5", 108.11581677819,"양방향 체크밸브가 열려 V_atk와 V_2가 합쳐질떄 체적 = V_atk + V_2"));
		dataList.add(new Data("T_a5", 874.267702894261,"얍축과정에서 양방향 체크밸브가 열려 air tank 온도(T_2)와 연소실 공기 온도(T_5)가 섞일떄 온도 = T_atk*T_5*(P_atk*V_atk+P_5*V_5)/(P_atk*V_atk*T_5 + P_5*V_5*T_atk)"));
		dataList.add(new Data("P_12", 174.1923,""));
		dataList.add(new Data("T_12", 649.140746990676,"압축기 압력이 P_a5와 동일할때 압축공기 온도"));
		dataList.add(new Data("V_12", 51.0300244523305,"압축기 압력이 P_a5와 동일할때 압축공간 부피"));
		dataList.add(new Data("T_2a5", 786.775393666932,"압축기 체크밸브까지 열려 압축기 압축공기, air tank, 연소실 공기가 섞일때 온도(압력은 P_a5와 동일)"));
		dataList.add(new Data("P_2a5", 174.1923,"압축기 체크밸브까지 열려 압축기 압축공기, air tank, 연소실 공기가 섞일때 압력 = P_a5"));
		dataList.add(new Data("P_atkp", 299.29360567788,"8) 압축기 fully 압축시 공기압 ! 이 압력은 P_2와 동일하여야 함.(계산이 맞다면)"));
		dataList.add(new Data("T_atkp", 918.360494386825,"8) 압축기 fully 압축시 공기온도 ! 이 온도는 T_2와 동일하여야 함."));
		dataList.add(new Data("T_c_excel", 918.694623581914,"8) T_2와 같은 값인지 확인 필요"));

	}

} 