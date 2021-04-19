package DTO;

import java.util.Date;

public class PhieuMuon {
	private int MaPhieuMuon ;
	private int MaNV;
	private int MaDocGia;
	private Date NgayMuon;
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
	public PhieuMuon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuMuon(int maPhieuMuon, int maNV, int maDocGia, Date ngayMuon, String tinhtrang) {
		super();
		MaPhieuMuon = maPhieuMuon;
		MaNV = maNV;
		MaDocGia = maDocGia;
		NgayMuon = ngayMuon;
		this.tinhtrang = tinhtrang;
	}
	@Override
	public String toString() {
		return "PhieuMuon [MaPhieuMuon=" + MaPhieuMuon + ", MaNV=" + MaNV + ", MaDocGia=" + MaDocGia + ", NgayMuon="
				+ NgayMuon + ", tinhtrang=" + tinhtrang + "]";
	}
	public Date getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
}
