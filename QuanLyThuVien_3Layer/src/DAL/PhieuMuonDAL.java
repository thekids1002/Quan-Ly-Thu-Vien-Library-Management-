package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhaXuatBan;
import DTO.PhieuMuon;

public class PhieuMuonDAL {
	public static ArrayList<PhieuMuon> getdanhsachphieumuon() {
		try {
			String sql = "select * from phieumuon";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<PhieuMuon> dsl = new ArrayList<PhieuMuon>();
			while (rs.next()) {

				PhieuMuon pm = new PhieuMuon();
				pm.setMaPhieuMuon(rs.getInt(1));
				pm.setMaNV(rs.getInt(2));
				pm.setMaDocGia(rs.getInt(3));
				pm.setNgayMuon(rs.getString(4));
				pm.setTinhtrang(rs.getString(5));
				System.out.println(pm);

			}

			return dsl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int thempm(PhieuMuon ke) {
		int i = -1;
		String sql = "insert into phieumuon (manv,MaDocGia,NgayMuon,TinhTrang) values(?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNV());
			pstm.setInt(2, ke.getMaDocGia());
			pstm.setString(3, ke.getNgayMuon());
			pstm.setString(4, ke.getTinhtrang());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suanxb(PhieuMuon ke) {
		int i = -1;
		String sql = "update phieumuon set manv = ? , MaDocGia = ?, NgayMuon = , TinhTrang =?  where mapm = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNV());
			pstm.setInt(2, ke.getMaDocGia());
			pstm.setString(3, ke.getNgayMuon());
			pstm.setString(4, ke.getTinhtrang());
			pstm.setInt(5, ke.getMaPhieuMuon());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoanxb(PhieuMuon ke) {
		int i = -1;
		String sql = "delete from phieumuon where mapm = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuMuon());
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
