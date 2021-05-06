package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhap;
import DTO.PhieuNhap;

public class ChiTietPhieuNhapDAL {
	public static ArrayList<ChiTietPhieuNhap> getdanhsachctphieunhap() {
		try {
			String sql = "select * from chitietphieunhap";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<ChiTietPhieuNhap> dsl = new ArrayList<ChiTietPhieuNhap>();
			while (rs.next()) {

				ChiTietPhieuNhap tg = new ChiTietPhieuNhap();
				tg.setMaCTPN(rs.getInt("MaCTPN"));
				tg.setMaPhieuNhap(rs.getInt("MaPN"));
				tg.setMaSach(rs.getInt("MaSach"));
				tg.setGia(rs.getInt("Gia"));
				tg.setSoLuong(rs.getInt("Soluong"));
				tg.setThanhTien(rs.getInt("ThanhTien"));
				dsl.add(tg);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int Themctpn(ChiTietPhieuNhap ke) {
		int i = -1;
		String sql = "insert into chitietphieunhap (MaPN,MaSach,Gia,SoLuong,ThanhTien) values(?,?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuNhap());
			pstm.setInt(2, ke.getMaSach());
			pstm.setInt(3, ke.getGia());
			pstm.setInt(4, ke.getSoLuong());
			pstm.setInt(5, ke.getThanhTien());

			i = pstm.executeUpdate();
			if (i > 0) {
				String sql2 = "update sach set soluong  = ? where masach = ?";
				PreparedStatement stm2 = conn.prepareStatement(sql2);
				stm2.setInt(1, SachDAL.getsoluongsach(ke.getMaSach()) + ke.getSoLuong());
				stm2.setInt(2, ke.getMaSach());
				stm2.executeUpdate();
				System.out.println("Cập nhật số lượng sách sau khi nhập thành công");
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int Suactpn(ChiTietPhieuNhap ke) {
		int i = -1;
		String sql = "update chitietphieunhap set MaPN = ? , MaSach = ?, Gia = ?  ,SoLuong = ? , ThanhTien=?  where MaCTPN = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuNhap());
			pstm.setInt(2, ke.getMaSach());
			pstm.setInt(3, ke.getGia());
			pstm.setInt(4, ke.getSoLuong());
			pstm.setInt(5, ke.getThanhTien());
			pstm.setInt(6, ke.getMaCTPN());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoactpn(ChiTietPhieuNhap ke) {
		int i = -1;
		String sql = "delete from chitietphieunhap where MaCTPN = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaCTPN());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static ArrayList<ChiTietPhieuNhap> getthongke() {
		ArrayList<ChiTietPhieuNhap> list = new ArrayList<ChiTietPhieuNhap>();
		try {
			String sql = "SELECT chitietphieunhap.*, phieunhap.NgayNhap, sach.TenSach FROM chitietphieunhap INNER JOIN phieunhap ON chitietphieunhap.MaPN = phieunhap.MaPhieuNhap INNER JOIN sach ON chitietphieunhap.MaSach = sach.MaSach";
			Connection conn = DBConnect.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
				ct.setMaCTPN(rs.getInt("MaCTPN"));
				ct.setMaPhieuNhap(rs.getInt("MaPN"));
				ct.setMaSach(rs.getInt("MaSach"));
				ct.setGia(rs.getInt("Gia"));
				ct.setSoLuong(rs.getInt("Soluong"));
				ct.setThanhTien(rs.getInt("ThanhTien"));
				ct.setTensach(rs.getString("Tensach"));
				ct.setNgaynhap(rs.getString("Ngaynhap"));
				list.add(ct);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}

	}

	public static ArrayList<ChiTietPhieuNhap> getthongketheonam(int nam) {
		ArrayList<ChiTietPhieuNhap> list = new ArrayList<ChiTietPhieuNhap>();
		try {
			String sql = "SELECT chitietphieunhap.*, phieunhap.NgayNhap, sach.TenSach FROM chitietphieunhap INNER JOIN phieunhap ON chitietphieunhap.MaPN = phieunhap.MaPhieuNhap INNER JOIN sach ON chitietphieunhap.MaSach = sach.MaSach WHERE phieunhap.NgayNhap BETWEEN '"
					+ nam + "-01-01' AND '" + nam + "-12-31'";
			Connection conn = DBConnect.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
				ct.setMaCTPN(rs.getInt("MaCTPN"));
				ct.setMaPhieuNhap(rs.getInt("MaPN"));
				ct.setMaSach(rs.getInt("MaSach"));
				ct.setGia(rs.getInt("Gia"));
				ct.setSoLuong(rs.getInt("Soluong"));
				ct.setThanhTien(rs.getInt("ThanhTien"));
				ct.setTensach(rs.getString("Tensach"));
				ct.setNgaynhap(rs.getString("Ngaynhap"));
				list.add(ct);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}

	}

	public static ArrayList<ChiTietPhieuNhap> getthongketheongay(String date1, String date2) {
		ArrayList<ChiTietPhieuNhap> list = new ArrayList<ChiTietPhieuNhap>();
		try {
			String sql = "SELECT chitietphieunhap.*, phieunhap.NgayNhap, sach.TenSach FROM chitietphieunhap INNER JOIN phieunhap ON chitietphieunhap.MaPN = phieunhap.MaPhieuNhap INNER JOIN sach ON chitietphieunhap.MaSach = sach.MaSach WHERE phieunhap.NgayNhap BETWEEN '"
					+ date1 + "' AND '" + date2 + "'";
			Connection conn = DBConnect.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
				ct.setMaCTPN(rs.getInt("MaCTPN"));
				ct.setMaPhieuNhap(rs.getInt("MaPN"));
				ct.setMaSach(rs.getInt("MaSach"));
				ct.setGia(rs.getInt("Gia"));
				ct.setSoLuong(rs.getInt("Soluong"));
				ct.setThanhTien(rs.getInt("ThanhTien"));
				ct.setTensach(rs.getString("Tensach"));
				ct.setNgaynhap(rs.getString("Ngaynhap"));
				list.add(ct);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}

	}
}
