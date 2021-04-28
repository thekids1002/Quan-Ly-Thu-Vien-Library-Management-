package BUS;

import java.util.ArrayList;


import DAL.PhatDAL;

import DTO.Phat;

public class PhatBus {
	Phat phatDAL = new Phat();

	public ArrayList<Phat> getdanhsachphat() {

		return PhatDAL.getdanhsachphieuphat();
	}

	public int themke(Phat phat) {
		return PhatDAL.themphieuphat(phat);
	}

	public int suake(Phat phat) {
		return PhatDAL.suaphieuphat(phat);
	}

	public int xoake(Phat phat) {
		return PhatDAL.xoaphieuphat(phat);
	}
	
	public static PhatBus gI() {
		return new PhatBus();
	}
}
