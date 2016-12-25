package com.simpleblog.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "user")
public class User  {
    /**
     *锁定用户对应的状态�?? 
     */
    public static final int USER_LOCK = 1;
    /**
     * 用户解锁对应的状态�??
     */
    public static final int USER_UNLOCK = 0;
    /**
     * 管理员类�?
     */
    public static final int FORUM_ADMIN = 2;
    /**
     * 普�?�用户类�?
     */
    public static final int NORMAL_USER = 1;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;

    @Column(name = "username")
	private String username;
    
    @Column(name = "password")
	private String password;

    
    @Column(name = "last_ip")
	private String lastip;
	
	@Column(name = "last_visit")
	private Date lastvisit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastip() {
		return lastip;
	}

	public void setLastip(String lastip) {
		this.lastip = lastip;
	}

	public Date getLastvisit() {
		return lastvisit;
	}

	public void setLastvisit(Date lastvisit) {
		this.lastvisit = lastvisit;
	}
	
	
    





}
