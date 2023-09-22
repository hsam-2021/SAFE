package com.safe.hsap.safe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.safe.hsap.safe.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select a from Role a where a.name =:roleName")
	public Role findRoleName(@Param("roleName") String roleName);

	@Query("select count(*) from Role a where a.name =:roleName")
	public int roleExistExist(@Param("roleName") String roleName);

}
