package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.TacGiaDAL;

import DTO.TacGiaDTO;

public class TacGiaBUS {
	private ArrayList<TacGiaDTO> listncc = new ArrayList<TacGiaDTO>();
	TacGiaDAL tg = new TacGiaDAL(); 
	public ArrayList<TacGiaDTO> getdanhsachtacgia() {

		return TacGiaDAL.getdanhsachtacgia();
	}
	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	public int themtacgia(TacGiaDTO tacgia) {
		if(tacgia.getTenTacGia().isEmpty()) {
			showmess("Tên tác giả không được để trống");
			return -1;
		}
		if(tacgia.getNamSinh().isEmpty()) {
			showmess("Năm sinh không được để trống");
			return -1;
		}
		if(tacgia.getQueQuan().isEmpty()) {
			showmess("Quê quán không được để trống");
			return -1;
		}
		if(TacGiaDAL.themtacgia(tacgia) > 0) {
			showmess("Thêm thành công");
			return 1;
		}
		showmess("Thêm thất bại");
		return -1;
	}

	public int suatacgia(TacGiaDTO tacgia) {
		if(tacgia.getTenTacGia().isEmpty()) {
			showmess("Tên tác giả không được để trống");
			return -1;
		}
		if(tacgia.getNamSinh().isEmpty()) {
			showmess("Năm sinh không được để trống");
			return -1;
		}
		if(tacgia.getQueQuan().isEmpty()) {
			showmess("Quê quán không được để trống");
			return -1;
		}
		if(TacGiaDAL.suatacgia(tacgia) > 0) {
			showmess("Sửa thành công");
			return 1;
		}
		showmess("Sửa thất bại");
		return -1;
	}

	public int xoatacgia(TacGiaDTO tacgia) {
		if(TacGiaDAL.xoatacgia(tacgia) > 0) {
			showmess("Xoa thành công");
			return 1;
		}
		showmess("Xoá thất bại");
		return -1;
	}
	public TacGiaDTO timtacgia(int ma) {
		return tg.timtacgia(ma); 
		
	}
	public static TacGiaBUS iBus = null;

	public static TacGiaBUS gI() {
		if (iBus == null) {
			iBus = new TacGiaBUS();
		}

		return iBus;
	}
}
