package com.mom.DAO;

import java.io.File;
import java.io.IOException;

import jxl.*;



public class ExportDAO {

	public static void export() throws IOException, WebServiceException
	{
		try{
			String fileName="D:\\file1.xls";
			WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			Label label=new Label(0,0,"record1");
			sheet.addCell(label);
			Number number=new Number(0,1,3.1459);
			sheet.addCell(number);
			
			workbook.write();
			workbook.close();
		}catch(WriteException e)
		{
		}
	}
}
