package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Product;


public class MybatisFirst {
	
	@Test
	public void findProductById() throws IOException {
	    // mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂得到SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        //从SqlSession中调用Executor执行数据库操作&&生成具体SQL指令
        Product product=sqlsession.selectOne("ProductMapper.findpRoductById", 26);
        System.out.println(product);
        sqlsession.close();
	}

	
	@Test
	public void findProductsByName() throws IOException {
		  // mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂得到SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
         List<Product>  productList=new ArrayList<>();
         productList =sqlsession.selectList("ProductMapper.findProductsByName", "数码3C");
         if(productList!=null&&productList.size()>0) {
        	 for(Product pro:productList) {
        		 System.out.println(pro);
             }
         }
        sqlsession.close();
	}

	
	@Test
	public void deleteProduct() throws IOException {
		  // mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂得到SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        // 传入id删除 用户
        sqlsession.delete("ProductMapper.deleteProductById", 33);
        sqlsession.commit();        
        sqlsession.close();
	}
	
	
	
	@Test
	public void insertProduct() throws IOException {
		  // mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂得到SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        //100002,'锤子手机','清仓亏本甩卖',288.8,1200,1
        Product product=new Product();
        product.setCategory_id(100002);
        product.setName("魅族手机");
        product.setSubtitle("业绩下滑！降价甩卖");
        product.setPrice(1288.8);
        product.setStatus(1);
        product.setStock(300);
        Date date=new Date();
        product.setCreate_time(date);
        product.setUpdate_time(date);
        
        
        sqlsession.insert("ProductMapper.insertProduct", product);
        sqlsession.commit();
        // 获取用户信息主键
        System.out.println("新增 的id："+product.getId());
        sqlsession.close();
	}
	@Test
	public void updateProduct() throws IOException {
		  // mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂得到SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        //100002,'锤子手机','清仓亏本甩卖',288.8,1200,1
        Product product=new Product();
        product.setId(31);//主键必须
        product.setSubtitle("锤子可能倒闭！稍微涨价哦");
        product.setPrice(688.8);
        Date date=new Date();
        product.setUpdate_time(date);
        sqlsession.update("ProductMapper.updateProductById", product);
        sqlsession.commit();
        sqlsession.close();
	}
}
