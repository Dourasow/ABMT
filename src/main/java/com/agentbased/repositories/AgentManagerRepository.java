package com.agentbased.repositories;

import com.agentbased.model.AgentManager;
import com.agentbased.model.TransferAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentManagerRepository extends JpaRepository<AgentManager, Long> {
    List<AgentManager> findByTransferAgent(TransferAgent transferAgent);
}

