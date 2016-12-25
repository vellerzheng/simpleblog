package com.simpleblog.web;

import com.simpleblog.cons.CommonConstant;
import com.simpleblog.dao.Blog;
import com.simpleblog.dao.BlogDao;
import com.simpleblog.dao.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * post blog 控制器
 * @author luoxn28
 * @date 2016.6.18
 */
@Controller
@RequestMapping("/post")
public class Post {

    // blog 表操作类
    @Autowired
    private BlogDao blogDao = null;

    @RequestMapping
    public String handleRequest(HttpServletRequest request,
    		@RequestParam(value="editorTitle") String title,
                                @RequestParam(value="editorCategory") String category, 
                                @RequestParam(value="editorPreview") String preview,
                                @RequestParam(value="editorValue") String value, 
                                Map<String, Object> map) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
        String author = user.getUsername();
        Blog blog = new Blog(title, value, preview, author, category, date);

        //com.luoxn28.blog.dao.Blog hasBlog = blogDao.getByTitle(title);
        if (blogDao.getByTitle(title) == null) {
            blogDao.insert(blog);
            //blog = blogDao.getByTitle(title);
        }

        map.put("blog", blog);
        return "blog";
    }
}
