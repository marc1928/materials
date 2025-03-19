package com.materiaux_tech.authentification.dto;

import java.util.Set;

public record RoleDTO(
        Long id,
        String name,
        Set<PrivilegeDTO> privileges
) {
}
