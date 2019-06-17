package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.bean.Product;
import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;

public class ProductDaoTest {
	
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws IOException {
		// mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void Test() {
		ProductDao  dao=new ProductDaoImpl(sqlSessionFactory);
		Product product=dao.findpRoductById(32);
		System.out.println(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
