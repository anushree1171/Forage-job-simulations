package com.au.telstra.simCardActivator.dao;

import com.au.telstra.simCardActivator.entity.Actuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuationDao extends JpaRepository<Actuation, Integer> {
}
