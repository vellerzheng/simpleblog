package com.simpleblog.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration
@Transactional
public class testblogdao {
	@Autowired
	private BlogDao blogDao;
	
	@Test
	public void testgetById(){
		Blog blog = blogDao.getById(2);
		System.out.println(blog.toString());
	}

}
