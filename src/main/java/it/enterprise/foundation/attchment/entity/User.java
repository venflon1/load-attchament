package it.enterprise.foundation.attchment.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usr")
public class User implements Serializable{

	private static final long serialVersionUID = -1132816171777568798L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="code")
	private String code; // codice fiscale
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="born_date")
	private LocalDate bornDate;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private List<Attchment> listAttchments;

	public User() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getBornDate() {
		return bornDate;
	}



	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}



	public List<Attchment> getListAttchments() {
		return listAttchments;
	}



	public void setListAttchments(List<Attchment> listAttchments) {
		this.listAttchments = listAttchments;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", bornDate=" + bornDate + ", listAttchments=" + listAttchments + "]";
	}
}