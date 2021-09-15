package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LoaiSachDAL;
import DTO.LoaisachDTO;

public class LoaiBUS {
	private LoaiSachDAL loaiSachDAL = new LoaiSachDAL();
	private ArrayList<LoaisachDTO> listloai = new ArrayList<LoaisachDTO>();

	public ArrayList<LoaisachDTO> getLoaisachLoai() {

		return LoaiSachDAL.getdanhsachLoai();
	}

	public int themloai(LoaisachDTO loai) {
		if(loai.getTenloai().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên loại");
			return -1 ;
		}
		for (LoaisachDTO loai2 : getLoaisachLoai()) {
			if(loai2.getTenloai().equals(loai.getTenloai())) {
				JOptionPane.showMessageDialog(null, "Loại đã có");
				return -1 ;
			}
		}
		if(loaiSachDAL.themloaisach(loai) > 0) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return 1;
	}

	public int xoaloai(LoaisachDTO loai) {
		if(loaiSachDAL.xoaloaisach(loai) > 0) {
			JOptionPane.showMessageDialog(null, "Xoá thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Xoá thất bại");
		return 0 ;
	}

	public int sualoai(LoaisachDTO loai) {
		if(loai.getTenloai().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên loại");
			return -1 ;
		}
		for (LoaisachDTO loai2 : getLoaisachLoai()) {
			if(loai2.getTenloai().equals(loai.getTenloai())) {
				JOptionPane.showMessageDialog(null, "Loại đã có");
				return -1 ;
			}
		}
		if(loaiSachDAL.sualoaisach(loai) > 0) {
			JOptionPane.showMessageDialog(null, "Đã sửa thành công");
			
		}
//		return loaiSachDAL.sualoaisach(loai);
		return 1;

	}
	
	public static LoaiBUS gI() {
		return new LoaiBUS(); 
	}
}
