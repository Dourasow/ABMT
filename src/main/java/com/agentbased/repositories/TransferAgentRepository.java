package com.agentbased.repositories;

import com.agentbased.model.TransferAgent;
import com.agentbased.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferAgentRepository extends JpaRepository<TransferAgent, Long> {

//    TransferAgent findByUser(UserEntity userEntity);
}

