package com.lianlife.demo.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lianlife.demo.model.Comment;
import com.lianlife.demo.model.CommentDomain;
import com.lianlife.demo.model.Dynamic;
import com.lianlife.demo.model.DynamicDomain;


@Repository
public class DynamicDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addDynamic(DynamicDomain dynamicDomain) throws UnsupportedEncodingException{		
		sqlSessionTemplate.insert("addDynamic", dynamicDomain);		
	}
	public List<Dynamic> getDynamicList() throws UnsupportedEncodingException{
		
		List<DynamicDomain> dynamicDomainList= sqlSessionTemplate.selectList("getDynamicList",null);
		List<Dynamic> dynamicList = new ArrayList();
		
		for(int i=0;i<dynamicDomainList.size();i++){
			DynamicDomain dynamicDomain = dynamicDomainList.get(i);
			Dynamic dynamic = new Dynamic();
			
			dynamic.setUserName(dynamicDomain.getUserName());
			dynamic.setUserImage(dynamicDomain.getUserImage());
			dynamic.setMessageId(dynamicDomain.getMessageId());
			dynamic.setMessageContent(new String(dynamicDomain.getMessageContent(),"UTF-8"));
			
			dynamicList.add(dynamic);
		}
		
		return dynamicList;		
		
	}
	

}
