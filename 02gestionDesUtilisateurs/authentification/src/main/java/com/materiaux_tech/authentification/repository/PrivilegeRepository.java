package com.materiaux_tech.authentification.repository;

import com.materiaux_tech.authentification.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    // Rechercher un privilege par son nom
    Optional<Privilege> findByName(String name);

    // Vérifier si un privilege existe à partir de son nom
    boolean existsByName(String name);
}
