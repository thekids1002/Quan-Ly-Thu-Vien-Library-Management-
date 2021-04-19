package DTO;

public class ChiTietPhieuNhap {
	private int MaCTPN;
	private int MaPhieuNhap;
	private int MaSach;
	private int Gia;
	private int SoLuong;
	public int getMaCTPN() {
		return MaCTPN;
	}
	public void setMaCTPN(int maCTPN) {
		MaCTPN = maCTPN;
	}
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getMaSach() {
		return MaSach;
	}
	public void setMaSach(int maSach) {
		MaSach = maSach;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuNhap [MaCTPN=" + MaCTPN + ", MaPhieuNhap=" + MaPhieuNhap + ", MaSach=" + MaSach + ", Gia="
				+ Gia + ", SoLuong=" + SoLuong + "]";
	}
	public ChiTietPhieuNhap(int maCTPN, int maPhieuNhap, int maSach, int gia, int soLuong) {
		super();
		MaCTPN = maCTPN;
		MaPhieuNhap = maPhieuNhap;
		MaSach = maSach;
		Gia = gia;
		SoLuong = soLuong;
	}
	public ChiTietPhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
