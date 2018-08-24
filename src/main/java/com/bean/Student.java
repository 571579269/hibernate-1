package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 	Serializable接口作用：一个对象序列化的接口，一个类只有实现了Serializable接口，它的对象才能被序列化
 *	序列化：  将对象的状态信息转换为可以存储或传输的形式的过程，在序列化期间，对象将其当前状态写入到临时存储区或持久性存储区，之后，便可以通过从存储区中读取或反序列化对象的状态信息，来重新创建该对象
 *	当我们需要把对象的状态信息通过网络进行传输，或者需要将对象的状态信息持久化，以便将来使用时都需要把对象进行序列化
 *	
 */
@Entity
@Table
public class Student implements Serializable{
	private static final long serialVersionUID = 8021925565032055905L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/* 	JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO. 
	TABLE：使用一个特定的数据库表格来保存主键。 
	SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。 
	IDENTITY：主键由数据库自动生成（主要是自动增长型） 
	AUTO：主键由程序控制。 
 */
	private Integer id;
	@Column
	private String name;
	@Column
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
}
