/**
 * 
 */
package com.uesocc.admin.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author xtiyo
 *
 */
@Table(name = "user",catalog = "test", schema = "public")
@Entity
@XmlRootElement
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_user", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codUser;
	@Column(name = "user_name", nullable = false, length = 20)
	private String name;
	@Column(name = "user_lastname", nullable = false, length = 20)
	private String lastname;
	/**
	 * @return the codUser
	 */
	public Integer getCodUser() {
		return codUser;
	}
	/**
	 * @param codUser the codUser to set
	 */
	public void setCodUser(Integer codUser) {
		this.codUser = codUser;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
