package com.eproesp.loginSecurity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class ExcelUtils {
	/*
	@param cell
	@return
	*/
	public static Object getTypedValue(Cell cell) {
		CellType cellType = cell.getCellType();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if (cellType.equals(CellType.FORMULA)) {
			cellType = cell.getCachedFormulaResultType();
			
			FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
			evaluator.evaluateFormulaCell(cell);
			
			String formula = cell.getCellFormula();
		}
		switch (cellType) {
		case BOOLEAN:
			return cell.getBooleanCellValue();
			
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return df.format(cell.getDateCellValue());
			}else {
				Double x = cell.getNumericCellValue();
				
				return x.toString();
			}
			
		case STRING:
			return cell.getStringCellValue();
		
		
		}
		return null;
	}

}
