package DTO;

public class NhaXuatBan {
	private int MaNXB;
	
	private String TenNXB;
	private String DiaChi;
	private String Sdt;
	public int getMaNXB() {
		return MaNXB;
	}
	public void setMaNXB(int maNXB) {
		MaNXB = maNXB;
	}
	public String getTenNXB() {
		return TenNXB;
	}
	public void setTenNXB(String tenNXB) {
		TenNXB = tenNXB;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public NhaXuatBan(int maNXB, String tenNXB, String diaChi, String sdt) {
		super();
		MaNXB = maNXB;
		TenNXB = tenNXB;
		DiaChi = diaChi;
		Sdt = sdt;
	}
	public NhaXuatBan() {
		super();
		// TODO Auto-generated constructor stub
	} 
	@Override
	public String toString() {
		return this.MaNXB + "-"+ this.TenNXB  ;
	}
}
