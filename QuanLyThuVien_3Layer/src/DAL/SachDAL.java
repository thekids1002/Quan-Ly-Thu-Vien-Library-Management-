package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DocGia;
import DTO.LoaisachDTO;
import DTO.SachDTO;

public class SachDAL {
	public static ArrayList<SachDTO> getdanhsachLoai(){
		try {
			
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sach");
			
			
            ArrayList<SachDTO> ds = new ArrayList<>();
            while(rs.next()) {
            	System.out.println("Db connect");
            	SachDTO ls = new SachDTO();
            	ls.setMasosach(rs.getInt(1));
            	ls.setTensach(rs.getString(2));
            	ls.setMatacgia(rs.getInt(3));
            	ls.setMaNXB(rs.getInt(4));
            	ls.setMaloai(rs.getInt(5));
            	ls.setNamxb(rs.getInt(6));
            	ls.setSoluong(rs.getInt(7));
            	ls.setGhichu(rs.getString(8));
            	
            	
            	
            	ds.add(ls);
            }
            return ds;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
		
		
	}
	public static int themsach(SachDTO sach) {
		int i = -1;
		String sql = "insert into sach (tensach,MaLoai,MaNXB,MaTacGia,NamXB,SoLuong,MaKe,HinhAnh) values(?,?,?,?,?,?,?,?)";

		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, sach.getTensach());
			pstm.setInt(2, sach.getMaloai());
			pstm.setInt(3, sach.getMaNXB());
			pstm.setInt(4, sach.getMatacgia());
			pstm.setInt(5, sach.getMaNXB());
			pstm.setInt(6, sach.getSoluong());
			pstm.setString(7, String.valueOf(sach.getMake()));
			pstm.setString(8,sach.getHinhanh()); 
			
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

}
