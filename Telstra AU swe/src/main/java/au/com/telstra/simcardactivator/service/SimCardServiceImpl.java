package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.dao.SimDao;
import au.com.telstra.simcardactivator.entity.SIMCardDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimCardServiceImpl implements SimCardService{

    @Autowired
    SimDao simDao;
    @Override
    public SIMCardDetailsRequest getSimCardDetails(int id) {
        return simDao.getReferenceById(id);
    }
}
