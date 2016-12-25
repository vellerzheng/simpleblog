package com.simpleblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Blog表操作接口
 * @author luoxn28
 * @date 2016.6.18
 */
@Repository
public class BlogDao {

//    public int insert(Blog blog);
//
//    public int update(Blog blog);
//
//    public int delete(int id);
//
//    public Blog getById(int id);
//
//    public Blog getByTitle(String title);
//
//    public List<Blog> getByCategory(String category);
//
//    public List<Blog> getAll();
	
	@Autowired
	HibernateTemplate ht;
	
	public void insert(Blog blog){
		ht.save(blog);
	}
	
	public void update(Blog blog){
		ht.update(blog);
	}
	
	public void delete(Blog blog){
		ht.delete(blog);
	}
	
	public Blog getById(int id){
		String hql = "from Blog b where b.id = ?";
		List<Blog> bloglist = ht.find(hql, id);
		if(bloglist.size()==0){
			return null;
		} else {
			return bloglist.get(0);
		}
		
	}
	
	public Blog getByTitle(String title){
		String hql = "from Blog b where b.title = ?";
		List<Blog> bloglist = ht.find(hql, title);
		if(bloglist.size()==0){
			return null;
		} else {
			return bloglist.get(0);
		}
		
	}
	
	public List<Blog> getByCategory(String category){
		String hql = "from Blog b where b.category = ? ordered by id desc";
		List<Blog> bloglist = ht.find(hql, category);
		return bloglist;
	}
	
	public List<Blog> getAll(){
		String hql = "from Blog b order by b.id desc";
		List<Blog> bloglist = ht.find(hql);
		return bloglist;
	}
	
}
