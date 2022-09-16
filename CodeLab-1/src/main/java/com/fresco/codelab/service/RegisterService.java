package com.fresco.codelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.codelab.model.CodeLabUser;
import com.fresco.codelab.repo.CodeLabRepoVersionRepository;
import com.fresco.codelab.repo.CodeLabUserRepository;
@Service
public class RegisterService {
  @Autowired
  CodeLabUserRepository em;
  
	public Long registerUser(String fullname, String username, String password) {
    CodeLabUser c=new CodeLabUser();
    c.setFullname(fullname);
    c.setUsername(username);
    c.setPassword(password);
    
    em.save(c);

    CodeLabUser curr=em.findByFullnameAndUsername(fullname,username);
 System.err.println(curr.getUserAutoGenId());
  return curr.getUserAutoGenId();
    //return curr.getUserAutoGenId();
	}

}
