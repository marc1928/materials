package com.materiaux_tech.authentification.mapper;

import com.materiaux_tech.authentification.entity.Privilege;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface PrivilegeMapper {

    //obtenir une instance de PrivilegeMapper sans utiliser l'injection Spring.
    PrivilegeMapper INSTANCE = Mappers.getMapper(PrivilegeMapper.class);

    // convertir un privilege en un un privilegeDTO
    PrivilegeDTO privilegeToPrivilegeDTO(Privilege privilege);

    // convertir un privilegeDTO en un privilege
    Privilege privilegeDTOToPrivilege(PrivilegeDTO privilegeDTO);

    // convertir un set de privilege en un privilegeDTO
    Set<PrivilegeDTO> privilegesToPrivilegeDTO(Set<Privilege> privileges);

    // convertir un set de privilege en privilegeDTO
    Set<Privilege> privilegeDTOToPrivilege(Set<PrivilegeDTO> privilegeDTOS);
}
