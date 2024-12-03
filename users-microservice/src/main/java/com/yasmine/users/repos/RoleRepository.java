package com.yasmine.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasmine.users.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);

}
