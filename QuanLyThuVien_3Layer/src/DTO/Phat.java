package DTO;

public class Phat {
	private int maphieuphat; 
	private int mapm ;
	private String lydo ;
	private String tienphat ;
	@Override
	public String toString() {
		return "Phat [maphieuphat=" + maphieuphat + ", mapm=" + mapm + ", lydo=" + lydo + ", tienphat=" + tienphat
				+ "]";
	}
	public Phat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phat(int maphieuphat, int mapm, String lydo, String tienphat) {
		super();
		this.maphieuphat = maphieuphat;
		this.mapm = mapm;
		this.lydo = lydo;
		this.tienphat = tienphat;
	}
	public int getMaphieuphat() {
		return maphieuphat;
	}
	public void setMaphieuphat(int maphieuphat) {
		this.maphieuphat = maphieuphat;
	}
	public int getMapm() {
		return mapm;
	}
	public void setMapm(int mapm) {
		this.mapm = mapm;
	}
	public String getLydo() {
		return lydo;
	}
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	public String getTienphat() {
		return tienphat;
	}
	public void setTienphat(String tienphat) {
		this.tienphat = tienphat;
	}
	
}
