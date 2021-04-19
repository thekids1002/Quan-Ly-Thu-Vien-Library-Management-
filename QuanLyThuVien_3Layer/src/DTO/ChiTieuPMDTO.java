package DTO;

import java.util.Date;

public class ChiTieuPMDTO {
	private int MaChiTietPhieuMuon;
	private int MaPhieuMuon;
	private int MaSach;
	private String NgayTra;
	private String ghichu;
	public int getMaChiTietPhieuMuon() {
		return MaChiTietPhieuMuon;
	}
	public void setMaChiTietPhieuMuon(int maChiTietPhieuMuon) {
		MaChiTietPhieuMuon = maChiTietPhieuMuon;
	}
	public int getMaPhieuMuon() {
		return MaPhieuMuon;
	}
	public void setMaPhieuMuon(int maPhieuMuon) {
		MaPhieuMuon = maPhieuMuon;
	}
	public int getMaSach() {
		return MaSach;
	}
	public void setMaSach(int maSach) {
		MaSach = maSach;
	}
	public String getNgayTra() {
		return NgayTra;
	}
	public void setNgayTra(String ngayTra) {
		NgayTra = ngayTra;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public ChiTieuPMDTO(int maChiTietPhieuMuon, int maPhieuMuon, int maSach, String ngayTra, String ghichu) {
		super();
		MaChiTietPhieuMuon = maChiTietPhieuMuon;
		MaPhieuMuon = maPhieuMuon;
		MaSach = maSach;
		NgayTra = ngayTra;
		this.ghichu = ghichu;
	}
	public ChiTieuPMDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTieuPMDTO [MaChiTietPhieuMuon=" + MaChiTietPhieuMuon + ", MaPhieuMuon=" + MaPhieuMuon + ", MaSach="
				+ MaSach + ", NgayTra=" + NgayTra + ", ghichu=" + ghichu + "]";
	}

	
}
