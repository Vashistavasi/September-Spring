package com.fresco.codelab.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="codelabuser")

public class CodeLabUser {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="iduser")
  private Long userAutoGenId;
  
	@Override
public String toString() {
	return "[userAutoGenId=" + userAutoGenId + ", fullname=" + fullname + ", username=" + username
			+ ", password=" + password + "]";
}

	private String fullname;
	private String username;
  private String password;
  @ManyToMany(mappedBy = "repoDevelopers", cascade = { CascadeType.ALL })
  private List<CodeLabRepo> repos=new ArrayList<>();
	public CodeLabUser() {
		super();
  }

  public Long getUserAutoGenId() {
    return userAutoGenId;
  }

  public void setUserAutoGenId(Long userAutoGenId) {
    this.userAutoGenId = userAutoGenId;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
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

public List<CodeLabRepo> getRepos() {
	return repos;
}

public void setRepos(List<CodeLabRepo> repos) {
	this.repos = repos;
}

  
  
  
  
	// public Long getUserAutoGenId() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public Object getFullname() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public Object getUsername() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public Object getPassword() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public Object getVersionOwnerId() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public Object getId() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public CodeLabRepo getRepo() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
}
