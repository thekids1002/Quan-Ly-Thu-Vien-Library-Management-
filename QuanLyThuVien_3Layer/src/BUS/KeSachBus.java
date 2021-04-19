package BUS;

import java.util.ArrayList;

import DAL.KeSachDAL;
import DAL.NhaCungCapDAL;
import DTO.KeSachDTO;
import DTO.NhaCungCapDTO;

public class KeSachBus {
	KeSachDAL keSachDAL = new KeSachDAL();

	public ArrayList<KeSachDTO> getdanhsachncc() {

		return KeSachDAL.getdanhsachle();
	}

	public int themke(KeSachDTO kesach) {
		return keSachDAL.themkesach(kesach);
	}

	public int suake(KeSachDTO kesach) {
		return keSachDAL.suakesach(kesach);
	}

	public int xoake(KeSachDTO kesach) {
		return keSachDAL.xoakesach(kesach);
	}
	
	public static KeSachBus gI() {
		return new KeSachBus();
	}
}
