package DTO;

public class LoaisachDTO {
	public int maloai;
	public String tenloai;

	public LoaisachDTO(int maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}

	public int getMaloai() {
		return maloai;
	}

	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}

	@Override
	public String toString() {
		return maloai + "-" + tenloai; 
	}

	public LoaisachDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
}
