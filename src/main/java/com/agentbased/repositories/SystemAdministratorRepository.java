package com.agentbased.repositories;

import com.agentbased.model.SystemAdministrator;
import com.agentbased.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAdministratorRepository extends JpaRepository<SystemAdministrator, Long> {
//    SystemAdministrator findByUser(UserEntity userEntity);
}

