package com.module.service.pub;

import java.util.List;

import com.module.domain.pub.ItemFormUser;
import com.module.domain.pub.ItemFormUserHis;
import com.module.domain.pub.ItemFormUserT;

public interface ItemFormUserHisService{

	void save(ItemFormUserHis  itemFormUserHisT);

	List<ItemFormUserHis> itemFormUserHis(String params);
	
}