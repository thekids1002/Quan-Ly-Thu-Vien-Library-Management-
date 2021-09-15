package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	public int themnhanvien(NhanVien nv) {
		if(nv.getTenNV().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên nhân viên");
			return -1;
		}
		if(nv.getDiaChi().isEmpty()) {
			showmess("Không được để trống địa chỉ");
			return -1;
		}
		if(nv.getGioiTinh().isEmpty()) {
			showmess("Không được để trống giới tính");
			return -1;
		}
		if(nv.getNamSinh().isEmpty()) {
			showmess("Không được để trống năm sinh");
			return -1;
		}
		if(nv.getSdt().isEmpty()) {
			showmess("Không được để trống số điện thoại");
			return -1;
		}
		if(NhanVienDAL.themnhanvien(nv) > 0) {
			showmess("Đã thêm nhân viên thành công");
			return 1;
		}
		showmess("Thêm nhân viên thất bại");
		return -1;
	}

	public int suanhanvien(NhanVien nv) {
		if(nv.getTenNV().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên nhân viên");
			return -1;
		}
		if(nv.getDiaChi().isEmpty()) {
			showmess("Không được để trống địa chỉ");
			return -1;
		}
		if(nv.getGioiTinh().isEmpty()) {
			showmess("Không được để trống giới tính");
			return -1;
		}
		if(nv.getNamSinh().isEmpty()) {
			showmess("Không được để trống năm sinh");
			return -1;
		}
		if(nv.getSdt().isEmpty()) {
			showmess("Không được để trống số điện thoại");
			return -1;
		}
		if(NhanVienDAL.suanhanvien(nv) > 0) {
			showmess("Đã sửa nhân viên thành công");
			return 1;
		}
		showmess("Sửa nhân viên thất bại");
		return -1;
	}

	public int xoanhanvien(NhanVien nv) {
		if(NhanVienDAL.xoanv(nv) > 0) {
			showmess("Đã xoá nhân viên thành công");
			return 1;
		}
		showmess("Xoá nhân viên thất bại");
		return -1;
	}
	
	public static NhanVienBus gI() {
		return new NhanVienBus();
	}
}
