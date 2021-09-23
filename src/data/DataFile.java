package data;

import utilities.Xls_Reader;

public class DataFile {
	
Xls_Reader r = new Xls_Reader("C:\\Users\\dnp15\\OneDrive\\Desktop\\QA_Training\\DataForBasic.xlsx");
	
	public String wrongUserName = r.getCellData("Sheet1", 0, 4);
	public String wrongPassword = r.getCellData("Sheet1", 1, 4);
	public String invalidUserName = r.getCellData("Sheet1", 2, 4);
	public String genericErr = r.getCellData("Sheet1", 3, 4);
	public String emptyEmailErr = r.getCellData("Sheet1", 5, 4);
	public String emptyPasswordErr = r.getCellData("Sheet1", 6, 4);

}
