package util;


	import java.io.FileInputStream;
	import java.io.FileOutputStream;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;


	public class XLLib 
	{
		public static String getStringData (String sheet, int row, int col) throws Exception
		{
			FileInputStream fis = new FileInputStream(Constants.xLData);
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
			return data;
		}
		
		public static double getNumericData (String sheet, int row, int col) throws Exception
		{
			FileInputStream fis = new FileInputStream(Constants.xLData);
			Workbook wb = WorkbookFactory.create(fis);
			double data = wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
			return data;
		}

		public static void setStringData(String sheet, int row,int col,String data) throws  Exception
		{
			FileInputStream fis = new FileInputStream(Constants.xLData);
			Workbook wb = WorkbookFactory.create(fis);
			Row r = wb.getSheet(sheet).getRow(row);
			if (r!=null)
			{
				Cell c = wb.getSheet(sheet).getRow(row).getCell(col);
					if (c!=null)
							{
								c.setCellValue(data);
							}	
					else
						{
							
							c=r.createCell(col);
							c.setCellValue(data);
						}
				
			}
			else 
			{
				r= wb.getSheet(sheet).createRow(row);
				Cell c = wb.getSheet(sheet).getRow(row).getCell(col);
						if (c!=null)
							{
								c.setCellValue(data);
							}	
						else
							{
								
								c=r.createCell(col);
								c.setCellValue(data);
							}
			}
			FileOutputStream fos = new FileOutputStream(Constants.xLData);
				wb.write(fos);
				wb.close();
		}
		
		public static void setNumericData(String sheet, int row,int col,double data) throws  Exception
		{
			FileInputStream fis = new FileInputStream(Constants.xLData);
			Workbook wb = WorkbookFactory.create(fis);
			if(wb.getSheet(sheet).getRow(row).equals(null))
			{
				wb.getSheet(sheet).createRow(row);
			}
			else if(wb.getSheet(sheet).getRow(row).getCell(col).equals(null))
			{
				wb.getSheet(sheet).getRow(row).createCell(col).setCellValue(data);
			}
			else 
			{
				wb.getSheet(sheet).getRow(row).getCell(col).setCellValue(data);
			}
		
			FileOutputStream fos = new FileOutputStream(Constants.xLData);
			wb.write(fos);
			wb.close();
		}
	}




