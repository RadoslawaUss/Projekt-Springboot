package com.blackbeast.booklibrary.repository;

import com.blackbeast.booklibrary.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Transactional
    Role save(Role role);
}
