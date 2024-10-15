package com.co.expertgroup.prueba_tecnica.auth.persistence.repository;

import com.co.expertgroup.prueba_tecnica.auth.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByRoleEnumIn(List<String> roleNames);
}
