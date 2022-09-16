package com.fresco.codelab.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fresco.codelab.model.CodeLabRepo;
import com.fresco.codelab.model.CodeLabUser;
@Repository
public interface CodeLabRepoRepository  extends JpaRepository<CodeLabRepo, Long>{

  CodeLabRepo findByrepoName(String s);
  CodeLabRepo findByrepoAutoGenIdAndRepoOwnerId(long l, long m);
  CodeLabRepo findByrepoAutoGenId(long l);
  CodeLabRepo findByrepoAutoGenIdAndRepoOwnerId(Long repoId, Long userId);
 List< CodeLabRepo> findByrepoOwnerId(Long repoId);
 @Query("select c from CodeLabRepo c")
  List<CodeLabRepo> findallList();
  
  
}
