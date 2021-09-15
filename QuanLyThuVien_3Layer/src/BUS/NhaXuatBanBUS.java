package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.NhaCungCapDAL;
import DAL.NhaXuatBanDAL;
import DTO.NhaCungCapDTO;
import DTO.NhaXuatBan;

public class NhaXuatBanBUS {
	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	private ArrayList<NhaXuatBan> listncc = new ArrayList<NhaXuatBan>();

	public ArrayList<NhaXuatBan> getdanhsachnxb() {

		return NhaXuatBanDAL.getdanhnxb();
	}
	
	public int themnxb(NhaXuatBan nxb) {
		if(nxb.getTenNXB().isEmpty()) {
			showmess("Không được để trống tên nxb");
			return -1 ;
		}
		if(nxb.getDiaChi().isEmpty()) {
			showmess("Không được để trống địa chỉ");
			return -1;
		}
		if(nxb.getSdt().isEmpty()) {
			showmess("Không được để trống số điện thoại");
			return -1;
		}
		if(NhaXuatBanDAL.themnxb(nxb) > 0) {
			showmess("Thêm thành công");
			return 1;
		}
		showmess("Thêm thất bại");
		return -1;
	}

	public int suanxb(NhaXuatBan nxb) {
		if(nxb.getTenNXB().isEmpty()) {
			showmess("Không được để trống tên nxb");
			return -1 ;
		}
		if(nxb.getDiaChi().isEmpty()) {
			showmess("Không được để trống địa chỉ");
			return -1;
		}
		if(nxb.getSdt().isEmpty()) {
			showmess("Không được để trống số điện thoại");
			return -1;
		}
		if(NhaXuatBanDAL.suanxb(nxb) > 0) {
			showmess("Sửa thành công");
			return 1;
		}
		showmess("Sửa thất bại");
		return -1;
	}

	public int xoanxb(NhaXuatBan nxb) {
		if(NhaXuatBanDAL.xoanxb(nxb) > 0) {
			showmess("Xoá thành công");
			return 1;
		}
		showmess("Xoá thất bại");
		return -1;
	}

	public static NhaXuatBanBUS gI() {
		return new NhaXuatBanBUS();
	}

	public NhaXuatBan timnxb(int ma) {

		return new NhaXuatBanDAL().timnxb(ma);
	}
}
