package com.materiaux_tech.authentification.mapper;

import com.materiaux_tech.authentification.entity.Privilege;
import com.materiaux_tech.authentification.entity.Role;
import com.materiaux_tech.authentification.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    PrivilegeMapper INSTANCE = Mappers.getMapper(PrivilegeMapper.class);

    // convertit un User en UserDTO
    @Mapping(source = "roles", target = "roles")
    UserDTO userToUserDTO(User user);

    //convertit un set de Role en set de roleDTO
    Set<RoleDTO> roleToRoleDTO(Set<Role> role);

    // convertit un set de privilege en privilegeDTO
    Set<PrivilegeDTO> privilegeToPrivilegeDTO(Set<Privilege> privilege);
}
