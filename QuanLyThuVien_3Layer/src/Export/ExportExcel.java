package Export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {

	public void Exportexcel(JTable table) {
		/*
		 * HÀM NÀY BỊ LỖI FONT
		 */
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				FileWriter out = new FileWriter(file + ".xls");
				BufferedWriter bwrite = new BufferedWriter(out);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				// lấy cột
				for (int j = 0; j < table.getColumnCount(); j++) {
					bwrite.write(model.getColumnName(j) + "\t");

				}
				bwrite.newLine();
				for (int j = 0; j < table.getRowCount(); j++) {
					for (int k = 0; k < table.getColumnCount(); k++) {
						bwrite.write(model.getValueAt(j, k) + "\t");
					}
					bwrite.newLine();

				}
				bwrite.close();
				JOptionPane.showMessageDialog(null, "Lưu File Thành Công");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lưu File Thất Bại");
				e.printStackTrace();
			}
		}
	}

	public void xuatExcel(JTable tbl) {

		try {
			TableModel dtm = tbl.getModel();

			JFileChooser chooser = new JFileChooser("export/");
			chooser.setDialogTitle("Lưu vào");
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
			chooser.setFileFilter(fnef);
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				// Lấy đường dẫn vừa chọn + tên tệp
				String path = chooser.getSelectedFile().getPath();
				if (!path.contains(".xlsx")) {
					path += ".xlsx";
				}

				XSSFWorkbook workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet("Sheet 1");

				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short) 14);
				headerFont.setColor(IndexedColors.WHITE.getIndex());
				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);
				headerCellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
				headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				headerCellStyle.setBorderTop(BorderStyle.THIN);
				headerCellStyle.setBorderBottom(BorderStyle.THIN);
				headerCellStyle.setBorderLeft(BorderStyle.THIN);
				headerCellStyle.setBorderRight(BorderStyle.THIN);
				headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

				Row headerRow = sheet.createRow(0);

				// Tạo header	
				for (int i = 0; i < dtm.getColumnCount(); i++) {
					Cell cell = headerRow.createCell(i);
					cell.setCellValue(dtm.getColumnName(i));
					cell.setCellStyle(headerCellStyle);
				}

				Font contentFont = workbook.createFont();
				contentFont.setBold(false);
				contentFont.setFontHeightInPoints((short) 13);
				contentFont.setColor(IndexedColors.BLACK.getIndex());
				CellStyle contentCellStyle = workbook.createCellStyle();
				contentCellStyle.setFont(contentFont);
				contentCellStyle.setBorderTop(BorderStyle.THIN);
				contentCellStyle.setBorderBottom(BorderStyle.THIN);
				contentCellStyle.setBorderLeft(BorderStyle.THIN);
				contentCellStyle.setBorderRight(BorderStyle.THIN);

				for (int i = 0; i < dtm.getRowCount(); i++) {
					Row row = sheet.createRow(i + 1);
					for (int j = 0; j < dtm.getColumnCount(); j++) {
						Cell cell = row.createCell(j);
						cell.setCellValue(dtm.getValueAt(i, j) + "");
						cell.setCellStyle(contentCellStyle);
						sheet.autoSizeColumn(j);
					}
				}

				// Ghi file
				FileOutputStream fileOut = new FileOutputStream(path);
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();

				JOptionPane.showMessageDialog(null, "Lưu File Thành Công");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lưu File Thất Bại");
		}
	}
}
