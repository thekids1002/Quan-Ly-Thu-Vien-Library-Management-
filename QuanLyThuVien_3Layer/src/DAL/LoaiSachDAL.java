package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import DTO.LoaisachDTO;

public class LoaiSachDAL {

	public static ArrayList<LoaisachDTO> getdanhsachLoai() {
		try {
			// String sql = "select * from loaisach";
			// Trang Thai 0 la hiden 
			// 1 la show
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from loai where trangthai = 1");

			ArrayList<LoaisachDTO> dsl = new ArrayList<>();
			while (rs.next()) {
				System.out.println("Db connect");
				LoaisachDTO ls = new LoaisachDTO();
				ls.setMaloai(rs.getInt(1));
				ls.setTenloai(rs.getString(2));
				//ls.setMaloai(rs.getInt(3));
				dsl.add(ls);
			}
			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public static int themloaisach(LoaisachDTO loai) {
		int i = -1;
		String sql = "insert into loai (TenLoai,TrangThai) values(?,?)";

		try {
			// System.out.println("Oloai");
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenloai());
			pstm.setInt(2, 1);
			// System.out.println(loai.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int sualoaisach(LoaisachDTO loai) {
		int i = -1;
		String sql = "update loai set tenloai = ? where maloai = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenloai());
			pstm.setInt(2, loai.getMaloai());
			// System.out.println(loai.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoaloaisach(LoaisachDTO loai) {
		int i = -1;
		//String sql = "delete from loai where maloai = ?";
		String sql = "update loai set TrangThai = ? where maloai = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 0); // hidden
			pstm.setInt(2, loai.getMaloai());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

}
