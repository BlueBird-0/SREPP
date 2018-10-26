package FileSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

import DataManager.Data;
import DataManager.DataManager;
import DataManager.ResultData;
import application.MainProgramManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
 
public class FileSystem {
	// ���α׷� ���� �� ����
	public static boolean checkedAllList = false;
	public static double tolerance = 0.0000001;
	public static String saveDirectory = "";
	
	public static void setDirectory()
	{
		saveDirectory = System.getProperty("user.dir")+"\\save";
	}
	
	public static void fileOpen()
	{
		File saveFolder = new File(System.getProperty("user.dir")+"\\save");
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(saveFolder);
		fileChooser.getExtensionFilters().add(new ExtensionFilter("TEXT (*.txt)", "*.txt"));
		File file = fileChooser.showOpenDialog(MainProgramManager.getPrimaryStage());
		
		if(file != null)
		{
			try (Scanner scanner = new Scanner(file)) {
				int mode = 0; //0 : null,	1 : #properties,		2 : #argument
		        while (scanner.hasNext())
		        {
		        	String data = scanner.nextLine();
					//�ּ��� �� ó��
		        	if(data.substring(0, 2).equals("//")){
		        		continue;
		        	}
		        	else if(data.equals("#properties"))
		        	{
		        		mode = 1;
		        		continue;
		        	}else if(data.equals("#argument"))
		        	{
		        		mode = 2;
		        		continue;
		        	}else if(data.equals("#result"))
		        	{
		        		mode = 0;
		        		//continue;
		        		break;
		        	}
		        	
		        	System.out.println(data);
		        	//������ ������ �κ�
		        	if(mode == 1)
		        	{
		        		String value = data.split("\\s+")[1];
		        		if(data.split("\\s+")[0].equals("tolerance"))
		        		{
		        			tolerance = Double.valueOf(value);
		        		}else if(data.split("\\s+")[0].equals("savedirectory"))
		        		{
		        			saveDirectory = value;
		        		}
		        	}
		        	if(mode == 2)
		        	{
		        		double value = Double.valueOf(data.split("\\s+")[1]);
		        		String comment = "";
		        		int comment_start = data.split("\\s+")[0].length() + data.split("\\s+")[1].length()+2;
		        		if(comment_start < data.length()+1)
		        		{
		        			comment = data.substring(comment_start);
		        		}
		        		
		        		DataManager.setData(data.split("\\s+")[0], value, comment);
		        		System.out.println(data.split("\\s+")[0]+"�� |"+value+"   comment |"+comment);
		        	}
		        }
		        Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Message");
		        alert.setHeaderText("File open successful!");
		        alert.setContentText("c:/root/wow/file.txt");

		        alert.showAndWait();
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public static void fileSave()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(MainProgramManager.getPrimaryStage());
		
		if(file!=null)
		{
			try {
				PrintWriter writer;
				writer = new PrintWriter(file);
				writer.println("���� ���� ���� Ȯ��");
				writer.close();
			}catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public static void fileSaveAs()
	{
		File saveFolder = new File(System.getProperty("user.dir")+"\\save");
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		FileChooser fileChooser = new FileChooser();
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy_mm_dd");
		String timeStr = dayTime.format(new Date(time));
		fileChooser.setInitialFileName("SREPP_"+timeStr);
		fileChooser.setInitialDirectory(saveFolder);
		fileChooser.getExtensionFilters().add(new ExtensionFilter("TEXT (*.txt)", "*.txt"));
		File file = fileChooser.showSaveDialog(MainProgramManager.getPrimaryStage());
		
		if(file!=null)
		{
			try {
				PrintWriter writer;
				writer = new PrintWriter(file);
				//TODO ���� ���� �κ�
				writer.println("//���� �ɼ�");
				writer.println("#properties");
					writer.println("tolerance\t"+tolerance);
					writer.println("saveDirectory\t"+saveDirectory);
				writer.println("//");
				writer.println("//����� ���� ��");
				writer.println("#argument");
					for(Data data : DataManager.getChangeableList())
					{
						writer.println(data.key.get()+"\t"+data.value.get()+"\t"+data.comment.get());
					}
				writer.println("//");
				writer.println("//��� ����(���� ���� ���ÿ�.)");
				writer.println("#result");
					for(ResultData data : DataManager.resultDataList)
					{
						for(int i=0; i<31; i++)
						{
							writer.print(data.g(i)+"\t");
						}
						writer.println("");
					}
				writer.close();
				System.out.println("���� ����");
			}catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
