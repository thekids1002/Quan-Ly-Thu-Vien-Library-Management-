package BUS;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import DAL.DBConnect;
import DAL.LoaiSachDAL;
import DAL.NhaCungCapDAL;
import DTO.LoaisachDTO;
import DTO.NhaCungCapDTO;

public class NhaCungcapbus {
	private NhaCungCapDAL nhaCungCapDAL = new NhaCungCapDAL();
	private ArrayList<NhaCungCapDTO> listncc = new ArrayList<NhaCungCapDTO>();

	public ArrayList<NhaCungCapDTO> getdanhsachncc() {

		return NhaCungCapDAL.getdanhsachncc();
	}

	public int themncc(NhaCungCapDTO ncc) {
		return nhaCungCapDAL.themloaisach(ncc);
	}

	public int suancc(NhaCungCapDTO ncc) {
		return nhaCungCapDAL.sualoaisach(ncc);
	}

	public int xoancc(NhaCungCapDTO ncc) {
		return nhaCungCapDAL.xoaloaisach(ncc);
	}
	
	public static NhaCungcapbus gI() {
		return new NhaCungcapbus(); 
	}
}
