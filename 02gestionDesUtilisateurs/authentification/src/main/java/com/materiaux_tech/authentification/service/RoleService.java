package com.materiaux_tech.authentification.service;

import java.util.Set;

public interface RoleService {

    // créer un nouveau role
    RoleDTO createRole(RoleDTO roleDTO);

    //Modifier un role
    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    // récupérer tous les roles
    Set<RoleDTO> getAllRole();

    // récupérer un seul role
    RoleDTO getRole(Long id);

    // supprimer un role
    void deleteRole(Long id);
}
