package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.LoaisachDTO;
import DTO.NhaCungCapDTO;

public class NhaCungCapDAL {
	public static int themloaisach(NhaCungCapDTO loai) {
		int i = -1;
		String sql = "insert into nhacungcap (TenNCC) values(?)";

		try {
			// System.out.println("Oloai");
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenNCC());
			// System.out.println(loai.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int sualoaisach(NhaCungCapDTO loai) {
		int i = -1;
		String sql = "update nhacungcap set TenNCC = ? where MaNCC = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenNCC());
			pstm.setInt(2, loai.getMaNCC());
			// System.out.println(loai.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoaloaisach(NhaCungCapDTO loai) {
		int i = -1;
		String sql = "delete from nhacungcap where mancc = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, loai.getMaNCC());
			// System.out.println(loai.getMaloai());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static ArrayList<NhaCungCapDTO> getdanhsachncc() {
		try {
			// String sql = "select * from loaisach";
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from nhacungcap");

			ArrayList<NhaCungCapDTO> dsl = new ArrayList<>();
			while (rs.next()) {
				System.out.println("Db connect");
				NhaCungCapDTO ncc = new NhaCungCapDTO();
				ncc.setMaNCC(rs.getInt(1));
				ncc.setTenNCC(rs.getString(2));
				System.out.println(ncc.getTenNCC());
				System.out.println(ncc.getMaNCC());
				dsl.add(ncc);

			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
