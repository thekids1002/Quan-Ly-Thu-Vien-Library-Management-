package Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
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
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import BUS.PhieuNhapBUS;
import DAL.NhaCungCapDAL;
import DAL.NhanVienDAL;
import DAL.PhieuNhapDAL;
import DTO.NhaCungCapDTO;
import DTO.NhanVien;
import DTO.PhieuNhap;

public class WritePDF {
	Font fontData;
	Font fontData2;

	public WritePDF() {
		super();
		try {
			fontData = new Font(
					BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11,
					Font.NORMAL);
			fontData2 = new Font(
					BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 18,
					Font.BOLD);
			fontData2.setColor(255, 33, 11);
		} catch (DocumentException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	public void xuatPDFPhieuNhap(JTable table, int ma) {

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

			Paragraph pdfTitle = new Paragraph(new Phrase("THÔNG TIN PHIẾU NHẬP", fontData2));
			// set title
			pdfTitle.setAlignment(Element.ALIGN_CENTER);
			// căn giữa
			doc.add(pdfTitle);
			doc.add(Chunk.NEWLINE);
			// xuống dòng
			PhieuNhap pn = PhieuNhapDAL.getphieunhap(ma);
			System.out.println(pn);
			Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang

			Paragraph paraMaHoaDon = new Paragraph(
					new Phrase("Phiếu Nhập: " + String.valueOf(pn.getMaPhieuNhap()), fontData));
			doc.add(paraMaHoaDon);
			doc.add(Chunk.NEWLINE);

			NhaCungCapDTO ncc = NhaCungCapDAL.getNhacungcap(pn.getMaNhaCung());
			// viết 1 hàm getnhacungcap để lấy tên nhà cung cấp
			NhanVien nv = NhanVienDAL.getnhanvien(pn.getMaNhanVien());
			// tương tự với nhân viên
			Paragraph para1 = new Paragraph();
			para1.setFont(fontData);
			para1.add(String.valueOf("Nhà Cung Cấp : " + ncc.getTenNCC()));
			para1.add(glue);
			doc.add(para1);
			doc.add(Chunk.NEWLINE);

			Paragraph para2 = new Paragraph();
			para2.setFont(fontData);

			para2.add(String.valueOf("Tên Nhân Viên : " + nv.getTenNV()));
			para2.add(glue);
			doc.add(para2);
			doc.add(Chunk.NEWLINE);

			Paragraph para3 = new Paragraph();
			para3.setFont(fontData);
			para3.add(String.valueOf("Ngày Nhập : " + pn.getNgayNhap()));
			para3.add(glue);
			doc.add(para3);
			doc.add(Chunk.NEWLINE);

			// Xuất table
			PdfPTable tbl = new PdfPTable(table.getColumnCount());
			for (int i = 0; i < dtm.getColumnCount(); i++) {
				String data = String.valueOf(dtm.getColumnName(i) + "");
				PdfPCell cell = new PdfPCell(new Phrase(data, fontData));

				tbl.addCell(cell);

			}
			float tong = 0;
			for (int i = 0; i < dtm.getRowCount(); i++) {
				for (int j1 = 0; j1 < dtm.getColumnCount(); j1++) {

					PdfPCell cell = new PdfPCell(new Phrase(dtm.getValueAt(i, j1).toString(), fontData));
					tbl.addCell(cell);

				}
				tong += Integer.parseInt(dtm.getValueAt(i, 5).toString());
			}
			// format lại tiền nhìn cho đẹp
			String pattern = "###,###.###";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String tongtong = decimalFormat.format(tong);
			doc.add(tbl);
			doc.add(Chunk.NEWLINE);
			Paragraph pdf2 = new Paragraph(new Phrase("Tổng Tiền: " + tongtong + " VNĐ", fontData));
			// set title
			pdf2.setAlignment(Element.ALIGN_RIGHT);
			// căn giữa
			doc.add(pdf2);
			doc.add(Chunk.NEWLINE);
			// Xác nhận
			Paragraph pdf = new Paragraph(new Phrase("Xác Nhận Hoá Đơn", fontData));
			// set title
			pdf.setAlignment(Element.ALIGN_RIGHT);
			// căn giữa
			doc.add(pdf);
			doc.add(Chunk.NEWLINE);
			JOptionPane.showMessageDialog(null, "Tạo pdf Thành Công");
			doc.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tạo pdf Thất Bại");
			e.printStackTrace();
		}

	}

	public void xuatPDF(JTable table) {

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
			/*
			 * Paragraph paragraph = new Paragraph(); paragraph.add("Võ Hoàng Kiệt");
			 * doc.add(paragraph);
			 */

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
