package ToolsQA;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class DriverScripts
{
	public static Anthem_LoginTestScenarios obj;
	public static String MethodActions;
	public static String ExecutionStatus;
	public static Method[] methods;
	public static void main(String[] args) throws IOException, Exception, IllegalArgumentException, InvocationTargetException
	{
		String Path="C:\\Users\\52101569\\Desktop\\eclipse\\E2EProject\\TestData\\AnthemScenarios.xlsx";
        ReadExcel.setExcelFile(Path, 0);
        for(int irow=1;irow<=ReadExcel.getRowCount(0);irow++)
        {
           MethodActions=ReadExcel.getCellData(irow,0);
           ExecutionStatus=ReadExcel.getCellData(irow,2);
           execute_Methods();
        }
	}
	public static void execute_Methods() throws Exception
	{
		//this is the loop will run for the number of methods in Anthem_LoginTestScenarios class
		//method variable contain all the method and method.length returns the total number of methods.
		obj=new Anthem_LoginTestScenarios();
		methods=obj.getClass().getMethods();
		for(int i=0;i<methods.length;i++)
		{
			if(ExecutionStatus.equalsIgnoreCase("Yes"))
			{
				 execute_Actions();
			}
		}
	}
	private static void execute_Actions() throws Exception {

		for(int i=0;i<methods.length;i++){			
			if(methods[i].getName().equals(MethodActions)){
				methods[i].invoke(obj);
				break;
				}
			}
		}

}
