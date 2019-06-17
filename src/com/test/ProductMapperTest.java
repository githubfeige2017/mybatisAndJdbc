package com.test;

import java.io.IOException;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.impl.Log4jLoggerFactory;

import com.bean.Product;
import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.mapper.ProductMapper;
import com.pojo.MallCateGoryPojo;
import com.pojo.ProductPojo;

public class ProductMapperTest {
	
	
	
	
	
	private SqlSessionFactory sqlSessionFactory;

//    private static final Logger log = LoggerFactory.getLogger(LogTest.class);
//    private static final Logger log2 = LoggerFactory.getLogger("liveness");

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
	public void findpRoductById() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis可以自动生成mapper接口实现类代理对象
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		Product product=productMapper.findpRoductById(29);
		System.out.println(product);
	}
	@Test
	//一对多查询 
	public void findpRoductsByName() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis可以自动生成mapper接口实现类代理对象
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> products=productMapper.findProductsByName("数码3C");
		for(Product product:products) {
			System.out.println(product);
		}
	
	}
	//更新记录
	@Test
	public void updateProductsById() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis可以自动生成mapper接口实现类代理对象
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		Product product=new Product();
        product.setId(26);//主键必须
        //product.setName("iPhone10Plus");
        product.setSubtitle("iPhone10 现更以流光金色呈现。");
        product.setPrice(7888.8);
        Date date=new Date();
        product.setUpdate_time(date);
        productMapper.updateProductById(product);
        sqlSession.commit();
        sqlSession.close();
	}
	
	//一对多查询 resultType
	
	@Test
	public void findpRoductsById() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis可以自动生成mapper接口实现类代理对象
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<ProductPojo> products=productMapper.findProductsById(100002);
	
	}
	
	
	
	//一对多
	@Test
	public void findpRoductsByNames() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis可以自动生成mapper接口实现类代理对象
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<MallCateGoryPojo> products=productMapper.findProductBYCatName("数码3C");
	
	}
	
	
	
	
	//一对一查询 resultMap
	@Test
	public void findpRoductsByIdresultMap() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis可以自动生成mapper接口实现类代理对象
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> products=productMapper.findProductsByIdresultMap();
	}
	
	//一对多查询
	
	
	
	
	
	
	
	
	
	

}
