package com.simpleblog.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpleblog.dao.Blog;
import com.simpleblog.dao.BlogDao;
import com.simpleblog.dao.Message;
import com.simpleblog.dao.MessageDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Message控制器，留言板功能
 * @author luoxn28
 * @date 2016.6.19
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    // blog表操作类
    @Autowired
    private BlogDao blogDao;

    // Message表操作类
    @Autowired
    private MessageDao messageDao;

    @RequestMapping
    public String index(com.simpleblog.dao.Message message, Map<String, Object> map) {
        //System.out.println(message);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());

        message.setDate(date);
        messageDao.insert(message);

        List<Blog> blogs = blogDao.getAll();
        List<Message> messages = messageDao.getAll();

        map.put("blogs", blogs);
        map.put("messages", messages);
        return "index";
    }
}
