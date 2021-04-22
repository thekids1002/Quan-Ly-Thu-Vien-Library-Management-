package Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class WritePDF {
	Font fontData;

	public void xuatPDF(JTable table) {
		try {
			fontData = new Font(
					BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11,
					Font.NORMAL);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String path = "";
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int x = j.showSaveDialog(j);
		if (x == JFileChooser.APPROVE_OPTION) {
			path = j.getSelectedFile().getPath();

		}

		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
			doc.open();
			PdfPTable tbl = new PdfPTable(table.getColumnCount());

			for (int i = 0; i < dtm.getColumnCount(); i++) {
				String data = String.valueOf(dtm.getColumnName(i) + "");
				PdfPCell cell = new PdfPCell(new Phrase(data, fontData));

				tbl.addCell(cell);

			}
			for (int i = 0; i < dtm.getRowCount(); i++) {
				for (int j1 = 0; j1 < dtm.getColumnCount(); j1++) {

					PdfPCell cell = new PdfPCell(new Phrase(dtm.getValueAt(i, j1).toString(), fontData));
					tbl.addCell(cell);

				}
			}

			doc.add(tbl);
			JOptionPane.showMessageDialog(null, "Tạo pdf Thành Công");
			doc.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tạo pdf Thất Bại");
			e.printStackTrace();
		}

	}
}
