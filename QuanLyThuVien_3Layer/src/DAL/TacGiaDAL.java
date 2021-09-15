package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.TacGiaDTO;


public class TacGiaDAL {
	public static ArrayList<TacGiaDTO> getdanhsachtacgia() {
		try {
			String sql = "select * from tacgia where trangthai = 1 ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<TacGiaDTO> dsl = new ArrayList<TacGiaDTO>();
			while (rs.next()) {

				TacGiaDTO tg = new TacGiaDTO();
				tg.setMaTacGia(rs.getInt(1));
				tg.setTenTacGia(rs.getString("tentacgia"));
				tg.setQueQuan(rs.getString("quequan"));
				tg.setNamSinh(rs.getString("namsinh")) ; 
				dsl.add(tg);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themtacgia(TacGiaDTO ke) {
		int i = -1;
		String sql = "insert into tacgia (tentacgia,namsinh,quequan,trangthai) values(?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenTacGia());
			pstm.setString(2, ke.getNamSinh());
			pstm.setString(3, ke.getQueQuan());
			pstm.setInt(4, 1);
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suatacgia(TacGiaDTO ke) {
		int i = -1;
		String sql = "update tacgia set tentacgia = ? , namsinh = ?, quequan = ?  where matacgia = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenTacGia());
			pstm.setString(2, ke.getNamSinh());
			pstm.setString(3, ke.getQueQuan());
			pstm.setInt(4, ke.getMaTacGia());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoatacgia(TacGiaDTO ke) {
		int i = -1;
		//String sql = "delete from tacgia where matacgia = ?";
		String sql = "update tacgia set trangthai = 0 where matacgia = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaTacGia());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}
	
	public TacGiaDTO timtacgia(int ma) {
		
		String sql = "select * from tacgia where matacgia = ?";
		try {
			TacGiaDTO tg = new TacGiaDTO(); 
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery() ;
			if(rs.next()) {
				tg.setMaTacGia(rs.getInt(1));
				tg.setTenTacGia(rs.getString("tentacgia"));
				tg.setQueQuan(rs.getString("quequan"));
				tg.setNamSinh(rs.getString("namsinh")) ; 
			}
			return tg ;
		} catch (Exception e) {
			return null;
		}
	}

}
