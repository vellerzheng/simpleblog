package com.simpleblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Message表操作接口
 * @author luoxn28
 * @date 2016.6.19
 */
@Repository
public class MessageDao {

	@Autowired
	HibernateTemplate ht;
	
    public void insert(Message message){
    	ht.save(message);
    }

//    public int update(Message message);
//
//    public int delete(int id);
//
//    public Message getById(int id);
//
//    public Message getByAuthor(String author);

    public List<Message> getAll(){
    	String hql = "from Message";
		List<Message> messagelist = ht.find(hql);
		return messagelist;
    }
}
