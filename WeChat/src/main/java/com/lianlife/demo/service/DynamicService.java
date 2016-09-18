package com.lianlife.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lianlife.demo.dao.DynamicDao;
import com.lianlife.demo.model.Dynamic;
import com.lianlife.demo.model.DynamicDomain;

@Service
public class DynamicService {
	
	@Autowired
	DynamicDao dynamicDao;
	
	public void addDynamic(DynamicDomain dynamicDomain) throws UnsupportedEncodingException{
		dynamicDao.addDynamic(dynamicDomain);
	}
	
	public List<Dynamic> getDynamicList() throws UnsupportedEncodingException{
		List<Dynamic> dynamicList = dynamicDao.getDynamicList();
		return dynamicList;
	}

}
