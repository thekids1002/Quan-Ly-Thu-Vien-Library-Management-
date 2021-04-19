package DTO;

import java.util.Date;

public class TheThuVien {
	private int MaTheThuVien; 
	private Date NgayBatDau ;
	private Date NgayKetThuc ;
	private String GhiChu;
	public int getMaTheThuVien() {
		return MaTheThuVien;
	}
	public void setMaTheThuVien(int maTheThuVien) {
		MaTheThuVien = maTheThuVien;
	}
	public Date getNgayBatDau() {
		return NgayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public TheThuVien(int maTheThuVien, Date ngayBatDau, Date ngayKetThuc, String ghiChu) {
		super();
		MaTheThuVien = maTheThuVien;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		GhiChu = ghiChu;
	}
	public TheThuVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TheThuVien [MaTheThuVien=" + MaTheThuVien + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc="
				+ NgayKetThuc + ", GhiChu=" + GhiChu + "]";
	} 
	
}
