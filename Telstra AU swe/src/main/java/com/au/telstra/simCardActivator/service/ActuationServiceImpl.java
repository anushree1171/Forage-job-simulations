package com.au.telstra.simCardActivator.service;

import com.au.telstra.simCardActivator.dao.ActuationDao;
import com.au.telstra.simCardActivator.entity.Actuation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActuationServiceImpl implements ActuationService{

    @Autowired
    ActuationDao actuationDao;

    @Override
    public String saveActuation(Actuation ac) throws JsonProcessingException {
        if(ac.getIccid()!=null){
            ac.setSuccess(true);
            actuationDao.save(ac);
        }
        else{
            ac.setSuccess(false);
            actuationDao.save(ac);
        }

        ObjectMapper obj = new ObjectMapper();
        return obj.writeValueAsString(ac);
    }



}
