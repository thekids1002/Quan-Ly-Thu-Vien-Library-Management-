package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.PhieuMuonDAL;
import DAL.PhieuNhapDAL;
import DTO.PhieuMuon;
import DTO.PhieuNhap;

public class PhieuNhapBUS {
	PhieuNhapDAL pmdal = new PhieuNhapDAL(); 
	private ArrayList<PhieuNhap> listpm = new ArrayList<PhieuNhap>();

	public ArrayList<PhieuNhap> getdanhsachphieunhap() {

		return listpm = pmdal.getdanhsachphieunhap();
	}

	public int thempn(PhieuNhap pm) {
		 if(pmdal.ThemPN(pm) > 0) {
			 JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thành công");
			 return 1;
		 }
		 JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thất bại");
		 return -1;
	}

	public int suapn(PhieuNhap pm) {
		 if(pmdal.SuaPn(pm) > 0) {
			 JOptionPane.showMessageDialog(null, "Sửa phiếu nhập thành công");
			 return 1;
		 }
		 JOptionPane.showMessageDialog(null, "Sửa phiếu nhập thất bại");
		 return -1;
	}

	public int xoapn(PhieuNhap pm) {
		 if(pmdal.xoapn(pm) > 0) {
			 JOptionPane.showMessageDialog(null, "Xoá phiếu nhập thành công");
			 return 1;
		 }
		 JOptionPane.showMessageDialog(null, "Xoá phiếu nhập thất bại");
		 return -1;
	}

	public static PhieuNhapBUS iBus = null;

	public static PhieuNhapBUS gI() {
		if (iBus == null) {
			iBus = new PhieuNhapBUS();
		}

		return iBus;
	}

	public PhieuNhap getPhieuNhap(int mapn) {
		// TODO Auto-generated method stub
		return PhieuNhapDAL.getphieunhap(mapn);
	}
}
