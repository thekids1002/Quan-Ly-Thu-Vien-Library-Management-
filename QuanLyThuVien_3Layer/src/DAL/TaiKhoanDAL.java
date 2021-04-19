package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.LoaisachDTO;
import DTO.TaiKhoan;

public class TaiKhoanDAL {
	public static ArrayList<TaiKhoan> getdanhsachTK(){
		try {
			
			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from taikhoan");
			
			
            ArrayList<TaiKhoan> taiKhoans = new ArrayList<>();
            while(rs.next()) {
            	TaiKhoan tk = new TaiKhoan();
            	tk.setMaTaiKhoan(rs.getInt(1));
            	tk.setUsername(rs.getString(2));
            	tk.setPassword(rs.getString(3));
            	tk.setMaQuyen(rs.getInt(4));
            	taiKhoans.add(tk);
            }
            return taiKhoans;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
}		
