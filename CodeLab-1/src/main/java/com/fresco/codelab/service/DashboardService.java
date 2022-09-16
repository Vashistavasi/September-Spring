package com.fresco.codelab.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.codelab.model.CodeLabRepo;
import com.fresco.codelab.model.CodeLabRepoVersion;
import com.fresco.codelab.model.CodeLabUser;
import com.fresco.codelab.repo.CodeLabRepoRepository;
import com.fresco.codelab.repo.CodeLabRepoVersionRepository;
import com.fresco.codelab.repo.CodeLabUserRepository;

@Service
public class DashboardService {
  @Autowired
  CodeLabRepoRepository emRepo;
  @Autowired
  CodeLabUserRepository emUser;
  @Autowired
  CodeLabRepoVersionRepository emRepoVersion;
	public Long saveRepo(String repo_name, Long userId) {
    CodeLabRepo c=new CodeLabRepo();
    c.setRepoName(repo_name);
    c.setRepoOwnerId(userId);
    emRepo.save(c);
    CodeLabRepo c1=emRepo.findByrepoName(repo_name);    
    System.err.println(c1.getRepoAutoGenId());
		return c1.getRepoAutoGenId();
	}
	
	public List<CodeLabRepo> getUserOwnedRepos(Long userId) {
      
		//CodeLabUser user=emUser.findByuserAutoGenId(userId);
		System.err.println(" the user id is "+ userId);
		List<CodeLabRepo> ans=emRepo.findByrepoOwnerId(userId);
		System.out.println(emRepo.findallList());
		System.out.println(ans);
		return ans;
		
		
		
	}

	public CodeLabRepo getRepoWithRepoIdAndOwnerId(Long repoId, Long userId) {
    return emRepo.findByrepoAutoGenIdAndRepoOwnerId(repoId,userId);
		
	}
	
	public void addRepoToUserName(CodeLabRepo repo, String username, Long ownerId) {
  CodeLabRepo c=emRepo.findByrepoAutoGenIdAndRepoOwnerId(repo.getRepoAutoGenId(),ownerId);
  List<CodeLabUser> a=c.getRepoDevelopers();
  
  Optional<CodeLabUser> u=Optional.ofNullable(emUser.findByUsername(username));
  if(!u.isEmpty()) {
  a.add(u.get());
  c.setRepoDevelopers(a);
  emRepo.save(c);
  System.err.println("Executed Method 5 void add");
  }
  }
	
	public Set<CodeLabRepo> getUserDeveloperRepos(Long userId) {
    CodeLabUser c=emUser.findByuserAutoGenId(userId);
  List<CodeLabRepo> a=c.getRepos();
  Set<CodeLabRepo> s=new HashSet<CodeLabRepo>();
  for(CodeLabRepo i: a)
  s.add(i);
  return s;
	}

	public CodeLabRepo getRepoWithRepoIdAndDeveloperId(Long repoId, Long userId) {
    CodeLabRepo c=emRepo.findByrepoAutoGenIdAndRepoOwnerId(repoId,userId);
    return c;
	}

	public Integer uploadCode(Long userId, Long repoId) {
     Optional<CodeLabRepo> curr=Optional.ofNullable(emRepo.findByrepoAutoGenIdAndRepoOwnerId(repoId, userId));
     int ans=0;
     if(!curr.isEmpty()) {
    	 CodeLabRepoVersion cv=new CodeLabRepoVersion();
    	 List<CodeLabRepoVersion> l=curr.get().getVersions();
    	 int size=l.size();
    	 cv.setVersion(size+1);
    	 cv.setVersionOwnerId(userId);
    	 l.add(cv);
    	 curr.get().setVersions(l);
    	 ans=size+1;
    	 emRepo.save(curr.get());
     }
   return ans+1;
	}
	
	public CodeLabRepo getRepoWithRepoIdAndUserIdAndVersionId(Long repoId, Long userId, Integer version) {
		
		
		return new CodeLabRepo();
	}

	public List<CodeLabUser> getAllUsersExcept(Long userId) {
		List<CodeLabUser> al=emUser.findAll();
		return al.stream().filter(x->x.getUserAutoGenId()!=userId).collect(Collectors.toList());
	}
	
	
	public CodeLabUser findUser(String s) {
		return emUser.findByUsername(s);
	}
	
}
