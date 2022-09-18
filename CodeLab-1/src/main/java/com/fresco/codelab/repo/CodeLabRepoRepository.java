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
  CodeLabRepo findByRepoAutoGenIdAndRepoOwnerId(long l, long m);
  CodeLabRepo findByrepoAutoGenId(long l);

 List< CodeLabRepo> findByrepoOwnerId(Long repoId);
 @Query("select c from CodeLabRepo c")
  List<CodeLabRepo> findallList();
// @Query("SELECT c.id_user from code_labuser c where c.id_repo=?1")
//List<Long> findRepoDevelopers(long id_repo);
//List<CodeLabUser> findRepoDevelopers();
// @Query("select c from CodeLabRepo c,code_labuser t where t.id_repo=?1")
// List<CodeLabRepo> fromtable(long Id);
  List<CodeLabRepo> findAllByRepoDevelopers(CodeLabUser user);
}
