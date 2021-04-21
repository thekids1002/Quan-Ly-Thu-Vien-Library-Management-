package BUS;

import java.util.ArrayList;

import DAL.ChiTietPhieuNhapDAL;
import DAL.chitietpmDAL;
import DTO.ChiTietPhieuNhap;
import DTO.ChiTieuPMDTO;
import DTO.PhieuMuon;

public class ChiTietPhieuNhapBUS {
	ChiTietPhieuNhap pmdal = new ChiTietPhieuNhap(); 
	private ArrayList<PhieuMuon> listpm = new ArrayList<PhieuMuon>();

	public ArrayList<ChiTietPhieuNhap> getdanhsachpm() {

		return ChiTietPhieuNhapDAL.getdanhsachctphieunhap();
	}

	public int thempm(ChiTietPhieuNhap pm) {
		return ChiTietPhieuNhapDAL.Themctpn(pm); 
	}

	public int suapm(ChiTietPhieuNhap pm) {
		return ChiTietPhieuNhapDAL.Suactpn(pm) ;
	}

	public int xoapm(ChiTietPhieuNhap pm) {
		return ChiTietPhieuNhapDAL.xoactpn(pm) ;
	}

	public static ChiTietPhieuNhapBUS iBus = null;

	public static ChiTietPhieuNhapBUS gI() {
		if (iBus == null) {
			iBus = new ChiTietPhieuNhapBUS();
		}

		return iBus;
	}
}
