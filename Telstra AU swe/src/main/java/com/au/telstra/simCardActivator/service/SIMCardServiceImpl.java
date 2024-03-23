package com.au.telstra.simCardActivator.service;

import com.au.telstra.simCardActivator.dao.SIMCardDao;
import com.au.telstra.simCardActivator.entity.SIMCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SIMCardServiceImpl implements SIMCardService {

    @Autowired
    SIMCardDao simCardDao;

    RestTemplate restTemplate = new RestTemplate();

    //private String activationUrl = "http://localhost:8444/activate/";
    private String activationUrl = "http://localhost:8080/activate/";

    @Override
    public void postToActivate(SIMCard simCard){
        ResponseEntity<String> response = restTemplate.postForEntity(activationUrl, simCard, String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
    }

    @Override
    public void saveSimCard(SIMCard sim) {
        simCardDao.save(sim);
    }

    @Override
    public SIMCard getSimById(int id) {
        return simCardDao.getReferenceById(id);
    }

    @Override
    public List<SIMCard> getAllSims() {
        return simCardDao.findAll();
    }

    @Override
    public void updateSim(SIMCard sim) {
        simCardDao.save(sim);
    }

    @Override
    public void deleteSim(int id) {
        simCardDao.deleteById(id);
    }


}
