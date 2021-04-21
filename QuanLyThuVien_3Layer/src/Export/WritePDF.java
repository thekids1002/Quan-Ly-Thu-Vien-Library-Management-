package Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class WritePDF {
	
	public void xuatPDF(JTable table)
	{	TableModel dtm = table.getModel();
		String path ="" ;
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int x = j.showSaveDialog(j);
		if(x == JFileChooser.APPROVE_OPTION) {
			path = j.getSelectedFile().getPath();
			
		}
		Document doc =  new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(path+".pdf"));
			doc.open();
			PdfPTable tbl = new PdfPTable(table.getColumnCount());
			
			for (int i = 0; i < dtm.getColumnCount(); i++) {
				tbl.addCell(dtm.getColumnName(i) +"");
				
			}
			for( int i = 0 ; i < dtm.getRowCount() ; i++) {
				for(int j1 = 0 ; j1 < dtm.getColumnCount() ; j1++) {
					tbl.addCell(dtm.getValueAt(i, j1).toString());
					
				}
			}
			
			doc.add(tbl);
			JOptionPane.showMessageDialog(null, "Tạo pdf Thành Công");
			doc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
