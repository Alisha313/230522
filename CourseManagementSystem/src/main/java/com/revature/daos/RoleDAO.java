package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {

    Role getByName(String name);
}

