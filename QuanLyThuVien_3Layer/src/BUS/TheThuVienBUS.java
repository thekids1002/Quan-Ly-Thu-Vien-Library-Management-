package BUS;

import java.util.ArrayList;

import DAL.TacGiaDAL;
import DAL.TheThuVienDAL;
import DTO.TacGiaDTO;
import DTO.TheThuVien;

public class TheThuVienBUS {
	private ArrayList<TheThuVien> listncc = new ArrayList<TheThuVien>();
	TheThuVienDAL tg = new TheThuVienDAL(); 
	public ArrayList<TheThuVien> getdanhsachth() {

		return tg.getdanhsachthethuvien();
	}

	public int themtacgia(TheThuVien tacgia) {
		return tg.themthetv(tacgia); 
	}

	public int suatacgia(TheThuVien tacgia) {
		return tg.suanthethuvien(tacgia)
;	}

	public int xoatacgia(TheThuVien tacgia) {
		return tg.xoathethuvien(tacgia);
	}
	public TheThuVien timtacgia(int ma) {
		return tg.timthethuvien(ma);
		
	}
	public static TheThuVienBUS iBus = null;

	public static TheThuVienBUS gI() {
		if (iBus == null) {
			iBus = new TheThuVienBUS();
		}

		return iBus;
	}
	public int giahanthe(int mathe, String ngayketthuc) {
		return tg.giahanthe(mathe, ngayketthuc);
		
	}
}
