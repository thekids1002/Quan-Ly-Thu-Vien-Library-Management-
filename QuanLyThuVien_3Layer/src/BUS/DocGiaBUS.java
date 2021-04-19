package BUS;

import java.util.ArrayList;

import DAL.DocGiaDAL;
import DTO.DocGia;
import DTO.TacGiaDTO;

public class DocGiaBUS {
	DocGiaDAL docgia = new DocGiaDAL() ;
	
	public static DocGiaBUS docgia1 = null; 
	public static DocGiaBUS gI() {
		if(docgia1 == null) {
			docgia1 =  new DocGiaBUS();
		}
		return docgia1;
	}
	public ArrayList<DocGia> getdanhsachdocgia() {

		return docgia.getdanhsachdocgia();
	}
	
	public int themdocgia(DocGia docgia) {
		int ketqua = DocGiaDAL.themdocgia(docgia) ;
		return ketqua; 
		
	}
	public int suadocgia(DocGia docgia) {
		int ketqua = DocGiaDAL.suadocgia(docgia);
		return ketqua ;
	}
	
	public int xoadocgia(DocGia docgia) {
		int ketqua = DocGiaDAL.xoadocgia(docgia);		
		return ketqua; 
	
	}
	
	
	
}
