package BUS;

import java.util.ArrayList;

import DAL.PhieuMuonDAL;

import DTO.PhieuMuon;

public class PhieuMuonBus {
	PhieuMuonDAL pmdal = new PhieuMuonDAL(); 
	private ArrayList<PhieuMuon> listpm = new ArrayList<PhieuMuon>();

	public ArrayList<PhieuMuon> getdanhsachpm() {

		return listpm = pmdal.getdanhsachphieumuon();
	}

	public int thempm(PhieuMuon pm) {
		return pmdal.thempm(pm);
	}

	public int suapm(PhieuMuon pm) {
		return pmdal.suanxb(pm);
	}

	public int xoapm(PhieuMuon pm) {
		return pmdal.xoanxb(pm);
	}

	public static PhieuMuonBus iBus = null;

	public static PhieuMuonBus gI() {
		if (iBus == null) {
			iBus = new PhieuMuonBus();
		}

		return iBus;
	}
}
