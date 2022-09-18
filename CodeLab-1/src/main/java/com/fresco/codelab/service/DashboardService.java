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
    return emRepo.findByRepoAutoGenIdAndRepoOwnerId(repoId,userId);
		
	}
	
	public void addRepoToUserName(CodeLabRepo repo, String username, Long ownerId) {
   
  
    List<CodeLabUser> developers=emUser.findAllByRepos(repo);
    developers.add(emUser.findByUsername(username));
    repo.setRepoDevelopers(developers);
    emRepo.save(repo);
//  Optional<CodeLabUser> u=Optional.ofNullable(emUser.findByUsername(username));
//   if(u.isPresent())
//   {
//	   CodeLabUser user=u.get();
//	   
//	   List<CodeLabRepo> l=emRepo.findByrepoOwnerId(user.getUserAutoGenId());
//	   l.add(repo);
//	   user.setRepos(l);
//	   emUser.save(user);
////	   List<CodeLabUser> us=emUser.findByuserAutoGenId(user.getUserAutoGenId());
//	   
//   }
  }
	
	public Set<CodeLabRepo> getUserDeveloperRepos(Long userId) {
		 CodeLabUser user=emUser.findByuserAutoGenId(userId);
		  Set<CodeLabRepo> s=new HashSet<CodeLabRepo>();
		List<CodeLabRepo> repos=emRepo.findAllByRepoDevelopers(user);
		for(CodeLabRepo c:repos)
			s.add(c);
		
  return s;
	}

	public CodeLabRepo getRepoWithRepoIdAndDeveloperId(Long repoId, Long userId) {
		CodeLabRepo c= emRepo.findByrepoAutoGenId(repoId);
		CodeLabUser user=emUser.findByuserAutoGenId(userId);
		List<CodeLabUser> developers =emUser.findAllByRepos(c);
		for(int i=0;i<developers.size();i++) {
			if(developers.get(i).getUserAutoGenId()==userId)
				return c;
		}
			return null;
	}

	public Integer uploadCode(Long userId, Long repoId) {
     Optional<CodeLabRepo> curr=Optional.ofNullable(emRepo.findByRepoAutoGenIdAndRepoOwnerId(repoId, userId));
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
