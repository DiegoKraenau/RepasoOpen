package edu.Examen.ExamenApp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="joke")
public class Joke implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="content",nullable=false)
	private String content;
	
	@Temporal(TemporalType.DATE)
	@Column(name="contenAt",nullable=false)
	private Date contentAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getContentAt() {
		return contentAt;
	}

	public void setContentAt(Date contentAt) {
		this.contentAt = contentAt;
	}
	
	
	
}
