package DTO;

public class TaiKhoan {
	private int MaTaiKhoan; 
	private String username;
	private String password;
	private int MaQuyen;
	public int getMaTaiKhoan() {
		return MaTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		MaQuyen = maQuyen;
	}
	@Override
	public String toString() {
		return "TaiKhoan [MaTaiKhoan=" + MaTaiKhoan + ", username=" + username + ", password=" + password + ", MaQuyen="
				+ MaQuyen + "]";
	}
	public TaiKhoan(int maTaiKhoan, String username, String password, int maQuyen) {
		super();
		MaTaiKhoan = maTaiKhoan;
		this.username = username;
		this.password = password;
		MaQuyen = maQuyen;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
}
