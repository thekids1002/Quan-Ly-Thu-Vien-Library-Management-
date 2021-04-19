package DTO;

import java.util.Date;

public class PhieuMuon {
	private int MaPhieuMuon ;
	private int MaNV;
	private int MaDocGia;
	private String NgayMuon;
	private String tinhtrang;
	public int getMaPhieuMuon() {
		return MaPhieuMuon;
	}
	public void setMaPhieuMuon(int maPhieuMuon) {
		MaPhieuMuon = maPhieuMuon;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public int getMaDocGia() {
		return MaDocGia;
	}
	public void setMaDocGia(int maDocGia) {
		MaDocGia = maDocGia;
	}
	public String getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(String ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public PhieuMuon(int maPhieuMuon, int maNV, int maDocGia, String ngayMuon, String tinhtrang) {
		super();
		MaPhieuMuon = maPhieuMuon;
		MaNV = maNV;
		MaDocGia = maDocGia;
		NgayMuon = ngayMuon;
		this.tinhtrang = tinhtrang;
	}
	public PhieuMuon() {
		super();
		// TODO Auto-generated constructor stub

	}
	@Override
	public String toString() {
		return "PhieuMuon [MaPhieuMuon=" + MaPhieuMuon + ", MaNV=" + MaNV + ", MaDocGia=" + MaDocGia + ", NgayMuon="
				+ NgayMuon + ", tinhtrang=" + tinhtrang + "]";
	}
	
}
