package com.thlaptrinhjava.Lab03.repository;


import com.thlaptrinhjava.Lab03.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {

    @Query("select r.id from Role r where r.name = ?1")
    Long getRoleIdByName(String roleName);



}
