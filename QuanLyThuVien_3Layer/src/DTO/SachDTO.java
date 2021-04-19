package DTO;

public class SachDTO {
	private int Masosach;
	private String tensach;
	private int matacgia;
	private int maNXB;
	private int maloai;
	private int namxb;
	private int soluong;
	private String ghichu;
	private String hinhanh;
	private int Make;
	public int getMasosach() {
		return Masosach;
	}
	public void setMasosach(int masosach) {
		Masosach = masosach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getMatacgia() {
		return matacgia;
	}
	public void setMatacgia(int matacgia) {
		this.matacgia = matacgia;
	}
	public int getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(int maNXB) {
		this.maNXB = maNXB;
	}
	public int getMaloai() {
		return maloai;
	}
	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}
	public int getNamxb() {
		return namxb;
	}
	public void setNamxb(int namxb) {
		this.namxb = namxb;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getMake() {
		return Make;
	}
	public void setMake(int make) {
		Make = make;
	}
	public SachDTO(int masosach, String tensach, int matacgia, int maNXB, int maloai, int namxb, int soluong,
			String ghichu, String hinhanh, int make) {
		super();
		Masosach = masosach;
		this.tensach = tensach;
		this.matacgia = matacgia;
		this.maNXB = maNXB;
		this.maloai = maloai;
		this.namxb = namxb;
		this.soluong = soluong;
		this.ghichu = ghichu;
		this.hinhanh = hinhanh;
		Make = make;
	}
	public SachDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
