package com.simpleblog.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpleblog.dao.BlogDao;
import com.simpleblog.dao.MessageDao;

import java.util.List;
import java.util.Map;

/**
 * Index控制器
 * @author luoxn28
 * @date 2016.6.18
 */
@Controller
@RequestMapping
public class Index {

    // blog表操作类
    @Autowired
    private BlogDao blogDao;

    // Message表操作类
    @Autowired
    private MessageDao messageDao;

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        List<com.simpleblog.dao.Blog> blogs = blogDao.getAll();
        List<com.simpleblog.dao.Message> messages = messageDao.getAll();

        map.put("blogs", blogs);
        map.put("messages", messages);
        return "index";
    }
    
    @RequestMapping("/postget")
    public String post(){
    	return "post";
    }
    
    @RequestMapping("/")
    public String index0(Map<String, Object> map) {
        return index(map);
    }

    
    
}
