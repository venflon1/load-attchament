package it.enterprise.foundation.attchment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ATTCHMENT")
public class Attchment implements Serializable{

	private static final long serialVersionUID = 3549969208637119792L;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="content")
	@Lob
	private String content;

	@ManyToOne
	private User user;
	
	public Attchment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Attchment [id=" + id + ", content=" + content + "]";
	}
}