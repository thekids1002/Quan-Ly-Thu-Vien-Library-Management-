package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTieuPMDTO;

public class chitietpmDAL {
	public static ArrayList<ChiTieuPMDTO> getdanhsachphieumuon() {
		try {
			String sql = "select * from chitietphieumuon";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<ChiTieuPMDTO> dsl = new ArrayList<ChiTieuPMDTO>();
			while (rs.next()) {
				ChiTieuPMDTO ctpm = new ChiTieuPMDTO();
				ctpm.setMaChiTietPhieuMuon(rs.getInt("MaCTPM"));
				ctpm.setMaPhieuMuon(rs.getInt("MaPM"));
				ctpm.setMaSach(rs.getInt("MaSach"));
				ctpm.setNgayTra(rs.getString("NgayTra"));
				ctpm.setGhichu(rs.getString("GhiChu"));
				dsl.add(ctpm);

			}

			return dsl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themctpm(ChiTieuPMDTO ke) {
		int i = -1;
		String sql = "insert into phieumuon (MaPM,MaSach,NgayTra,GhiChu) values(?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuMuon());
			pstm.setInt(2, ke.getMaSach());
			pstm.setString(3, ke.getNgayTra());
			pstm.setString(4, ke.getGhichu());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suactpm(ChiTieuPMDTO ke) {
		int i = -1;
		String sql = "update phieumuon set MaPM = ? , MaSach = ?, NgayTra =? , GhiChu =?  where mactpm = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuMuon());
			pstm.setInt(2, ke.getMaSach());
			pstm.setString(3, ke.getNgayTra());
			pstm.setString(4, ke.getGhichu());
			pstm.setInt(5, ke.getMaChiTietPhieuMuon());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoactpm(ChiTieuPMDTO ke) {
		int i = -1;
		String sql = "delete from chitietphieumuon where mactpm = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaChiTietPhieuMuon());
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
