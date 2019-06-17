package com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductDaoImpl implements ProductDao{
	
	  // 需要向dao实现类中注入SqlSessionFactory
    // 这里通过构造方法注入
	private SqlSessionFactory SqlSessionFactory;

	public ProductDaoImpl(SqlSessionFactory sqlSessionFactory) {
		SqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public Product findpRoductById(int id) {
		// TODO Auto-generated method stub
		  SqlSession sqlsession=SqlSessionFactory.openSession();
	      Product product=sqlsession.selectOne("ProductMapper.findpRoductById", id);
	      sqlsession.close();
		  return product;
	}
	@Override
	public List<Product> findProductsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertProduct(Product product) {
		SqlSessionFactory.openSession();
	}
	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
	}
	@Override
	public void updateProductById(Product product) {
		// TODO Auto-generated method stub
		
		
		
	}

	

}
