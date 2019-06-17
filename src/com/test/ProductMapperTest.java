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
		// mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        // �õ������ļ���
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void findpRoductById() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis�����Զ�����mapper�ӿ�ʵ����������
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		Product product=productMapper.findpRoductById(29);
		System.out.println(product);
	}
	@Test
	//һ�Զ��ѯ 
	public void findpRoductsByName() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis�����Զ�����mapper�ӿ�ʵ����������
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> products=productMapper.findProductsByName("����3C");
		for(Product product:products) {
			System.out.println(product);
		}
	
	}
	//���¼�¼
	@Test
	public void updateProductsById() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis�����Զ�����mapper�ӿ�ʵ����������
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		Product product=new Product();
        product.setId(26);//��������
        //product.setName("iPhone10Plus");
        product.setSubtitle("iPhone10 �ָ��������ɫ���֡�");
        product.setPrice(7888.8);
        Date date=new Date();
        product.setUpdate_time(date);
        productMapper.updateProductById(product);
        sqlSession.commit();
        sqlSession.close();
	}
	
	//һ�Զ��ѯ resultType
	
	@Test
	public void findpRoductsById() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis�����Զ�����mapper�ӿ�ʵ����������
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<ProductPojo> products=productMapper.findProductsById(100002);
	
	}
	
	
	
	//һ�Զ�
	@Test
	public void findpRoductsByNames() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis�����Զ�����mapper�ӿ�ʵ����������
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<MallCateGoryPojo> products=productMapper.findProductBYCatName("����3C");
	
	}
	
	
	
	
	//һ��һ��ѯ resultMap
	@Test
	public void findpRoductsByIdresultMap() {
		SqlSession  sqlSession=sqlSessionFactory.openSession();
		//mybatis�����Զ�����mapper�ӿ�ʵ����������
		ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
		List<Product> products=productMapper.findProductsByIdresultMap();
	}
	
	//һ�Զ��ѯ
	
	
	
	
	
	
	
	
	
	

}
