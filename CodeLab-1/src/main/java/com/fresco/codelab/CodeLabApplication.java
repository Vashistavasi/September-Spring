package com.fresco.codelab;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fresco.codelab.model.CodeLabRepo;
import com.fresco.codelab.model.CodeLabUser;
import com.fresco.codelab.repo.CodeLabRepoRepository;
import com.fresco.codelab.repo.CodeLabUserRepository;
import com.fresco.codelab.service.DashboardService;
import com.fresco.codelab.service.RegisterService;

@SpringBootApplication
@Transactional
public class CodeLabApplication implements CommandLineRunner{
    @Autowired
    DashboardService ds;
    @Autowired
    RegisterService rs;
    @Autowired
    CodeLabUserRepository emUser;
    @Autowired
    CodeLabRepoRepository emRepo;
	public static void main(String[] args) {
		SpringApplication.run(CodeLabApplication.class, args);
	}
	public String generateString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz"; 
		StringBuilder sb = new StringBuilder(5); 
		for (int i = 0; i < 5; i++) { 
			int index = (int)(AlphaNumericString.length() * Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		}
		return sb.toString(); 
	}
	static String name, pass, repoName, user2, pass2;
	static Long userId, repoId, userId2;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
  // Test 1
//		name = generateString();
//		pass = generateString();
//		rs.registerUser(name, name + "@gmail.com", pass);
//		List<CodeLabUser> users = emUser.findAll();
//		
//		userId = users.get(0).getUserAutoGenId();
//		System.err.println(userId+" userId");
//		System.err.println(users);
//		
//	//Test 2
//		repoName = generateString();
//		ds.saveRepo(repoName, userId);
//		List<CodeLabRepo> repos = emRepo.findAll();
//		
//		repoId = repos.get(0).getRepoAutoGenId();
//		System.err.println(repoId+" repoId");
//		System.err.println(repos);
//		
//  //Test 3
//		List<CodeLabRepo> repos1 = ds.getUserOwnedRepos(userId);
//         System.err.println(repos1);
//		System.out.println(" running test 3");
//  //Test 4
//		CodeLabRepo repo = ds.getRepoWithRepoIdAndOwnerId(repoId, userId);
//		System.err.println(repo);
// //Test 5
//		user2 = generateString();
//		pass2 = generateString();
//		userId2 = rs.registerUser(user2, user2 + "@gmail.com", pass2);
//		System.err.println(userId2+" userID2");
//		ds.addRepoToUserName(emRepo.findById(repoId).get(), user2 + "@gmail.com", userId);
//		Set<CodeLabRepo> repos2 = ds.getUserDeveloperRepos(userId2);
//		System.err.println("What is this happening "+repos2.size());
//		System.err.println(repos2);
//		
//		
//		//Test 6
//		
//		CodeLabRepo repo23 = ds.getRepoWithRepoIdAndDeveloperId(repoId, userId2);
////		assertEquals(repo.getRepoName(), repoName);
////		assertEquals(repo.getRepoAutoGenId(), repoId);
//		System.err.println(repo23+ " repo 23");
//		if(repo23!=null) {
//			List<CodeLabUser> users23 = repo23.getRepoDevelopers();
//			System.err.println(users23+" users23");
//		}
//		System.err.println(repoId+" "+ userId2);
//		assertEquals(users.size(), 1);
//		assertEquals(users.get(0).getUserAutoGenId(), userId2);
//		
//		
//		//mYtest
//		System.err.println("this"+emRepo.findAllByRepoDevelopers(emUser.findByuserAutoGenId(userId2)));
//		
		
		//assertEquals(repos.size(), 1);
//		for(CodeLabRepo repo : repos) {
//			assertEquals(repo.getRepoName(), repoName);
//			assertEquals(repo.getRepoAutoGenId(), repoId);
//		}
		
//		ArrayList<CodeLabUser> al=new ArrayList<>();
//		CodeLabRepo cr=new CodeLabRepo();
//		cr.setRepoName("Repo1");
//		cr.setRepoOwnerId(1l);
//		String name="Vashista";
//		String fullName="Basava Vashista";
//		String pass="springit";
//		CodeLabUser c=new CodeLabUser();
//		c.setFullname(fullName);
//		c.setUsername(name);
//		c.setPassword(pass);
//		CodeLabUser d=new CodeLabUser();
//		d.setFullname("Sriniketh");
//		d.setFullname("k.sriniketh");
//		d.setPassword("Hello:");
//		al.add(d);
//		al.add(c);
//		CodeLabUser e=new CodeLabUser();
//		e.setFullname("Elon Musk");
//		e.setUsername("elon");
//		e.setPassword("Mars");
//		
//		rs.registerUser("Elon Musk", "Elon", "Mars");
//		rs.registerUser("Vara Lakshmi", "Vara", "pass");
//		cr.setRepoDevelopers(al);
//		
//		
//		emRepo.save(cr);
//		
//		System.err.println("Method 1 done");
//		//second method
//		Optional<List<CodeLabUser>> all=Optional.ofNullable(emUser.findAll());
//		if(!all.isEmpty()) {
//			System.err.println(all.get());
//		}
//		else {
//			System.err.println("didn't");
//		}
//		Optional<CodeLabUser> clu=Optional.ofNullable(emUser.findByFullnameAndUsername("Elon Musk", "Elon"));
//		if(!clu.isEmpty()) {
//			ds.saveRepo("Spring Application", clu.get().getUserAutoGenId());
//			System.err.println("Executed");
//		}
//		else {
//			System.err.println("Not Executed");
//		}
//		
//		System.err.println("Method 2 done");
//		//Method 3
//		Optional<CodeLabUser> user=Optional.ofNullable(emUser.findByUsername("Vashista"));
//		if(!user.isEmpty()) {
//			System.err.println("check check"+ds.getUserOwnedRepos(user.get().getUserAutoGenId()));
//			System.err.println(user.get());
//		}
//		else {
//			System.err.println("Not found user method 3");
//		}
//		System.err.println("Method 3 done");
//		
//		
//		
//		
//		//Method 4
//		CodeLabRepo clr=new CodeLabRepo();
//		clr.setRepoName("My Project: September:");
//		clr.setRepoOwnerId(user.get().getUserAutoGenId());
//		emRepo.save(clr);
//		System.err.println("saved the new repo : with as develoer "+user.get() );
//		long repoId=ds.getUserOwnedRepos(user.get().getUserAutoGenId()).get(0).getRepoAutoGenId();
//		Long ownerId=ds.getUserOwnedRepos(user.get().getUserAutoGenId()).get(0).getRepoOwnerId();
//		
//		System.err.println(ds.getRepoWithRepoIdAndOwnerId(repoId, ownerId));
//		System.err.println("Method 4 done");
//		
//		//Method 5
//		ds.addRepoToUserName(ds.getRepoWithRepoIdAndOwnerId(repoId, ownerId), "Elon", ownerId);
//		CodeLabUser curr=emUser.findByUsername("Vara");
//		ds.addRepoToUserName(ds.getRepoWithRepoIdAndDeveloperId(repoId, ownerId),"Vara", ownerId);
//		System.err.println("Method 5 done");
//		//Method 6
//		CodeLabUser elon=emUser.findByUsername("Elon");
//		System.err.println(ds.getUserDeveloperRepos(elon.getUserAutoGenId())+" Executed");
//		System.err.println("Method 6 done");
//		//Method 7
//		System.err.println("Method 7");
//		System.err.println(ds.getRepoWithRepoIdAndDeveloperId(repoId,ownerId));
//		System.err.println("Method 7 done");
//		//Method 8
//		System.err.println("Method 8");
//		System.err.println(ds.uploadCode(ownerId, repoId));
//		System.err.println("Method 8 done");
//		//Method 9
//		
//		//Method 10
//		System.err.println("Method 10");
//		System.err.println(ds.getAllUsersExcept(ownerId));
//		System.err.println("Method 10 done");
		        
		        
		        
		        
	}             

}

