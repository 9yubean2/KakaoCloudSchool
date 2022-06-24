package com.dia.control.guestbook;

import java.util.ArrayList;
import java.util.List;

public class GuestbookDAO {
	List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();

	public GuestbookDAO() {
		super();
		for(int i=1;i<=20;i++) {
			list.add(new GuestbookDTO(i,"title"+i,"content"+i,"writer"+i,"2022-06-24",100+i));
		}
		
	}
	List<GuestbookDTO> getList(){
		return list;
	}
	
	GuestbookDTO getView(int id){
		return list.get(id);
	}
	
	void insert (GuestbookDTO dto) {
		dto.setId(list.size()+1);
		list.add(dto);
	}
	
}
