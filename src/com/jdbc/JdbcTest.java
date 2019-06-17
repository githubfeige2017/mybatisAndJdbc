package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JdbcTest {
	
	
	public static void main(String[] args) {
		
		 Connection  connection=null;
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet=null;
		 
		 //�������ݿ�����
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mmall?characterEncoding=utf-8","root", "123"); 
					
			  //����sql��� ?��ʾռλ��
			  String sql="SELECT t.* from  mmall_category c ,mmall_product t where c.id=t.category_id and c.name=?";
			
			  //��ȡԤ����statement
			  preparedStatement= connection.prepareStatement(sql);
			
			  //���ò�������һ������Ϊsql����в�������ţ���1��ʼ�����ڶ�������Ϊ���õĲ���ֵ
			  preparedStatement.setString(1, "����");
			  
			  //�����ݿⷢ��sqlִ�в�ѯ����ѯ�������
			  resultSet=preparedStatement.executeQuery();
			  //������ѯ�����
			  while(resultSet.next()) {
				  System.out.println(resultSet.getString("category_id")+":"+resultSet.getString("name"));
			  }
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
	         //�ͷ���Դ
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
			
			
		}
		 
		 //ͨ�������������ȡ���ݿ�����
		 
		 //����sql��� ?��ʾռλ��
		
		
	}

}
