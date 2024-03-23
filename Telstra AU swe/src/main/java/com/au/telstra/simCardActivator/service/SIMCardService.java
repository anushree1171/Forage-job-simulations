package com.au.telstra.simCardActivator.service;


import com.au.telstra.simCardActivator.entity.SIMCard;

import java.util.List;

public interface SIMCardService {

    public void saveSimCard(SIMCard sim);

    public SIMCard getSimById(int id);

    public List<SIMCard> getAllSims();

    public void updateSim(SIMCard sim);

    public void deleteSim(int id);

    public void postToActivate(SIMCard simCard);
}
