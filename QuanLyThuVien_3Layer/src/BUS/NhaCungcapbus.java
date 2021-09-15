package BUS;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		if(ncc.getTenNCC().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên nhà cung cấp");
			return -1;
		}
		for(NhaCungCapDTO nccc : getdanhsachncc()) {
			if(nccc.getTenNCC().equalsIgnoreCase(ncc.getTenNCC())) {
				JOptionPane.showMessageDialog(null, "Tên nhà cung cấp đã trùng");
				return -1;
			}
		}
		if(nhaCungCapDAL.themncc(ncc) > 0 ) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Thêm thất bại");
		return -1;
	}

	public int suancc(NhaCungCapDTO ncc) {
		if(ncc.getTenNCC().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên nhà cung cấp");
			return -1;
		}
		for(NhaCungCapDTO nccc : getdanhsachncc()) {
			if(nccc.getTenNCC().equalsIgnoreCase(ncc.getTenNCC())) {
				JOptionPane.showMessageDialog(null, "Tên nhà cung cấp đã trùng");
				return -1;
			}
		}
		if(nhaCungCapDAL.suancc(ncc) > 0 ) {
			JOptionPane.showMessageDialog(null, "Sửa  thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Sửa thất bại");
		return -1;
	}

	public int xoancc(NhaCungCapDTO ncc) {
		if(nhaCungCapDAL.xoancc(ncc) > -1) {
			JOptionPane.showMessageDialog(null, "Xoá thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Xoá thất bại");
		return -1;
	}
	
	public static NhaCungcapbus gI() {
		return new NhaCungcapbus(); 
	}
}
