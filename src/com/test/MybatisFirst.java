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
	    // mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        // �õ������ļ���
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ�������õ�SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        //��SqlSession�е���Executorִ�����ݿ����&&���ɾ���SQLָ��
        Product product=sqlsession.selectOne("ProductMapper.findpRoductById", 26);
        System.out.println(product);
        sqlsession.close();
	}

	
	@Test
	public void findProductsByName() throws IOException {
		  // mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        // �õ������ļ���
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ�������õ�SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
         List<Product>  productList=new ArrayList<>();
         productList =sqlsession.selectList("ProductMapper.findProductsByName", "����3C");
         if(productList!=null&&productList.size()>0) {
        	 for(Product pro:productList) {
        		 System.out.println(pro);
             }
         }
        sqlsession.close();
	}

	
	@Test
	public void deleteProduct() throws IOException {
		  // mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        // �õ������ļ���
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ�������õ�SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        // ����idɾ�� �û�
        sqlsession.delete("ProductMapper.deleteProductById", 33);
        sqlsession.commit();        
        sqlsession.close();
	}
	
	
	
	@Test
	public void insertProduct() throws IOException {
		  // mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        // �õ������ļ���
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ�������õ�SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        //100002,'�����ֻ�','��ֿ���˦��',288.8,1200,1
        Product product=new Product();
        product.setCategory_id(100002);
        product.setName("�����ֻ�");
        product.setSubtitle("ҵ���»�������˦��");
        product.setPrice(1288.8);
        product.setStatus(1);
        product.setStock(300);
        Date date=new Date();
        product.setCreate_time(date);
        product.setUpdate_time(date);
        
        
        sqlsession.insert("ProductMapper.insertProduct", product);
        sqlsession.commit();
        // ��ȡ�û���Ϣ����
        System.out.println("���� ��id��"+product.getId());
        sqlsession.close();
	}
	@Test
	public void updateProduct() throws IOException {
		  // mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        // �õ������ļ���
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ�������õ�SqlSession
        SqlSession sqlsession= sqlSessionFactory.openSession();
        //100002,'�����ֻ�','��ֿ���˦��',288.8,1200,1
        Product product=new Product();
        product.setId(31);//��������
        product.setSubtitle("���ӿ��ܵ��գ���΢�Ǽ�Ŷ");
        product.setPrice(688.8);
        Date date=new Date();
        product.setUpdate_time(date);
        sqlsession.update("ProductMapper.updateProductById", product);
        sqlsession.commit();
        sqlsession.close();
	}
}
