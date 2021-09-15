package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhanVien;
import DTO.NhanVien;

public class NhanVienDAL {
	public static int themnhanvien(NhanVien loai) {
		int i = -1;
		String sql = "insert into nhanvien (tennv,namsinh,gioitinh,diachi,sdt,trangthai) values(?,?,?,?,?,?)";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenNV());
			pstm.setString(2, loai.getNamSinh());
			pstm.setString(3, loai.getGioiTinh());
			pstm.setString(4, loai.getDiaChi());
			pstm.setString(5, loai.getSdt());
			pstm.setInt(6, 1);
			i = pstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public static int suanhanvien(NhanVien loai) {
		int i = -1;
		String sql = "update nhanvien set tennv = ?, namsinh = ?, gioitinh = ?, diachi =?, sdt = ? where manv = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, loai.getTenNV());
			pstm.setString(2, loai.getNamSinh());
			pstm.setString(3, loai.getGioiTinh());
			pstm.setString(4, loai.getDiaChi());
			pstm.setString(5, loai.getSdt());
			// pstm.setString(6,loai.getNgayBatDau().getYear()
			// +"-"+loai.getNgayBatDau().getMonth() + "-"+loai.getNgayBatDau().getDay());
			pstm.setInt(6, loai.getMaNV());
			// System.out.println(loai.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoanv(NhanVien loai) {
		int i = -1;
	//	String sql = "delete from nhanvien where manv = ?";
		String sql = "update nhanvien set trangthai = 0 where manv = ?" ;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, loai.getMaNV());
			// System.out.println(loai.getMaloai());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static ArrayList<NhanVien> getdanhsachnv() {
		try {
			// String sql = "select * from nhanvien";
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from nhanvien where trangthai = 1");

			ArrayList<NhanVien> dsl = new ArrayList<>();
			while (rs.next()) {
				System.out.println("Db connect");
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getInt(1));
				nhanVien.setTenNV(rs.getString(2));
				nhanVien.setNamSinh(rs.getString(3));
				nhanVien.setGioiTinh(rs.getString(4));
				nhanVien.setSdt(rs.getString(6));
				// nhanVien.setNgayBatDau(rs.getDate(7));
				nhanVien.setLuong(0);
				nhanVien.setDiaChi(rs.getString(5));
				dsl.add(nhanVien);

			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public static NhanVien getnhanvien(int ma) {
		try {
			String sql = "select tennv from nhanvien where manv = ?";
			NhanVien nv = new NhanVien();
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				nv.setTenNV(rs.getString("tennv"));
			}

			return nv;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
}
