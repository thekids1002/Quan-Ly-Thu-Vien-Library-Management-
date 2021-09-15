package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ChiTietPhieuNhapDAL;
import DAL.chitietpmDAL;
import DTO.ChiTietPhieuNhap;
import DTO.ChiTieuPMDTO;
import DTO.PhieuMuon;

public class ChiTietPhieuNhapBUS {
	ChiTietPhieuNhap pmdal = new ChiTietPhieuNhap(); 
	private ArrayList<ChiTietPhieuNhap> listpm = new ArrayList<ChiTietPhieuNhap>();

	public ArrayList<ChiTietPhieuNhap> getdanhsachpm() {

		return listpm = ChiTietPhieuNhapDAL.getdanhsachctphieunhap();
	}
	public ArrayList<ChiTietPhieuNhap> getthongkenam(int nam) {
		// thống kê theo năm

		return ChiTietPhieuNhapDAL.getthongketheonam(nam); 
		
	}
	public ArrayList<ChiTietPhieuNhap> getthongketheongay(String date1, String date2 ) {
		// thống kê theo năm

		return ChiTietPhieuNhapDAL.getthongketheongay(date1,date2); 
		
	}
	public ArrayList<ChiTietPhieuNhap> thongkephieunhap() {

		return ChiTietPhieuNhapDAL.getthongke();
	}

	public int themctpn(ChiTietPhieuNhap pm) {
		if(ChiTietPhieuNhapDAL.Themctpn(pm) > 0 ) {
			JOptionPane.showMessageDialog(null, "Đã thêm chi tiết thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Đã thêm chi tiết thất bại");

		return -1;
	}

	public int suactpn(ChiTietPhieuNhap pm) {
		if(ChiTietPhieuNhapDAL.Suactpn(pm) > 0 ) {
			JOptionPane.showMessageDialog(null, "Đã sửa chi tiết thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Đã sửa chi tiết thất bại");

		return -1;
	}

	public int xoactpn(ChiTietPhieuNhap pm) {
		if(ChiTietPhieuNhapDAL.xoactpn(pm) > 0 ) {
			JOptionPane.showMessageDialog(null, "Đã xoá chi tiết thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Đã xoá chi tiết thất bại");

		return -1;
	}

	public static ChiTietPhieuNhapBUS iBus = null;
	
	public Object getPhieuNhap(int mapn) {
		for(ChiTietPhieuNhap ctpn : listpm) {
			if(ctpn.getMaCTPN() == mapn) {
				return mapn; 
			}
			
		}
		return null ;
	}
	
	public static ChiTietPhieuNhapBUS gI() {
		if (iBus == null) {
			iBus = new ChiTietPhieuNhapBUS();
		}

		return iBus;
	}
}
