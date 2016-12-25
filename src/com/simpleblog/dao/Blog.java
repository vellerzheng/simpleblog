package com.simpleblog.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Blog类，对应blog表
 * @author luoxn28
 * @date 2016.6.18
 */
@Entity
@Table(name = "blog")
public class Blog {
	@Id
    @Column(name = "id")
    private int id;         // blog主键id
	
	@Column(name = "title")
    private String title;   // blog标题
	
	@Column(name = "text")
    private String text;    // blog内容
	
	@Column(name = "preview")
    private String preview; // blog简介
	
	@Column(name = "author")
    private String author;  // blog作者
	
	@Column(name = "category")
    private String category;// blog种类
	
	@Column(name = "date")
    private String date;    // blog写作日期

    public Blog() {
    }

    public Blog(String title, String text, String preview, String author, String category, String date) {
        this.title = title;
        this.text = text;
        this.preview = preview;
        this.author = author;
        this.category = category;
        this.date = date;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", preview='" + preview + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
