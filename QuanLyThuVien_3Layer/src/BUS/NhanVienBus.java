package BUS;

import java.util.ArrayList;

import DAL.NhaCungCapDAL;
import DAL.NhanVienDAL;
import DTO.NhaCungCapDTO;
import DTO.NhanVien;

public class NhanVienBus {
	private NhanVienDAL nhanVienDAL = new NhanVienDAL();
	private ArrayList<NhanVien> listnv = new ArrayList<NhanVien>();

	public ArrayList<NhanVien> getdanhsachnv() {

		return NhanVienDAL.getdanhsachnv();
	}

	public int themnhanvien(NhanVien nv) {
		return nhanVienDAL.themnhanvien(nv);
	}

	public int suanhanvien(NhanVien nv) {
		return nhanVienDAL.suanhanvien(nv);
	}

	public int xoanhanvien(NhanVien nv) {
		return nhanVienDAL.xoanv(nv);
	}
	
	public static NhanVienBus gI() {
		return new NhanVienBus();
	}
}
