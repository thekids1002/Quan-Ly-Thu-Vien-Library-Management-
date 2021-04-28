package BUS;

import java.util.ArrayList;

import DAL.NhaCungCapDAL;
import DAL.NhaXuatBanDAL;
import DTO.NhaCungCapDTO;
import DTO.NhaXuatBan;

public class NhaXuatBanBUS {
	private ArrayList<NhaXuatBan> listncc = new ArrayList<NhaXuatBan>();

	public ArrayList<NhaXuatBan> getdanhsachnxb() {

		return NhaXuatBanDAL.getdanhnxb();
	}

	public int themnxb(NhaXuatBan nxb) {
		return NhaXuatBanDAL.themnxb(nxb);
	}

	public int suanxb(NhaXuatBan nxb) {
		return NhaXuatBanDAL.suanxb(nxb);
	}

	public int xoanxb(NhaXuatBan nxb) {
		return NhaXuatBanDAL.xoanxb(nxb);
	}

	public static NhaXuatBanBUS gI() {
		return new NhaXuatBanBUS();
	}

	public NhaXuatBan timnxb(int ma) {

		return new NhaXuatBanDAL().timnxb(ma);
	}
}
