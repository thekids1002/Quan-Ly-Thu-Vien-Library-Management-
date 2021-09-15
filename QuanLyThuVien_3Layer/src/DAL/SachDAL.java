package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DocGia;
import DTO.LoaisachDTO;
import DTO.PhieuNhap;
import DTO.SachDTO;

public class SachDAL {
	public static ArrayList<SachDTO> getdanhsachLoai() {
		try {

			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sach where trangthai =1");

			ArrayList<SachDTO> ds = new ArrayList<>();
			while (rs.next()) {
				System.out.println("Db connect");
				SachDTO ls = new SachDTO();
				ls.setMasosach(rs.getInt(1));
				ls.setTensach(rs.getString(2));
				ls.setMatacgia(rs.getInt(3));
				ls.setMaNXB(rs.getInt(4));
				ls.setMaloai(rs.getInt(5));
				ls.setNamxb(rs.getInt(6));
				ls.setSoluong(rs.getInt(7));
				ls.setGhichu(rs.getString("trangthai"));
				ls.setHinhanh(rs.getString("HinhAnh"));
				ls.setMake(rs.getInt("Make"));

				ds.add(ls);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}

	}

	public static int themsach(SachDTO sach) {
		int i = -1;
		String sql = "insert into sach (tensach,MaLoai,MaNXB,MaTacGia,NamXB,SoLuong,MaKe,HinhAnh,TrangThai) values(?,?,?,?,?,?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, sach.getTensach());
			pstm.setInt(2, sach.getMaloai());
			pstm.setInt(3, sach.getMaNXB());
			pstm.setInt(4, sach.getMatacgia());
			pstm.setInt(5, sach.getNamxb());
			pstm.setInt(6, sach.getSoluong());
			pstm.setString(7, String.valueOf(sach.getMake()));
			pstm.setString(8, sach.getHinhanh());
			pstm.setInt(9, 1);

			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suasach(SachDTO sach) {
		int i = -1;
		String sql = "update sach set tensach = ? , MaLoai = ?, MaNXB = ?, MaTacGia =? , NamXB =? ,SoLuong  =? ,MaKe  =? , HinhAnh =? where Masach = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, sach.getTensach());
			pstm.setInt(2, sach.getMaloai());
			pstm.setInt(3, sach.getMaNXB());
			pstm.setInt(4, sach.getMatacgia());
			pstm.setInt(5, sach.getNamxb());
			pstm.setInt(6, sach.getSoluong());
			pstm.setString(7, String.valueOf(sach.getMake()));
			pstm.setString(8, sach.getHinhanh());
			pstm.setInt(9, sach.getMasosach());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoasach(SachDTO ke) {
		int i = -1;
	//	String sql = "delete from sach where Masach = ?";
		String sql = "update sach set TrangThai = 0  where masach = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMasosach());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int getsoluongsach(int masach) {
		try {
			int soluong = 0;
			Connection conn = DBConnect.getConnection();
			String sql = "select soluong from sach where masach = ? and trangthai = 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, masach);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				soluong = rs.getInt("SoLuong");
			}
			return soluong;
		} catch (Exception e) {
			return -1;
		}

	}

	public SachDTO timsach(int ma) {
		SachDTO sach = new SachDTO();
		String sql = "select * from sach where masach = ? and trangthai =1";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sach.setMasosach(rs.getInt("Masach"));
				sach.setTensach(rs.getString("Tensach"));
				sach.setMaloai(rs.getInt("Maloai"));
				sach.setMaNXB(rs.getInt("Manxb"));
				sach.setMatacgia(rs.getInt("Matacgia"));
				sach.setNamxb(rs.getInt("Namxb"));
				sach.setSoluong(rs.getInt("soluong"));
				sach.setMake(rs.getInt("Make"));
				sach.setHinhanh(rs.getString("hinhanh"));
				sach.setGhichu(rs.getString("trangthai"));
			}
			return sach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static int getsoluongallsach() {
		try {
			int soluong = 0;
			Connection conn = DBConnect.getConnection();
			String sql = "select soluong from sach where trangthai = 1";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				soluong += rs.getInt("soluong");
			}
			conn.close();
			return soluong;
		} catch (Exception e) {
			return -1;
		}
	}

}
