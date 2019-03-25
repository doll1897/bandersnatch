package com.cts.service;

import com.cts.Dao.KeywordSearchDAO;
import com.cts.Dao.KeywordSearchDAOImpl;

public class keywordSearchServiceImpl implements keywordSearchService {
	
	KeywordSearchDAO keywordSearchDAO = new KeywordSearchDAOImpl();
	
	
	public String keywordSearch(String keyword)
	{
		return keywordSearchDAO.keywordSearch(keyword);
	}

}
