package com.fresco.codelab.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresco.codelab.model.CodeLabRepo;
import com.fresco.codelab.model.CodeLabUser;

@Repository
public interface CodeLabUserRepository extends JpaRepository<CodeLabUser, Long>{

  CodeLabUser findByFullnameAndUsername(String name,String k);
  CodeLabUser findByuserAutoGenId(Long id);
  CodeLabUser findByUsername(String name);
List<CodeLabUser> findAllByRepos(CodeLabRepo repo);
}
