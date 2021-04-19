package BUS;

import java.util.ArrayList;

import DAL.LoaiSachDAL;
import DTO.LoaisachDTO;
import DTO.SachDTO;
import DAL.SachDAL;

public class SachBus {
	private SachDAL SachDAL = new  SachDAL();
	private ArrayList<SachDTO> listloai = new  ArrayList<SachDTO>();
	
	public ArrayList<SachDTO> getLoaisachLoai(){
		
		return DAL.SachDAL.getdanhsachLoai(); 
	}
}
