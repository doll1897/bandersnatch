package com.cts.Dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import com.cts.Util.DBConnection;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;

public class KeywordSearchDAOImpl implements KeywordSearchDAO {
private Connection connection = null;
	
	@Override
	public String keywordSearch(String keyword) {
		connection = DBConnection.getConnection();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String keyword=request.getParameter("search2");
		
		try{
			Blob textfile=null;
			
	         String query="select keyword,description from keywordsearch where keyword=?";
	         PreparedStatement pst=(PreparedStatement) connection.prepareStatement(query);
	         pst.setString(1, keyword);
	         ResultSet rs=pst.executeQuery();
	         while(rs.next())
	         {
	        	 String word=rs.getString(1);
	        	 
	        		 textfile=(Blob) rs.getBlob(2);
	        	 InputStream inputStream=textfile.getBinaryStream();
	        	 BufferedReader br = null;
	        	 br = new BufferedReader(new InputStreamReader(inputStream));

	     		StringBuilder sb = new StringBuilder();

	     		String line;
	     		while ((line = br.readLine()) != null) {
	     			sb.append(line);
	     		}
	     		
	     		//System.out.println("sbss"+sb);
	        	
	     		//return sb.toString();
	        	return sb.toString();	 
	         }
	         connection.close();
	         
		}
	         catch(Exception e)
		{e.printStackTrace();
	         }
		return null;
	}

}
