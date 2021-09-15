package BUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAL.PhieuMuonDAL;
import DAL.chitietpmDAL;
import DTO.ChiTieuPMDTO;
import DTO.PhieuMuon;
import GUI.MainFrame;

public class chitietpmbus {
			
	ChiTieuPMDTO pmdal = new ChiTieuPMDTO(); 
	private ArrayList<PhieuMuon> listpm = new ArrayList<PhieuMuon>();

	public ArrayList<ChiTieuPMDTO> getdanhsachpm() {
		return chitietpmDAL.getdanhsachphieumuon();
	}
	public ArrayList<ChiTieuPMDTO> thongkephieumuon() {

		return chitietpmDAL.thongkephieumuon();
	}

	public int themctpm(ChiTieuPMDTO pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			if (!kiemtrasoluongphieumuon(pm.getMaPhieuMuon())) {
				JOptionPane.showMessageDialog(null, "Bạn không được mượn quá 5");
				return 2;
			}
			if(pm.getMaSach()< 0 ) {
				JOptionPane.showMessageDialog(null, "Mã sách không được bỏ trống");
				return -1;
			}
			if(sdf.parse(pm.getNgayTra()).before(sdf.parse(pm.getNgayMuon()))) {
				JOptionPane.showMessageDialog(null, "Ngày trả không được bé hơn ngày mượn");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(sdf.parse(pm.getNgayTra()))) {
				JOptionPane.showMessageDialog(null, "Ngày mượn không được lớn hơn ngày trả");
				return -1;
			}
			if(chitietpmDAL.themctpm(pm) > 0) {
				JOptionPane.showMessageDialog(null, "Thêm chi tiết thành công");
				return 1;
			}
			JOptionPane.showMessageDialog(null, "Thêm chi tiết thất bại");
			return -1;
		
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}	
	}

	public int suactpm(ChiTieuPMDTO pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			if (!kiemtrasoluongphieumuon(pm.getMaPhieuMuon())) {
				JOptionPane.showMessageDialog(null, "Bạn không được mượn quá 5");
				return 2;
			}
			if(pm.getMaSach()< 0 ) {
				JOptionPane.showMessageDialog(null, "Mã sách không được bỏ trống");
				return -1;
			}
			if(sdf.parse(pm.getNgayTra()).before(sdf.parse(pm.getNgayMuon()))) {
				JOptionPane.showMessageDialog(null, "Ngày trả không được bé hơn ngày mượn");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(sdf.parse(pm.getNgayTra()))) {
				JOptionPane.showMessageDialog(null, "Ngày mượn không được lớn hơn ngày trả");
				return -1;
			}
			if(chitietpmDAL.suactpm(pm) > 0) {
				JOptionPane.showMessageDialog(null, "Sửa chi tiết thành công");
				return 1;
			}
			JOptionPane.showMessageDialog(null, "Sửa chi tiết thất bại");
			return -1;
		
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}	
	}

	public int xoactpm(ChiTieuPMDTO pm) {
		if(chitietpmDAL.xoactpm(pm) > 0) {
			JOptionPane.showMessageDialog(null, "Xoá chi tiết thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Xoá chi tiết thất bại");
		return -1;
	}
	
	public int getsoluongsachdamuon() {
		return chitietpmDAL.getsoluongsachdamuon();
		
	}
	
	public static chitietpmbus iBus = null;

	public static chitietpmbus gI() {
		if (iBus == null) {
			iBus = new chitietpmbus();
		}

		return iBus;
	}
	protected boolean kiemtrasoluongphieumuon(int PM) {
		int i = 0;
		for (ChiTieuPMDTO ctpm : MainFrame.ctpm) {
			if (ctpm.getMaPhieuMuon() == PM) {
				System.out.println(ctpm.getMaPhieuMuon());
				i++;
			}
			if (i > 5) {
				// JOptionPane.showMessageDialog(null, "Bạn không được mượn quá 5 ");
				return false;

			}

		}
		return true;
	}
}
