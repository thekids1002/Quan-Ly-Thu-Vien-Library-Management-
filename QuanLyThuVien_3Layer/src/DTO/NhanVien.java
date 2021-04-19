package DTO;

import java.util.Date;

public class NhanVien {
	private int MaNV;
	private String TenNV;
	private String NamSinh;
	private String GioiTinh;
	private String Sdt;

	@Override
	public String toString() {
		return MaNV + "-" + TenNV ; 
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String sdt) {
		super();
		Sdt = sdt;
	}

	public int getMaNV() {
		return MaNV;
	}

	public void setMaNV(int maNV) {
		MaNV = maNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getNamSinh() {
		return NamSinh;
	}

	public void setNamSinh(String namSinh) {
		NamSinh = namSinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public Date getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public NhanVien(int maNV, String tenNV, String namSinh, String gioiTinh, String sdt,
			String diaChi) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		NamSinh = namSinh;
		GioiTinh = gioiTinh;
		Sdt = sdt;
		DiaChi = diaChi;
	}

	private Date NgayBatDau;
	private int luong;
	private String DiaChi;
}
