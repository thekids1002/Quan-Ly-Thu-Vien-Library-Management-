package DTO;

public class DocGia {
	private int MaDocGia;
	private String TenDocGia;
	private String GioiTinh ;
	private String diachi;
	private String sdt;
	public int getMaDocGia() {
		return MaDocGia;
	}
	public void setMaDocGia(int maDocGia) {
		MaDocGia = maDocGia;
	}
	public String getTenDocGia() {
		return TenDocGia;
	}
	public void setTenDocGia(String tenDocGia) {
		TenDocGia = tenDocGia;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public DocGia(int maDocGia, String tenDocGia, String gioiTinh, String diachi, String sdt) {
		super();
		MaDocGia = maDocGia;
		TenDocGia = tenDocGia;
		GioiTinh = gioiTinh;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public DocGia() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return MaDocGia + "-" +TenDocGia; 
	} 
	
	
}
