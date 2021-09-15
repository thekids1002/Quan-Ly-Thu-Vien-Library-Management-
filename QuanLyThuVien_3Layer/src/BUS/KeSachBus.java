package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.KeSachDAL;
import DAL.NhaCungCapDAL;
import DTO.KeSachDTO;
import DTO.NhaCungCapDTO;
import GUI.MainFrame;

public class KeSachBus {
	KeSachDAL keSachDAL = new KeSachDAL();

	public ArrayList<KeSachDTO> getdanhsachke() {

		return KeSachDAL.getdanhsachke();
	}

	public int themke(KeSachDTO kesach) {
		for (KeSachDTO ke2 : getdanhsachke()) {
			if (ke2.getViTri().equals(kesach.getViTri())) {
				JOptionPane.showMessageDialog(null, "Kệ đã có");
				return -1 ;
			}
		}
		if(kesach.getViTri().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống");
			return -1;
		}
		if( keSachDAL.themkesach(kesach) > 0 ) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Thêm thất bại");
		return -1;
		//return keSachDAL.themkesach(kesach);
	}

	public int suake(KeSachDTO kesach) {
		if(kesach.getViTri().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống");
			return -1;
		}
		for (KeSachDTO ke2 : getdanhsachke()) {
			if (ke2.getViTri().equals(kesach.getViTri())) {
				JOptionPane.showMessageDialog(null, "Kệ đã có");
				return -1 ;
			}
		}
		if(KeSachDAL.suakesach(kesach) > 0) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
			return 1;
		}
		return -1;
	}

	public int xoake(KeSachDTO kesach) {
		if(keSachDAL.xoakesach(kesach) > 0) {
			JOptionPane.showMessageDialog(null, "Xoá thành công");
			return 1;
		}
		return -1;
	}
	
	public static KeSachBus gI() {
		return new KeSachBus();
	}
}
