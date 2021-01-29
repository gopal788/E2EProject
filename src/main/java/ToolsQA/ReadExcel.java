package ToolsQA;
import java.io.FileInputStream; 
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel
{
	public static XSSFWorkbook ExcelWorkbook;
	public static XSSFSheet ExcelSheet;
	public static XSSFCell ExcelCell;
	public static void setExcelFile(String Path,int SheetNumber) throws IOException
	{
		FileInputStream Excelfile=new FileInputStream(Path);
        ExcelWorkbook=new XSSFWorkbook(Excelfile);
        ExcelSheet=ExcelWorkbook.getSheetAt(SheetNumber);
	}
	public static String getCellData(int RowNum,int ColNum)
	{
		ExcelCell=ExcelSheet.getRow(RowNum).getCell(ColNum);
		String CellData=ExcelCell.getStringCellValue();
		return CellData;
	}
	public static int getRowCount(int SheetNumber)
	{
		ExcelSheet=ExcelWorkbook.getSheetAt(SheetNumber);
		int RowCount=ExcelSheet.getLastRowNum();
		return RowCount;
	}

}
