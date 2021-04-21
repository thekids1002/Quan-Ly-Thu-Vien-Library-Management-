package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.PhieuNhap;
import DTO.TacGiaDTO;

public class PhieuNhapDAL {
	public static ArrayList<PhieuNhap> getdanhsachphieunhap() {
		try {
			String sql = "select * from phieunhap";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<PhieuNhap> dsl = new ArrayList<PhieuNhap>();
			while (rs.next()) {

				PhieuNhap tg = new PhieuNhap();
				tg.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
				tg.setMaNhaCung(rs.getInt("MaNCC"));
				tg.setMaNhanVien(rs.getInt("MaNV"));
				tg.setNgayNhap(rs.getString("NgayNhap"));
				dsl.add(tg);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int ThemPN(PhieuNhap ke) {
		int i = -1;
		String sql = "insert into phieunhap (MaNCC,MaNV,NgayNhap) values(?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNhaCung());
			pstm.setInt(2, ke.getMaNhanVien());
			pstm.setString(3, ke.getNgayNhap());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int SuaPn(PhieuNhap ke) {
		int i = -1;
		String sql = "update phieunhap set mancc = ? , manv = ?, ngaynhap = ?  where MaPhieuNhap = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNhaCung());
			pstm.setInt(2, ke.getMaNhanVien());
			pstm.setString(3, ke.getNgayNhap());
			pstm.setInt(4, ke.getMaPhieuNhap());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoanxb(PhieuNhap ke) {
		int i = -1;
		String sql = "delete from phieunhap where maphieunhap = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuNhap());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}
}
