package com.au.telstra.simCardActivator.dao;

import com.au.telstra.simCardActivator.entity.SIMCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SIMCardDao extends JpaRepository<SIMCard, Integer> {
}
