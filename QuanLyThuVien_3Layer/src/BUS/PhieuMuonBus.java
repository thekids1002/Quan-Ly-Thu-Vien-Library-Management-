package BUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAL.PhieuMuonDAL;

import DTO.PhieuMuon;


public class PhieuMuonBus {
	PhieuMuonDAL pmdal = new PhieuMuonDAL();
	private ArrayList<PhieuMuon> listpm = new ArrayList<PhieuMuon>();

	public ArrayList<PhieuMuon> getdanhsachpm() {

		return listpm = pmdal.getdanhsachphieumuon();
	}

	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	public int thempm(PhieuMuon pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			if(pm.getMaNV() < 0) {
				showmess("Mã nhân viên sai");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(date) ) {
				showmess("Ngày mượn sai");
				return -1;
			}
			if(PhieuMuonDAL.thempm(pm) > 0) {
				showmess("Đã thêm phiếu mượnt thành công");
				return 1;
			}
			showmess("Đã thêm phiếu mượnt thất bại");
			return -1;
			
		} catch (Exception e) {
			return -1;
		}
	}

	public int suapm(PhieuMuon pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			if(pm.getMaNV() < 0) {
				showmess("Mã nhân viên sai");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(date) ) {
				showmess("Ngày mượn sai");
				return -1;
			}
			if(PhieuMuonDAL.suapm(pm) > 0) {
				showmess("Đã sửa phiếu mượnt thành công");
				return 1;
			}
			showmess("Đã sửa phiếu mượnt thất bại");
			return -1;
			
		} catch (Exception e) {
			return -1;
		}
	}

	public int xoapm(PhieuMuon pm) {
		if(PhieuMuonDAL.xoapm(pm) > 0) {
			showmess("Đã xoá phiếu mượn thành công");
			return 1;
		}
		showmess("Đã xoa phiếu mượnt thất bại");
		return -1;
	}

	public PhieuMuon timphieumuon(int ma) {
		if(ma > 0 ) {
			return pmdal.timphieumuon(ma);
		}
		return null;
	}

	public static PhieuMuonBus iBus = null;

	public static PhieuMuonBus gI() {
		if (iBus == null) {
			iBus = new PhieuMuonBus();
		}

		return iBus;
	}
}
