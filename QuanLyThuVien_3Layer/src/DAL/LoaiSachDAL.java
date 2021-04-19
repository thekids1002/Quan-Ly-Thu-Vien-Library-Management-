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
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from loai");

			ArrayList<LoaisachDTO> dsl = new ArrayList<>();
			while (rs.next()) {
				System.out.println("Db connect");
				LoaisachDTO ls = new LoaisachDTO();
				ls.setMaloai(rs.getInt(1));
				ls.setTenloai(rs.getString(2));
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
		String sql = "insert into loai (TenLoai) values(?)";

		try {
			// System.out.println("Oloai");
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenloai());
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
		String sql = "delete from loai where maloai = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, loai.getMaloai());
			System.out.println(loai.getMaloai());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

}
