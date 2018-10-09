package application;

import DataManager.DataManager;
import DataManager.ResultData;

public class ComputeManager {
	public static void initCompute()
	{
		CalculatingStatus = true;
		//= 0.5*(1.25*(rrotorc*1.2/100)^2 +1*(rrotore*1.2/100)^2)
		DataManager.setData("Irotor", 0.5*( 1.25*Math.pow((DataManager.g("rrotorc")*1.2/100),2) +1*Math.pow((DataManager.g("rrotore")*1.2/100),2)));
		//= (rrotorc+rhousing)/2/100
		DataManager.setData("rpresc", (DataManager.g("rrotorc")+DataManager.g("rhousing"))/2/100);
		//= (rrotore+rhousing)/2/100
		DataManager.setData("rprese", (DataManager.g("rrotore")+DataManager.g("rhousing"))/2/100);
		//=(rrotorc+(rhousing-rrotorc)/10)/100
		DataManager.setData("rvanefricc", (DataManager.g("rrotorc")+(DataManager.g("rhousing")-DataManager.g("rrotorc"))/10)/100);
		//=(rrotore+(rhousing-rrotore)/10)/100
		DataManager.setData("rvanefrice", (DataManager.g("rrotore")+(DataManager.g("rhousing")-DataManager.g("rrotore"))/10)/100);
		//=(rhousing^2-rrotorc^2)*PI()*drotorc*voleff
		DataManager.setData("V_1m2", (Math.pow(DataManager.g("rhousing"),2)-Math.pow(DataManager.g("rrotorc"),2))*Math.PI*DataManager.g("drotorc")*DataManager.g("voleff"));
		//=V_1m2/(CR-1)*CR
		DataManager.setData("V_1", DataManager.g("V_1m2")/(DataManager.g("CR")-1)*DataManager.g("CR"));
		//= V_1/CR
		DataManager.setData("V_2", DataManager.g("V_1")/DataManager.g("CR"));
		//=V_2 * 1.5
		DataManager.setData("V_atk", DataManager.g("V_2")* 1.5);
		//= (rhousing^2-rrotore^2)*PI()*drotore*voleff/V_2 +1
		DataManager.setData("ER", (Math.pow(DataManager.g("rhousing"),2)-Math.pow(DataManager.g("rrotore"),2))*Math.PI*DataManager.g("drotore")*DataManager.g("voleff")/DataManager.g("V_2") +1);
		//=(rhousing^2-rrotore^2)*3.14159*drotore*voleff
		DataManager.setData("V_4m2", (Math.pow(DataManager.g("rhousing"),2)-Math.pow(DataManager.g("rrotore"),2))*Math.PI*DataManager.g("drotore")*DataManager.g("voleff"));
		//= V_2*ER
		DataManager.setData("V_4", DataManager.g("V_2")*DataManager.g("ER"));

		CalculatingStatus = false;
	}
	public static void pressCompute()
	{
		CalculatingStatus = true;
		//P_2 임의값 조정

		CalculatingStatus = false;
	}
	
	public static void resultCompute()
	{
		CalculatingStatus = true;
		System.out.println("계산시작 ");
		//현재 계산하는 값		resultData
		ResultData rData = new ResultData();

		//이전 셀 값 가지고있음	previousData
		ResultData pData = new ResultData();
		
		//0	389.2169404	497.3327572	1.4	10.1325	15	43.24632671	1.4	1226.319493	3500	0	0	753.9822369	0	0	7200	97.80058216	0.0000000 	0	753.9822369	0	0	7200	83.84253863	270	10	1	1	117.3047101	1	121.0283241
		double d[] = {0,	389.2169404,	497.3327572,	1.4,10.1325,15	,43.24632671,	1.4,	1226.319493	,3500	,0	,0	,753.9822369	,0	,0	,7200	,97.80058216	,0.0000000 	,0	,753.9822369	,0	,0	,7200	,83.84253863	,270	,10	,1	,1	,117.3047101	,1	,121.0283241};
		for(int i=0; i<31; i++)
			pData.setValue(i, d[i]);
		DataManager.resultDataList.add(pData);
		
		for(double degree=0.5; degree<=270;  degree+= 0.5)
		{
			rData = new ResultData();
			//각도
			rData.setValue(0, degree);
			
			//= (rhousing^2-rrotorc^2)*PI()*drotorc*(voleff-1/360*N72)
			rData.setValue(1, (Math.pow(DataManager.g("rhousing"),2)-Math.pow(DataManager.g("rrotorc"),2))*Math.PI*DataManager.g("drotorc")*(DataManager.g("voleff")-1/360* rData.g(0)));
			//= (rhousing^2-rrotorc^2)*PI()*drotorc*(voleff-1/360*N72)+V_a5
			rData.setValue(2, (Math.pow(DataManager.g("rhousing"),2)-Math.pow(DataManager.g("rrotorc"),2))*Math.PI*DataManager.g("drotorc")*(DataManager.g("voleff")-1/360* rData.g(0))+DataManager.g("V_a5"));
			//1.4
			rData.setValue(3, 1.4);
	
			//= IF(N73<PRDopen, R72*(O72/O73)^Q73, R72*(P72/P73)^Q73)
			if(rData.g(0)<DataManager.g("PRDopen"))
				rData.setValue(4, pData.g(4)*Math.pow((pData.g(1)/rData.g(1)),rData.g(3)));
			else
				rData.setValue(4, pData.g(4)*Math.pow((pData.g(2)/rData.g(2)),rData.g(3)));
			//=IF(N73=PRDopen-0.5, T_12*T_a5*(P_12*V_12+P_a5*V_a5)/(P_12*V_12*T_a5 + P_a5*V_a5*T_12) - 273, (S72+273)*(R73/R72)^((Q73-1)/Q73) -273)
			if(pData.g(0)==DataManager.g("PRDopen")-0.5)
				rData.setValue(5,  DataManager.g("T_12")*DataManager.g("T_a5")*(DataManager.g("P_12")*DataManager.g("V_12")+DataManager.g("P_a5")*DataManager.g("V_a5"))/(DataManager.g("P_12")*DataManager.g("V_12")*DataManager.g("T_a5") + DataManager.g("P_a5")*DataManager.g("V_a5")*DataManager.g("T_12")) - 273);
			else
				rData.setValue(5, Math.pow((pData.g(5)+273)*(rData.g(4)/pData.g(4)),((rData.g(3)-1)/rData.g(3)) -273));
	
			//= (rhousing^2-rrotore^2)*PI()*drotore/360*N73 + V_2
			rData.setValue(6, (Math.pow(DataManager.g("rhousing"),2)-Math.pow(DataManager.g("rrotore"),2))*Math.PI*DataManager.g("drotore")/360*rData.g(0) + DataManager.g("V_2"));
			//1.4
			rData.setValue(7, 1.4);
			//=V72*(T72/T73)^U73
			rData.setValue(8, pData.g(8)*Math.pow((pData.g(6)/rData.g(6)),rData.g(7)));
			//=(W72+273)*(T72/T73)^(U73-1)-273
			rData.setValue(9, (pData.g(9)+273)*Math.pow((pData.g(6)/rData.g(6)),(rData.g(7)-1))-273);
			
	
			
			//=X72+1/(AC72*360*2/60)
			rData.setValue(10, pData.g(10)+1/(pData.g(15)*360*2/60));
			
			
			
			//=(((V72+V73)/2-P_1)*(rhousing-rrotore)*drotore*rprese-((R72+R73)/2-P_1)*(rhousing-rrotorc)*drotorc*rpresc)/Irotor
			rData.setValue(11, (((pData.g(8)+rData.g(8))/2-DataManager.g("P_1"))*(DataManager.g("rhousing")-DataManager.g("rrotore"))*DataManager.g("drotore")*DataManager.g("rprese")-((pData.g(4)+rData.g(4))/2-DataManager.g("P_1"))*(DataManager.g("rhousing")-DataManager.g("rrotorc"))*DataManager.g("drotorc")*DataManager.g("rpresc"))/DataManager.g("Irotor"));
			//= Z72+(Y72+Y73)/2*(X73-X72)
			rData.setValue(12, pData.g(12)+(pData.g(12)+rData.g(11))/2*(rData.g(10)-pData.g(10)));
			//= AA72+(Z72+ Z73)/2*(X73-X72) + 0.5*(Y72 + Y73)/2*(X73-X72)^2
			rData.setValue(13, pData.g(13)+(pData.g(12)+ rData.g(12))/2*(rData.g(10)-pData.g(10)) + 0.5*(pData.g(11) + rData.g(11))/2*Math.pow((rData.g(10)-pData.g(10)),2));
			//=AA73*360/2/PI()
			rData.setValue(14, rData.g(13)*360/2/Math.PI);
			//=Z73/2/PI()*60
			rData.setValue(15, rData.g(12)/2/Math.PI*60);
			//
			rData.setValue(16, 0);
			
	
			//=AE72+1/(AJ72*360*2/60)
			rData.setValue(17, pData.g(17)+1/(pData.g(22)*360*2/60));
		
	
			//=(((V72+V73)/2-P_1*1.1)*(rhousing-rrotore)*rprese*drotore-((R72+R73)/2-P_1*0.8)*(rhousing-rrotorc)*rpresc*drotorc - ((V72+V73)/2-P_1*1.1)*drotore*lvane*0.5*frcoevane*rvanefrice - ((R72+R73)/2-P_1*0.8)*drotorc*lvane*0.5*frcoevane*rvanefricc)/Irotor
			//rData.setValue(18, (((pData.g(8)+rData.g(8))/2-DataManager.g("P_1")*1.1)*(DataManager.g("rhousing")-DataManager.g("rrotore"))*DataManager.g("rprese")*DataManager.g("drotore")-((pData.g(4)+rData.g(4))/2-DataManager.g("P_1")*0.8)*(DataManager.g("rhousing")-DataManager.g("rrotorc"))*DataManager.g("rpresc")*DataManager.g("drotorc") - ((pData.g(8)+rData.g(8))/2-DataManager.g("P_1")*1.1)*DataManager.g("drotore")*DataManager.g("lvane")*0.5*DataManager.g("frcoevane")*DataManager.g("rvanefrice") - ((pData.g(4)+rData.g(4))/2-DataManager.g("P_1")*0.8)*DataManager.g("drotorc")*DataManager.g("lvane")*0.5*DataManager.g("frcoevane")*DataManager.g("rvanefricc"))/DataManager.g("Irotor"));
			rData.setValue(18, 0);
	
			//= AG72+(AF72+AF73)/2*(AE73-AE72)
			rData.setValue(19, pData.g(19)+(pData.g(18)+rData.g(18))/2*(rData.g(17)-pData.g(17)));
			//= AH72+(AG72+ AG73)/2*(AE73-AE72) + 0.5*(AF72 + AF73)/2*(AE73-AE72)^2
			rData.setValue(20, pData.g(20)+(pData.g(19)+ rData.g(19))/2*(rData.g(17)-pData.g(17)) + 0.5*(pData.g(18)+rData.g(18))/2*Math.pow((rData.g(17)-pData.g(17)),2));
	
			//=AH73*360/2/3.14159
			rData.setValue(21, rData.g(20)*360/2/Math.PI);
	
			//=AG73/2/PI()*60
			rData.setValue(22, rData.g(19)/2/Math.PI*60);
			
	
			//
			rData.setValue(23, 0);
			
			
			//=270-N73
			rData.setValue(24, 270-rData.g(0));
			//=(CR+1)-(V_1-O73)/V_2
			rData.setValue(25, (DataManager.g("CR")+1)-(DataManager.g("V_1")-rData.g(1))/DataManager.g("V_2"));
			//=T73/V_2
			rData.setValue(26, rData.g(6)/DataManager.g("V_2"));
			//= AO72*((O72+V_2)/(O73+V_2))^Q73
			rData.setValue(27, pData.g(27)*Math.pow(((pData.g(1)+DataManager.g("V_2"))/(rData.g(1)+DataManager.g("V_2"))),rData.g(3)));
			//=AP72*(T72/T73)^U73
			rData.setValue(28, pData.g(28)*Math.pow((pData.g(6)/rData.g(6)),rData.g(7)));
			//=R73/P_1
			rData.setValue(29, rData.g(4)/DataManager.g("P_1"));
			//=V73/P_1
			rData.setValue(30, rData.g(8)/DataManager.g("P_1"));
			DataManager.resultDataList.add(rData);
			pData = rData;
		}

		CalculatingStatus = false;
		System.out.println("계산끝 ");
	}
	
	public static boolean CalculatingStatus;

}
