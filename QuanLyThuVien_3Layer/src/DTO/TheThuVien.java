package DTO;

public class TheThuVien {
	private int MaTheThuVien;
	private String NgayBatDau;
	private String NgayKetThuc;
	private String GhiChu;
	private int madocgia;
	private String tendocgia;

	public int getMaTheThuVien() {
		return MaTheThuVien;
	}

	public void setMaTheThuVien(int maTheThuVien) {
		MaTheThuVien = maTheThuVien;
	}

	public String getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public int getMadocgia() {
		return madocgia;
	}

	public void setMadocgia(int madocgia) {
		this.madocgia = madocgia;
	}

	public String getTendocgia() {
		return tendocgia;
	}

	public void setTendocgia(String tendocgia) {
		this.tendocgia = tendocgia;
	}

	public TheThuVien(int maTheThuVien, int madocgia, String tendocgia, String ngayBatDau, String ngayKetThuc) {
		super();
		MaTheThuVien = maTheThuVien;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;

		this.madocgia = madocgia;
		this.tendocgia = tendocgia;
	}

	public TheThuVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TheThuVien(int maTheThuVien, String ngayBatDau, String ngayKetThuc, String ghiChu) {
		super();
		MaTheThuVien = maTheThuVien;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		GhiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "TheThuVien [MaTheThuVien=" + MaTheThuVien + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc="
				+ NgayKetThuc + ", GhiChu=" + GhiChu + ", madocgia=" + madocgia + ", tendocgia=" + tendocgia + "]";
	}

}
