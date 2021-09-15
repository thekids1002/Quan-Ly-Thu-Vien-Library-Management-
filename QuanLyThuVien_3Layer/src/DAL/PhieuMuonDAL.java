package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTieuPMDTO;
import DTO.NhaXuatBan;
import DTO.PhieuMuon;

public class PhieuMuonDAL {
	public static ArrayList<PhieuMuon> getdanhsachphieumuon() {
		try {
			String sql = "select * from phieumuon where trangthai = 1";
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
				dsl.add(pm);

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
		String sql = "insert into phieumuon (manv,MaDocGia,NgayMuon,TinhTrang,Trangthai) values(?,?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNV());
			pstm.setInt(2, ke.getMaDocGia());
			pstm.setString(3, ke.getNgayMuon());
			pstm.setString(4, ke.getTinhtrang());
			pstm.setInt(5, 1);
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static ArrayList<ChiTieuPMDTO> listctpm(int ke) {
		try {
			Connection conn = DBConnect.getConnection();
			String sql2 = "SELECT * FROM `chitietphieumuon` WHERE mapm = ?";
			ArrayList<ChiTieuPMDTO> list = new ArrayList<ChiTieuPMDTO>();
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, ke);
			ResultSet rs = pstm2.executeQuery();

			while (rs.next()) {
				ChiTieuPMDTO pm = new ChiTieuPMDTO();
				pm.setMaChiTietPhieuMuon(rs.getInt(1));
				pm.setMaPhieuMuon(rs.getInt(2));
				pm.setMaSach(rs.getInt(3));
				list.add(pm);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int suapm(PhieuMuon ke) {
		int i = -1;
		String sql = "update phieumuon set manv = ? , MaDocGia = ?, NgayMuon =? , TinhTrang =?  where mapm = ?";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNV());
			pstm.setInt(2, ke.getMaDocGia());
			pstm.setString(3, ke.getNgayMuon());
			pstm.setString(4, ke.getTinhtrang());
			pstm.setInt(5, ke.getMaPhieuMuon());
			if (ke.getTinhtrang().contains("Đã Trả")) {
				ArrayList<ChiTieuPMDTO> list = listctpm(ke.getMaPhieuMuon());
				if (list != null) {
					for (ChiTieuPMDTO ctpm : list) {
						String sql2 = "update sach set soluong = ? where masach = ?";
						PreparedStatement stm2 = conn.prepareStatement(sql2);
						stm2.setInt(1, SachDAL.getsoluongsach(ctpm.getMaSach()) + 1);
						stm2.setInt(2, ctpm.getMaSach());
						stm2.executeUpdate();
						System.out.println("Phiếu mượn DAL : Update số lượng thành công");
					}
				}
			}
//			if (ke.getTinhtrang().contains("Mượn")) {
//				ArrayList<ChiTieuPMDTO> list = listctpm(ke.getMaPhieuMuon());
//				if (list != null) {
//					for (ChiTieuPMDTO ctpm : list) {
//						String sql2 = "update sach set soluong = ? where masach = ?";
//						PreparedStatement stm2 = conn.prepareStatement(sql2);
//						stm2.setInt(1, SachDAL.getsoluongsach(ctpm.getMaSach()) - 1);
//						stm2.setInt(2, ctpm.getMaSach());
//						stm2.executeUpdate();
//						System.out.println("Phiếu mượn DAL1 : Update số lượng thành công");
//					}
//				}
//			}
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoapm(PhieuMuon ke) {
		int i = -1;
		// String sql = "delete from phieumuon where mapm = ?";
		String sql = "update phieumuon set TrangThai = 0 where mapm = ?";
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

	public PhieuMuon timphieumuon(int ma) {
		String sql = "select * from phieumuon where mapm = ? and trangthai = 1";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma);
			PhieuMuon pm = new PhieuMuon();
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				pm.setMaPhieuMuon(rs.getInt(1));
				pm.setMaNV(rs.getInt(2));
				pm.setMaDocGia(rs.getInt(3));
				pm.setNgayMuon(rs.getString(4));
				pm.setTinhtrang(rs.getString(5));
			}
			conn.close();
			return pm;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
