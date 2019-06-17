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
		 
		 //加载数据库驱动
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mmall?characterEncoding=utf-8","root", "123"); 
					
			  //定义sql语句 ?表示占位符
			  String sql="SELECT t.* from  mmall_category c ,mmall_product t where c.id=t.category_id and c.name=?";
			
			  //获取预处理statement
			  preparedStatement= connection.prepareStatement(sql);
			
			  //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			  preparedStatement.setString(1, "冰箱");
			  
			  //向数据库发出sql执行查询，查询出结果集
			  resultSet=preparedStatement.executeQuery();
			  //遍历查询结果集
			  while(resultSet.next()) {
				  System.out.println(resultSet.getString("category_id")+":"+resultSet.getString("name"));
			  }
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
	         //释放资源
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
		 
		 //通过驱动管理类获取数据库链接
		 
		 //定义sql语句 ?表示占位符
		
		
	}

}
