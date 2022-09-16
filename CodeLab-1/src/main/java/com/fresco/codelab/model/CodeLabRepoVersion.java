package com.fresco.codelab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="codelabrepoversion")
public class CodeLabRepoVersion {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column(name="idrepoversion")
  private Integer id;
  @Column(name="version")
  private Integer version;
  @Column(name="versionownerid")
  private Long versionOwnerId;
  @Column(name="ismaster")
  private Boolean isMaster;
  @Column(name="ismrpending")
  private Boolean isMrPending;
  
  @ManyToOne
  private CodeLabRepo repo;
	public CodeLabRepoVersion() {
		super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Long getVersionOwnerId() {
    return versionOwnerId;
  }

  public void setVersionOwnerId(Long versionOwnerId) {
    this.versionOwnerId = versionOwnerId;
  }

  public Boolean getIsMaster() {
    return isMaster;
  }

  public void setIsMaster(Boolean isMaster) {
    this.isMaster = isMaster;
  }

  public Boolean getIsMrPending() {
    return isMrPending;
  }

  public void setIsMrPending(Boolean isMrPending) {
    this.isMrPending = isMrPending;
  }

  public CodeLabRepo getRepo() {
    return repo;
  }

  public void setRepo(CodeLabRepo repo) {
    this.repo = repo;
  }

  
  
  
}
