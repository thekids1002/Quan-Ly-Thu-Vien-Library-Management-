package DTO;

public class Quyen {
	private int MaQuyen;
	private String TenQuyen;
	public int getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		MaQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return TenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		TenQuyen = tenQuyen;
	}
	public Quyen(int maQuyen, String tenQuyen) {
		super();
		MaQuyen = maQuyen;
		TenQuyen = tenQuyen;
	}
	public Quyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quyen [MaQuyen=" + MaQuyen + ", TenQuyen=" + TenQuyen + "]";
	}
	
}
