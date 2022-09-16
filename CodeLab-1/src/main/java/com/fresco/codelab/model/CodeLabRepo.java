package com.fresco.codelab.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="codelabrepo")
public class CodeLabRepo {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="idrepo")
  private Long repoAutoGenId;
  @Column(name="reponame")
  private String repoName;
  @Column(name="repoownerid")
  private Long repoOwnerId;
 @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="repo_id")
  List<CodeLabRepoVersion> versions=new ArrayList<>();
  @ManyToMany(targetEntity = CodeLabUser.class, cascade = { CascadeType.ALL })
  @JoinTable(name="code_labuser",joinColumns={@JoinColumn(name="id_repo")},
  inverseJoinColumns={@JoinColumn(name="id_user")})
  private List<CodeLabUser> repoDevelopers=new ArrayList<>();
	public CodeLabRepo() {
		super();
  }

  public Long getRepoAutoGenId() {
    return repoAutoGenId;
  }

  public void setRepoAutoGenId(Long repoAutoGenId) {
    this.repoAutoGenId = repoAutoGenId;
  }

  public String getRepoName() {
    return repoName;
  }

  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }

  public Long getRepoOwnerId() {
    return repoOwnerId;
  }

  public void setRepoOwnerId(Long repoOwnerId) {
    this.repoOwnerId = repoOwnerId;
  }

  public List<CodeLabRepoVersion> getVersions() {
    return versions;
  }

  public void setVersions(List<CodeLabRepoVersion> versions) {
    this.versions = versions;
  }

  public List<CodeLabUser> getRepoDevelopers() {
    return repoDevelopers;
  }

  public void setRepoDevelopers(List<CodeLabUser> repoDevelopers) {
    this.repoDevelopers = repoDevelopers;
  }

@Override
public String toString() {
	return "CodeLabRepo [repoAutoGenId=" + repoAutoGenId + ", repoName=" + repoName + ", repoOwnerId=" + repoOwnerId
			+ "]";
}

  
  
  
	// public Long getRepoAutoGenId() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public Object getRepoName() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public List<CodeLabUser> getRepoDevelopers() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
	// public List<CodeLabUser> getVersions() {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
}
