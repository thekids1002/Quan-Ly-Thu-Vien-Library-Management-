package DTO;

public class NhaCungCapDTO {
	private int MaNCC;
	private String TenNCC;
	public int getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}
	public String getTenNCC() {
		return TenNCC;
	}
	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}
	public NhaCungCapDTO(int maNCC, String tenNCC) {
		super();
		MaNCC = maNCC;
		TenNCC = tenNCC;
	}
	public NhaCungCapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhaCungCap [MaNCC=" + MaNCC + ", TenNCC=" + TenNCC + "]";
	}
	
}
