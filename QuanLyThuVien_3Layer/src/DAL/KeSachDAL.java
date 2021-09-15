package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KeSachDTO;
import DTO.NhaCungCapDTO;

public class KeSachDAL {

	public static ArrayList<KeSachDTO> getdanhsachke() {
		try {
			String sql = "select * from kesach where trangthai = 1 ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			ArrayList<KeSachDTO> dsl = new ArrayList<>();
			while (rs.next()) {
				KeSachDTO ke = new KeSachDTO();
				ke.setMaKeSach(rs.getInt(1));
				ke.setViTri(rs.getString(2));
				dsl.add(ke);

			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themkesach(KeSachDTO ke) {
		int i = -1;
		String sql = "insert into kesach (ViTri,TrangThai) values(?,?)";

		try {
			System.out.println("Oke");
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getViTri());
			pstm.setInt(2, 1);
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suakesach(KeSachDTO ke) {
		int i = -1;
		String sql = "update kesach set vitri = ? where make = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getViTri());
			pstm.setInt(2, ke.getMaKeSach());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoakesach(KeSachDTO ke) {
		int i = -1;
		// String sql = "delete from kesach where make = ?";
		String sql = "update kesach set TrangThai = ? where make = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 0);
			pstm.setInt(2, ke.getMaKeSach());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

}
