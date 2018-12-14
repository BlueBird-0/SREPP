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

	//dataList�� 'string'�� ���� key �� ����ִ� double�� ����
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
		ArrayList<Data> changeableList = new ArrayList<>();
		for (Data data : dataList) {
			if (data.state != 100)
			{
				changeableList.add(data);
			}
		}
		return changeableList;
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

	public static ArrayList<Data> getProperties()
	{
		ArrayList<Data> changeableList = new ArrayList<>();
		for (Data data : dataList) {
			if (data.state == 1|| data.state == 0)
			{
				changeableList.add(data);
			}
		}
		return changeableList;
	}
	public static ArrayList<Data> getPistonEngineList()
	{
		ArrayList<Data> pistonEngineList = new ArrayList<>();
		for	(Data data : dataList) {
			if(data.state == 2)
			{
				pistonEngineList.add(data);
			}
		}
		return pistonEngineList;
	}
	public static ArrayList<Data> getSreEngineList()
	{
		ArrayList<Data> pistonEngineList = new ArrayList<>();
		for	(Data data : dataList) {
			if(data.state == 3)
			{
				pistonEngineList.add(data);
			}
		}
		return pistonEngineList;
	}
	
	
	public static void initData()
	{
		//1. �����, ���ҽ�, ��â�� geometry     ����: cm,  �з�: N/cm^2, �µ�: K
		dataList.add(new Data(1,"dt", 0.000138888888888889,"�ð� ����(1200rpm���� ȸ����) (=1/(1200/60)*360) sec/deg)"));
		dataList.add(new Data(1,"P_1", 10.1325,"ǥ�ش��� (= 10.1325 N/cm^2)"));
		dataList.add(new Data(1,"T_1", 288,"ǥ�ش��µ� (=15+273 K)"));
		dataList.add(new Data(1,"rhousing", 7,"1) �Ͽ�¡ ���� �ݰ� ( 5cm)"));
		dataList.add(new Data(1,"rrotorc", 5.04,"1) compressor ���� �ݰ� (cm)"));
		dataList.add(new Data(1,"rrotore", 4.2,"1) expander ���� �ݰ� (cm)"));
		dataList.add(new Data(1,"drotorc", 7,"1) compressor ���� �β� (5cm)"));
		dataList.add(new Data(1,"drotore", 7,"1) expander ���� �β� (5cm)"));
		dataList.add(new Data(1,"voleff", 0.75,"1) ����� ���� ȿ��(75%)"));
		dataList.add(new Data(1,"lvane", 4.55,"1) vane ���� ( = 3.5cm)"));
		dataList.add(new Data("Irotor", 0.003556224,"1) ���� angular momentum( = 1/2*mrotorc*(rrotroc*1.2)^2+1/2*mrotore*(rrotore*1.2)^2) kg*m^2"));
		dataList.add(new Data("rpresc", 0.0602,"compressor ������ ���� ����� ��� �ݰ� = (rrotor+rhousing)/2/100,  m"));
		dataList.add(new Data("rprese", 0.056,"expander ������ ������ �з¸� ��չݰ�, m"));
		dataList.add(new Data("rvanefricc", 0.05236,"compressor vane�� rotor ���˸��� ��չݰ� ( = rrotor + (rhousing-rrotor)/10),  m"));
		dataList.add(new Data("rvanefrice", 0.0448,"expander vane�� rotor ���˸��� ��չݰ� ( = rrotor + (rhousing-rrotor)/10),  m"));
		dataList.add(new Data(1,"CR", 10,"2) Compression Ratio ( = 10): ���谪���� input "));
		dataList.add(new Data(1,"T_max", 3773,"2) ���ҽ� ���ҿµ� ���� ��( = 2000 + 273 K)  116,133����������"));
		dataList.add(new Data("V_1m2", 389.216940401485,"����� ����(����ü��) ( (rhousing^2-rrotorc^2)*��*drotorc*voleff  cm^3 )"));
		dataList.add(new Data("V_1", 432.463267112761,"����� �� ����( = V_1m2/(CR-1)*CR)"));
		dataList.add(new Data("V_2", 43.2463267112761,"���ҽ� ���� ( = V_1/CR cm^3)"));
		dataList.add(new Data("V_atk", 64.8694900669142,"2) Air tank�� size <= ����ȿ�� ���̱� ���� air tank ����ȭ �ʿ�"));
		dataList.add(new Data("ER", 12.9601328903654,"��â��=(rhousing^2-rrotore^2)*��*drotore*voleff/V_2 +1"));
		dataList.add(new Data("V_4m2", 517.2313776,"��â�� ����(����ü��) ((rhousing^2-rrotore^2)*��*drotore*voleff  cm^3 )"));
		dataList.add(new Data("V_4", 560.4781411983,"��â�� �� ����( = V_2*ER  cm^3)"));
		dataList.add(new Data(1,"gamma_airavr", 1.4,"������� 250K~700K���� gamma ��հ� =AVERAGE(��ü���!C39:C48) => constant�� ����"));

		
		dataList.add(new Data(1,"P_2", 298.49,"3) ���ҽ� �ʱ� �з� ����,  6) P_2 �� update"));
		dataList.add(new Data("P_atk", 283.5655,"air tank �з��� �ʱ⿡�� P_2�� �����ϳ� cooling ȿ���� P_2��  "));
		dataList.add(new Data("P_5", 10.1325,"��Ⱑ�� ���� �� ���ҽ� �з�( ���� P_1�� ����)"));
		dataList.add(new Data("V_5", 43.2463267112761,"V_5=V_2   !air tank�� ���ҽ� ���Ⱑ �������� �з� �� �µ� ����� ���� V_5�� ���ҽ� ���ǿ� ����"));
		dataList.add(new Data("P_a5", 174.1923,"4) ����������� ����� üũ��갡 ���� air tank �����(P_2)�� ���ҽ� ������(P_5)�� ���ϋ� �з� = (P_2*V_atk+P_5*V_5)/(V_atk+V_5)"));
		dataList.add(new Data(1,"PRDopen", 270,"4) Push rod open�� ����� ���� ���� "));


		dataList.add(new Data("p_c", 0.0,"����� ����� (= IF(N73<PRDopen, S72*(P72/P73)^R73, S72*(Q72/Q73)^R73) (N/cm^2)"));
		dataList.add(new Data("P_c_excel", 298.488503374969,"5) excel ���� ���� ����� �ִ� �����.  P_2�� ���ƾ� ��."));


		dataList.add(new Data(1,"T_2", 918.36,"7) ���ҽ� �ʱ� �µ� ( K) ����"));
		dataList.add(new Data("T_atk", 872.442,"8) T_atk = T_2*(P_atk/P_2)   "));
		dataList.add(new Data("T_3", 3773,"���ҽ� ���ҿµ� =T_max"));
		dataList.add(new Data("P_3", 1226.31949344484,"���߽� ���ҽ� �з�(N/cm^2) (= P_2*T_3/T_2)"));
		dataList.add(new Data("gamma_gasavr", 1.4,"��â���� T3�� T4������ gamma ��հ� =AVERAGE(��ü���!E9:E13) => constant�� ����"));
		dataList.add(new Data("T_4", 1354.07594607931,"��Ⱑ�� �µ� =T_3*(1/ER)^(gamma_gasavr-1)"));
		dataList.add(new Data("P_4", 33.9586483063037,"��Ⱑ�� �з� = P_3*(1/ER)^gamma_gasavr"));
		dataList.add(new Data("T_4excel", 1354.07594607931,""));
		dataList.add(new Data("P_4excel", 33.9586483063037,""));
		dataList.add(new Data("T_5", 958.464933208869,"��Ⱑ�� ���� �� ���ҽ� �µ�(���Ұ����� �������� ��â�� �� �µ� K) =T_4*(P_5/P_4)^((gamma_gasavr-1)/gamma_gasavr) "));
		dataList.add(new Data("V_a5", 108.11581677819,"����� üũ��갡 ���� V_atk�� V_2�� �������� ü�� = V_atk + V_2"));
		dataList.add(new Data("T_a5", 874.267702894261,"����������� ����� üũ��갡 ���� air tank �µ�(T_2)�� ���ҽ� ���� �µ�(T_5)�� ���ϋ� �µ� = T_atk*T_5*(P_atk*V_atk+P_5*V_5)/(P_atk*V_atk*T_5 + P_5*V_5*T_atk)"));
		dataList.add(new Data("P_12", 174.1923,""));
		dataList.add(new Data("T_12", 649.140746990676,"����� �з��� P_a5�� �����Ҷ� ������� �µ�"));
		dataList.add(new Data("V_12", 51.0300244523305,"����� �з��� P_a5�� �����Ҷ� ������� ����"));
		dataList.add(new Data("T_2a5", 786.775393666932,"����� üũ������ ���� ����� �������, air tank, ���ҽ� ���Ⱑ ���϶� �µ�(�з��� P_a5�� ����)"));
		dataList.add(new Data("P_2a5", 174.1923,"����� üũ������ ���� ����� �������, air tank, ���ҽ� ���Ⱑ ���϶� �з� = P_a5"));
		dataList.add(new Data("P_atkp", 299.29360567788,"8) ����� fully ����� ����� ! �� �з��� P_2�� �����Ͽ��� ��.(����� �´ٸ�)"));
		dataList.add(new Data("T_atkp", 918.360494386825,"8) ����� fully ����� ����µ� ! �� �µ��� T_2�� �����Ͽ��� ��."));
		dataList.add(new Data("T_c_excel", 918.694623581914,"8) T_2�� ���� ������ Ȯ�� �ʿ�"));


		//���� ��� ����
		dataList.add(new Data("rpm_1", 7200, "2) �ʱ� ���� rpm"));
		dataList.add(new Data("frcoevane", 0.1, "2) vane�� rotor ���˸��� friction coefficient (=0.1)"));
		dataList.add(new Data("Efcomb", 0.98, "2) ���ҽ� ����ȿ��0.95~0.98) 73����������"));
		dataList.add(new Data("Qloss", 0.15, "2) ���� ���ս�(��ü ���� �߿��� ��� 15~20%)"));
		dataList.add(new Data("Rair", 287, "��ü��� ( = 0.287kJ/(Kg K) = 287 (J/kg K)"));
	
		//������ ���
		dataList.add(new Data("Mair", 0, "����� ���԰��� ���� (= (P_1*10^4*V_1/10^6)/(Rair*T_1)) kg/rev   "));
		dataList.add(new Data("Mair_atk", 0, "Air Tank ���ⷮ = P_atkp*10^4*V_atk/10^6/(Rair*T_atkp)"));
		dataList.add(new Data(1,"Q_hv", 44000, "���� heat value ( = 44,000 kJ/kg)"));
		dataList.add(new Data(1,"C_V", 0.718, "���� ������ ( = 0.718 kj/(kg K))"));
		dataList.add(new Data("C_V1", 0, "T_1 ~ T_2 �������� ���������� ��� =AVERAGE(��ü���!AA4:AA10) => constant�� ����"));
		dataList.add(new Data("C_V2", 0, "T_2 ~ T_3 �������� ���������� ��� =AVERAGE(��ü���!AA8:AA28) => constant�� ����"));
		dataList.add(new Data("C_V3", 0, "���Ⱑ�� ���� Cv=AVERAGE(��ü���!AA10:AA15) => constant�� ����"));
		dataList.add(new Data("Mfuel", 0, "T_3�� �����ϱ� ���� ���ᷮ ( = Mair*C_V2*(T_3-T_2)/(Q_hv*Efcomb)  kg/rev"));
		dataList.add(new Data("AF", 0, "air to fuel ratio ( = Mair/Mfuel)"));
		dataList.add(new Data("Q_sec", 0, "�ð�(��)�� ���ῡ���� input ( = Mfuel*Q_hv*rpm_1/60 kJ/sec)"));
		dataList.add(new Data("Q_ps", 0, "���ῡ���� ȯ�� ���� ( = Q_sec*1000*0.0013596 ps)"));
		
		
		//1) Piston ����, ���� CR �� ER, Mfuel �л�, �����ս�, ���ս� �̹ݿ�gamma , Cv�� ���� ������ ����.
		dataList.add(new Data(2, "P_Pt_2", 2, "�ǽ��濣�� Cr ������ ����� �з�"));
		dataList.add(new Data(2, "T_Pt_2", 2, "�ǽ��濣�� Cr ������ ����� �µ�"));
		dataList.add(new Data(2, "T_Pt_3", 2, "�ǽ��濣�� ���ҽ� �µ�(SRE�� ���Ͼ��� ���� �л� ����)"));
		dataList.add(new Data(2, "P_Pt_3", 2, "�ǽ��濣�� ���ҽ� ������ �ʱ�з�(SRE�� ���Ͼ��� ���� �л� ����)"));
		dataList.add(new Data(2, "P_Pt_4", 2, "CR�� ��â�� ���Ұ��� �з�"));
		dataList.add(new Data(2, "T_Pt_4", 2, "CR�� ��â�� ���Ұ��� �µ�"));
		dataList.add(new Data(2, "P_Pt_4oe", 2, "ER�� ��â�� ���Ұ��� �з�"));
		dataList.add(new Data(2, "T_Pt_4oe", 2, "ER�� ��â�� ���Ұ��� �µ�"));
		dataList.add(new Data(2, "P_Pt_5", 2, " ! 1ȸ iteration ����, ��� �� ������ �����ִ� ��Ⱑ���� ���԰����� ȥ�ձ� �µ� �� �з� ���"));
		dataList.add(new Data(2, "T_Pt_5", 2, "iteration ��Ⱑ�� ���� �� ���ҽ� �µ�(���Ұ����� �������� ��â�� �� �µ� K) =T_Pst_4*(P_Pst_5/P_Pst_4)^((gamma_gasavr-1)/gamma_gasavr) "));
		dataList.add(new Data(2, "Mair_Pt", 2, "����� ���԰��� ���� = (P_1*10^4*V_1m2/10^6)/(Rair*T_1) + P_5*10^4*V_5/10^6/(Rair*T_Pst_5) kg/rev"));
		dataList.add(new Data(2, "P_Pt_5oe", 2, ""));
		dataList.add(new Data(2, "T_Pt_5oe", 2, "��Ⱑ�� ���� �� ���ҽ� �µ�(���Ұ����� �������� ��â�� �� �µ� K) =T_Pst_4*(P_Pst_5/P_Pst_4)^((gamma_gasavr-1)/gamma_gasavr) "));
		dataList.add(new Data(2, "Mair_Pt_oe", 2, "����� ���԰��� ���� = (P_1*10^4*V_1m2/10^6)/(Rair*T_1) + P_5*10^4*V_5/10^6/(Rair_Pt_oe*T_5)"));
		dataList.add(new Data(2, "P_Pt_15", 2, "���԰���� ��â �� ���Ұ����� ȥ�� ������ �з�"));
		dataList.add(new Data(2, "T_Pt_15", 2, "���԰���� ��â �� ���Ұ����� ȥ�� ������ �µ� "));
		dataList.add(new Data(2, "P_Pt_15oe", 2, "���԰���� ��â �� ���Ұ����� ȥ�� ������ �з�"));
		dataList.add(new Data(2, "T_Pt_15oe", 2, "���԰���� ��â �� ���Ұ����� ȥ�� ������ �µ� "));
		
		//first iteration
		dataList.add(new Data(2, "P_Pst_2", 2, "�ǽ��濣�� Cr ������ ����� �з�"));
		dataList.add(new Data(2, "T_Pst_2", 2, "�ǽ��濣�� Cr ������ ����� �µ�"));
		dataList.add(new Data(2, "P_Pst_2oe", 2, "�ǽ��濣�� Er ������ ����� �з�"));
		dataList.add(new Data(2, "T_Pst_2oe", 2, "�ǽ��濣�� Er ������ ����� �µ�"));
		dataList.add(new Data(2, "T_Pst_3", 2, "�ǽ��濣�� ���ҽ� �µ�(SRE�� ���Ͼ��� ���� �л� ����)"));
		dataList.add(new Data(2, "P_Pst_3", 2, "�ǽ��濣�� ���ҽ� ������ �ʱ�з�(SRE�� ���Ͼ��� ���� �л� ����)"));
		dataList.add(new Data(2, "T_Pst_3oe", 2, "�ǽ��濣�� ���ҽ� �µ�(SRE�� ���Ͼ��� ���� �л� ����)"));
		dataList.add(new Data(2, "P_Pst_3oe", 2, "�ǽ��濣�� ���ҽ� ������ �ʱ�з�(SRE�� ���Ͼ��� ���� �л� ����)"));
		dataList.add(new Data(2, "P_Pst_4", 2, "CR�� ��â�� ���Ұ��� �з�"));
		dataList.add(new Data(2, "T_Pst_4", 2, "CR�� ��â�� ���Ұ��� �µ�"));
		dataList.add(new Data(2, "P_Pst_4oe", 2, "ER�� ��â�� ���Ұ��� �з�"));
		dataList.add(new Data(2, "T_Pst_4oe", 2, "ER�� ��â�� ���Ұ��� �µ�"));
		dataList.add(new Data(2, "T_Pst_5", 2, "��Ⱑ�� ���� �� ���ҽ� �µ�(���Ұ����� �������� ��â�� �� �µ� K) =T_Pst_4*(P_5/P_Pst_4)^((gamma_gasavr-1)/gamma_gasavr) "));
		dataList.add(new Data(2, "Mair_Pst", 2, "����� ���԰��� ���� (= (P_1*10^4*V_1/10^6)/(Rair*T_1)) kg/rev   "));
		dataList.add(new Data(2, "T_Pst_5oe", 2, "��Ⱑ�� ���� �� ���ҽ� �µ�(���Ұ����� �������� ��â�� �� �µ� K) =T_4*(P_5/P_4)^((gamma_gasavr-1)/gamma_gasavr) "));
		dataList.add(new Data(2, "Mair_Pst_oe", 2, "����� ���԰��� ���� (= (P_1*10^4*V_1/10^6)/(Rair*T_1)) kg/rev   "));
		
		//end of iteration
		dataList.add(new Data(2, "eta_pst_th", 2, "��ȿ�� ( = 1 - 1/CR^(gamma_airavr-1))   !  �Ϲ� �ǽ��濣��(ER=CR) �̷� ��ȿ��"));
		dataList.add(new Data(2, "eta_pst_th2", 2, "'= 1*Efcomb - Mair_Pst* (C_V3*T_Pst_4 - C_V*T_1)/(Mfuel*Q_hv)           "));
		dataList.add(new Data(2, "eta_pst_At", 2, "��ȿ�� ( = 1-gamma_airavr*(ER-CR)/(ER^gamma_airavr-CR^gamma_airavr)) : ���� ER������ �ǽ��濣�� Atkinson Cycle ȿ�� "));
		dataList.add(new Data(2, "eta_pst_oe", 2, "��ȿ��(= 1*Efcomb - Mair_Pst_oe* (C_V2*T_Pst_4oe - C_V*T_1)/(Mfuel*Q_hv)) : Piston engine over expanded cycle �� ȿ��, "));
		dataList.add(new Data(2, "Ps_Pst_th", 2, "' = Q_ps*eta_pst_th1"));
		dataList.add(new Data(2, "Ps_Pst_At", 2, "' = Q_ps*eta_pst_At"));
		
		//2) ERȿ�� �ݿ�, �����ս�, ���ս� �̹ݿ�, gamma , Cv ���� �µ����� ��հ� ����.
		//dataList.add(new Data(3, "", Double.MAX_VALUE, "dd"));
		dataList.add(new Data(3, "2)eta_SRE_1", 3, "��ȿ�� ( = 1*Efcomb - (Mair* (C_V3*(W612+273) - C_V*T_1)+Mair_atk*(C_V1*(T_2-T_atk)))/(Mfuel*Q_hv))"));
		dataList.add(new Data(3, "2)Ps_SRE_1", 3, "' = Q_ps*B138"));
		dataList.add(new Data(3, "2)eta_SRE_2", 3, "eta_analysis = 1/2*Irotor*(omega2^2 - omega1^2))/(Mfuel*Q_hv*1000)  "));
		dataList.add(new Data(3, "2)Ps_SRE_2", 3, "��� = 1/2*Irotor*(Z612^2 - Z72^2)/(60/rpm_1)*0.0013596"));
		

		//3) ER ȿ��, �����ս� �ݿ�, ���ս� �̹ݿ�, gamma , Cv ���� �µ����� ��հ� ����.		dataList.add(new Data(5, "eta_SRE_1", 0, "��ȿ�� ( = 1*Efcomb - (Mair* (C_V3*(W612+273) - C_V*T_1)+Mair_atk*(C_V1*(T_2-T_atk)))/(Mfuel*Q_hv))"));
		dataList.add(new Data(3, "3)eta_SRE_1", 3, "'=B148/B141*B140  ������ ���� �ս��� 'eta_SRE_2'���� Ȯ���� ������ ���"));
		dataList.add(new Data(3, "3)Ps_SRE_1", 3, "'=Q_ps*B149"));
		dataList.add(new Data(3, "3)eta_SRE_2", 3, "eta_analysis = 1/2*Irotor*(omega2^2 - omega1^2))/(Mfuel*Q_hv*1000)"));
		dataList.add(new Data(3, "3)Ps_SRE_2", 3, "��� = 1/2*Irotor*(AC520^2 - AC251^2)/(60/rpm_1)*0.0013596"));

  
		//4) ER ȿ��, �����ս�, ���ս� �ݿ�, gamma , Cv ���� �µ����� ��հ� ����
		dataList.add(new Data(3, "4)eta_SRE_1", 3, "���ս��� ��ü ������"));
		dataList.add(new Data(3, "4)Ps_SRE_1", 3, "'=Q_ps*B154"));
		dataList.add(new Data(3, "4)sfc_SRE_1", 3, "'=Mfuel/0.4536*rpm_1*60/B156"));
		dataList.add(new Data(3, "4)eta_SRE_2", 3, "���ս��� ��ü ������"));
		dataList.add(new Data(3, "4)Ps_SRE_2", 3, "'=Q_ps*B155"));
		dataList.add(new Data(3, "4)sfc_SRE_2", 3, "'=Mfuel/0.4536*rpm_1*60/B158"));
		
		//�׷����� �̿��� ȿ�� ���
		//dataList.add(new Data(3, "ȿ��", 3, ""));
		//dataList.add(new Data(3, "��", 3, ""));
		//dataList.add(new Data(3, "����", 3, ""));
		dataList.add(new Data(100, "ȿ��", 3, ""));
		dataList.add(new Data(100, "��", 3, ""));
		dataList.add(new Data(100, "����", 3, ""));
	}

} 