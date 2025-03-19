package com.materiaux_tech.authentification.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    // ajouter un utilisateur
    UserDTO createUser(UserDTO userDTO);

    // Modifier un utilisateur
    UserDTO updateUserDTO(Long id, UserDTO userDTO);

    // récupérer tous les utilisateurs
    List<UserDTO> getAllUsers();

    // récupérer un utilisateur
    Optional<UserDTO> getUserById(Long id);

    //supprimer un utilisateur
    void deleteUserById(Long id);
}
