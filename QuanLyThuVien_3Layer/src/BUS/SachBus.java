package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LoaiSachDAL;
import DTO.LoaisachDTO;
import DTO.PhieuNhap;
import DTO.SachDTO;
import DAL.SachDAL;

public class SachBus {
	private SachDAL SachDAL = new  SachDAL();
	private ArrayList<SachDTO> listloai = new  ArrayList<SachDTO>();
	
	public ArrayList<SachDTO> getLoaisachLoai(){
		
		return DAL.SachDAL.getdanhsachLoai(); 
	}
	public int themsach(SachDTO pm) {
		return SachDAL.themsach(pm) ; 
	}

	public int suapm(SachDTO pm) {
		return SachDAL.suasach(pm) ;
	}

	public int xoapm(SachDTO pm) {
		return SachDAL.xoanxb(pm); 
	}
	public  int soluongsach() {
		return SachDAL.getsoluongallsach();
	}
	
	public SachDTO timsach(int ma) {
		return SachDAL.timsach(ma); 
		
	}
	public static SachBus iBus = null;

	public static SachBus gI() {
		if (iBus == null) {
			iBus = new SachBus();
		}

		return iBus;
	}
	
}
