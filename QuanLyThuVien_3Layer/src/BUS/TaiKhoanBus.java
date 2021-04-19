package BUS;

import java.util.ArrayList;

import DAL.TaiKhoanDAL;
import DTO.TaiKhoan;

public class TaiKhoanBus {
	private TaiKhoanDAL TAIKHOAN = new  TaiKhoanDAL();
	private ArrayList<TaiKhoan> listTAIKHOAN = new  ArrayList<TaiKhoan>();
	public ArrayList<TaiKhoan> getDanhSachTL(){
		
		return TAIKHOAN.getdanhsachTK();
	}
	
	
}
