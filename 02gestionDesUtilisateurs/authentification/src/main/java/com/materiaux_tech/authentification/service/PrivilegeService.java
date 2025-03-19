package com.materiaux_tech.authentification.service;

import java.util.Optional;

public interface PrivilegeService {

    PrivilegeDTO creatPrivilege(PrivilegeDTO privilegeDTO);

    Optional<PrivilegeDTO> updatePrivilege(Long id, PrivilegeDTO privilegeDTO);
}
