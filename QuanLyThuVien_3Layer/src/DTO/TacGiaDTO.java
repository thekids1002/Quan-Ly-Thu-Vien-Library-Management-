package DTO;

public class TacGiaDTO {
	private int MaTacGia;
	private String TenTacGia;
	private String NamSinh;
	private String QueQuan;
	public int getMaTacGia() {
		return MaTacGia;
	}
	public void setMaTacGia(int maTacGia) {
		MaTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return TenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	public TacGiaDTO(int maTacGia, String tenTacGia, String namSinh, String queQuan) {
		super();
		MaTacGia = maTacGia;
		TenTacGia = tenTacGia;
		NamSinh = namSinh;
		QueQuan = queQuan;
	}
	public TacGiaDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(String namSinh) {
		NamSinh = namSinh;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}
	@Override
	public String toString() {
		return MaTacGia + "-" + TenTacGia ;
	}
	
}
