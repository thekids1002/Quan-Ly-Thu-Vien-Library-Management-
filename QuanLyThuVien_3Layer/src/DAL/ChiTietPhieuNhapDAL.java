package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
