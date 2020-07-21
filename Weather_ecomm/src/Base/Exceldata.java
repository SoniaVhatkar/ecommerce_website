 package Base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceldata extends Basic {
	
	static Workbook book;
	static  org.apache.poi.ss.usermodel.Sheet sheet;
	/*
	 * @Methodname   : getdata
	 * @Description  : This is common method that reads multiple data from excel
	 * @Param        : String sheetname
	 * @Return		 : object[][] data
	 * @Author		 : Sonia Vhatkar
	 */
	
	public static Object[][] getdata(String sheetname) {
		
		try {
			
			book = WorkbookFactory.create(new FileInputStream(XL_PATH));
			
		} catch (EncryptedDocumentException|IOException e) {
			e.printStackTrace();
		}
		
		sheet= book.getSheet(sheetname);
		
		/*0th row as header row */
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();	/*Ignoring 0th row and taking preceding rows data*/
			}
			
		}
		
		return data;
	}
	
	
	
}