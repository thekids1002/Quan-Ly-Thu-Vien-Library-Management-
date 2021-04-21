package DTO;

import java.util.Date;

public class PhieuNhap {
	private int MaPhieuNhap;
	private int MaNhaCung;
	private int MaNhanVien; 
	private String NgayNhap;
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getMaNhaCung() {
		return MaNhaCung;
	}
	public void setMaNhaCung(int maNhaCung) {
		MaNhaCung = maNhaCung;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
	}
	@Override
	public String toString() {
		return "PhieuNhap [MaPhieuNhap=" + MaPhieuNhap + ", MaNhaCung=" + MaNhaCung + ", MaNhanVien=" + MaNhanVien
				+ ", NgayNhap=" + NgayNhap + "]";
	}
	public PhieuNhap(int maPhieuNhap, int maNhaCung, int maNhanVien, String ngayNhap) {
		super();
		MaPhieuNhap = maPhieuNhap;
		MaNhaCung = maNhaCung;
		MaNhanVien = maNhanVien;
		NgayNhap = ngayNhap;
	}
	public PhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
