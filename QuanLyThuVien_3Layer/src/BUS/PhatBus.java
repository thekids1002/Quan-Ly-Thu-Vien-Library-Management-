package BUS;

import java.util.ArrayList;

import DAL.KeSachDAL;
import DAL.PhatDAL;
import DTO.KeSachDTO;
import DTO.Phat;

public class PhatBus {
	Phat keSachDAL = new Phat();

	public ArrayList<Phat> getdanhsachphat() {

		return PhatDAL.getdanhsachle();
	}

	public int themke(Phat kesach) {
		return PhatDAL.themkesach(kesach);
	}

	public int suake(Phat kesach) {
		return PhatDAL.suakesach(kesach);
	}

	public int xoake(Phat kesach) {
		return PhatDAL.xoakesach(kesach);
	}
	
	public static PhatBus gI() {
		return new PhatBus();
	}
}
