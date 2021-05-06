package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.TacGiaDTO;
import DTO.TheThuVien;

public class TheThuVienDAL {
	public static ArrayList<TheThuVien> getdanhsachthethuvien() {
		try {
			String sql = "select * from thethuvien";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<TheThuVien> dsl = new ArrayList<TheThuVien>();
			while (rs.next()) {
				TheThuVien tv = new TheThuVien();
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setGhiChu(rs.getString(4));
				dsl.add(tv);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public static ArrayList<TheThuVien> getdanhsachthongtinthethuvien() {
		try {
			String sql = "SELECT thethuvien.MaTheThuVien,thethuvien.NgayBatDau,thethuvien.NgayKetThuc,docgia.tendocgia, docgia.madocgia FROM thethuvien INNER JOIN docgia ON docgia.madocgia = thethuvien.MaTheThuVien";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<TheThuVien> dsl = new ArrayList<TheThuVien>();
			while (rs.next()) {
				TheThuVien tv = new TheThuVien();
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setTendocgia(rs.getString("tendocgia"));
				tv.setMadocgia(rs.getInt("madocgia"));

				dsl.add(tv);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themthetv(TheThuVien ke) {
		int i = -1;
		String sql = "insert into thethuvien (NgayBatDau ,NgayKetThuc,GhiChu,MaTheThuVien) values(?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getNgayBatDau());
			pstm.setString(2, ke.getNgayKetThuc());
			pstm.setString(3, ke.getGhiChu());
			pstm.setInt(4, ke.getMaTheThuVien());

			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suanthethuvien(TheThuVien ke) {
		int i = -1;
		String sql = "update thethuvien set NgayBatDau = ? , NgayKetThuc = ?, GhiChu = ?  where MaTheThuVien = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getNgayBatDau());
			pstm.setString(2, ke.getNgayKetThuc());
			pstm.setString(3, ke.getGhiChu());
			pstm.setInt(4, ke.getMaTheThuVien());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoathethuvien(TheThuVien ke) {
		int i = -1;
		String sql = "delete from thethuvien where MaTheThuVien = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaTheThuVien());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public TheThuVien timthethuvien(int ma) {

		String sql = "select * from thethuvien where MaTheThuVien = ?";
		try {
			TheThuVien tv = new TheThuVien();
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setGhiChu(rs.getString(4));
			}
			return tv;
		} catch (Exception e) {
			return null;
		}
	}

	public static TheThuVien thongtinthe(int ma) {

		String sql = "SELECT thethuvien.MaTheThuVien,thethuvien.NgayBatDau,thethuvien.NgayKetThuc,docgia.tendocgia, docgia.madocgia FROM thethuvien INNER JOIN docgia ON docgia.madocgia = thethuvien.MaTheThuVien WHERE docgia.madocgia = ?";
		try {
			TheThuVien tv = new TheThuVien();
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setTendocgia(rs.getString("tendocgia"));
				tv.setMadocgia(rs.getInt("madocgia"));
			}
			return tv;
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean check(int mathe) {
		try {
			String sql = "SELECT thethuvien.MaTheThuVien,docgia.madocgia FROM thethuvien INNER JOIN docgia ON thethuvien.MaTheThuVien = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mathe);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static int giahanthe(int mathe, String ngay) {
		int i = -1;
		String sql = "update thethuvien set NgayKetThuc = ? where MaTheThuVien = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ngay);
			pstm.setInt(2, mathe);
			
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return i;
	}

}
