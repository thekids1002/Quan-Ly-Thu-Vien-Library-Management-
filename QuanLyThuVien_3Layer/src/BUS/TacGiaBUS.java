package BUS;

import java.util.ArrayList;

import DAL.TacGiaDAL;

import DTO.TacGiaDTO;

public class TacGiaBUS {
	private ArrayList<TacGiaDTO> listncc = new ArrayList<TacGiaDTO>();

	public ArrayList<TacGiaDTO> getdanhsachtacgia() {

		return TacGiaDAL.getdanhsachtacgia();
	}

	public int themtacgia(TacGiaDTO tacgia) {
		return TacGiaDAL.themnxb(tacgia);
	}

	public int suatacgia(TacGiaDTO tacgia) {
		return TacGiaDAL.themnxb(tacgia);
	}

	public int xoatacgia(TacGiaDTO tacgia) {
		return TacGiaDAL.xoanxb(tacgia);
	}

	public static TacGiaBUS iBus = null;

	public static TacGiaBUS gI() {
		if (iBus == null) {
			iBus = new TacGiaBUS();
		}

		return iBus;
	}
}
