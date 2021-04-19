package BUS;

import java.util.ArrayList;

import DAL.LoaiSachDAL;
import DTO.LoaisachDTO;

public class LoaiBUS {
	private LoaiSachDAL loaiSachDAL = new LoaiSachDAL();
	private ArrayList<LoaisachDTO> listloai = new ArrayList<LoaisachDTO>();

	public ArrayList<LoaisachDTO> getLoaisachLoai() {

		return LoaiSachDAL.getdanhsachLoai();
	}

	public int themloai(LoaisachDTO loai) {
		return loaiSachDAL.themloaisach(loai);
	}

	public int xoaloai(LoaisachDTO loai) {
		return loaiSachDAL.xoaloaisach(loai);
	}

	public int sualoai(LoaisachDTO loai) {
		return loaiSachDAL.sualoaisach(loai);

	}
	
	public static LoaiBUS gI() {
		return new LoaiBUS(); 
	}
}
