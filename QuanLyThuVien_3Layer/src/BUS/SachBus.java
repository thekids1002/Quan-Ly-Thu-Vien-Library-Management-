package BUS;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import DTO.SachDTO;
import DAL.SachDAL;

public class SachBus {
	private SachDAL SachDAL = new SachDAL();
	private ArrayList<SachDTO> listloai = new ArrayList<SachDTO>();

	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	public ArrayList<SachDTO> getLoaisachLoai() {

		return DAL.SachDAL.getdanhsachLoai();
	}

	public int themsach(SachDTO pm) {
		Date d = new Date();
		int year = d.getYear() + 1900;
		if (pm.getTensach().isEmpty()) {
			showmess("Không được để trống tên sách");
			return -1;
		}
		if (pm.getSoluong() <= 0) {
			showmess("Số lượgn sách phải lớn hơn 0");
			return -1;
		}
		if (pm.getNamxb() > year) {
			showmess("Năm xuất bản sai");
			return -1;
		}
		if (pm.getMatacgia() < 0) {
			showmess("Mã tác giả sai");
			return -1;
		}
		if (pm.getHinhanh().isEmpty()) {
			showmess("Bạn chưa chọn hình ảnh");
			return -1;
		}
		if (SachDAL.themsach(pm) > 0) {
			showmess("Đã thêm sách thành công");
			return 1;
		}
		showmess("Thêm sách thât bại");
		return -1;
	}

	public int suasach(SachDTO pm) {
		Date d = new Date();
		int year = d.getYear() + 1900;
		if (pm.getTensach().isEmpty()) {
			showmess("Không được để trống tên sách");
			return -1;
		}
		if (pm.getSoluong() <= 0) {
			showmess("Số lượgn sách phải lớn hơn 0");
			return -1;
		}
		if (pm.getNamxb() > year) {
			showmess("Năm xuất bản sai");
			return -1;
		}
		if (pm.getMatacgia() < 0) {
			showmess("Mã tác giả sai");
			return -1;
		}
		if (pm.getHinhanh().isEmpty()) {
			showmess("Bạn chưa chọn hình ảnh");
			return -1;
		}
		if (SachDAL.suasach(pm) > 0) {
			showmess("Đã sửa sách thành công");
			return 1;
		}
		showmess("Sửa sách thât bại");
		return -1;
	}

	public int xoasach(SachDTO pm) {
		if (SachDAL.xoasach(pm) > 0) {
			showmess("Đã Xoá sách thành công");
			return 1;
		}
		showmess("Xoá sách thât bại");
		return -1;
	}

	public int soluongsach() {
		return SachDAL.getsoluongallsach();
	}

	public SachDTO timsach(int ma) {
		return SachDAL.timsach(ma);

	}

	public static SachBus iBus = null;

	public static SachBus gI() {
		if (iBus == null) {
			iBus = new SachBus();
		}

		return iBus;
	}

}
