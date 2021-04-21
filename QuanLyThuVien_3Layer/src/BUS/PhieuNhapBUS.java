package BUS;

import java.util.ArrayList;

import DAL.PhieuMuonDAL;
import DAL.PhieuNhapDAL;
import DTO.PhieuMuon;
import DTO.PhieuNhap;

public class PhieuNhapBUS {
	PhieuNhapDAL pmdal = new PhieuNhapDAL(); 
	private ArrayList<PhieuNhap> listpm = new ArrayList<PhieuNhap>();

	public ArrayList<PhieuNhap> getdanhsachphieunhap() {

		return listpm = pmdal.getdanhsachphieunhap();
	}

	public int thempm(PhieuNhap pm) {
		return pmdal.ThemPN(pm) ; 
	}

	public int suapm(PhieuNhap pm) {
		return pmdal.SuaPn(pm) ;
	}

	public int xoapm(PhieuNhap pm) {
		return pmdal.xoanxb(pm); 
	}

	public static PhieuNhapBUS iBus = null;

	public static PhieuNhapBUS gI() {
		if (iBus == null) {
			iBus = new PhieuNhapBUS();
		}

		return iBus;
	}
}
