package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.entity.SIMCardDetailsRequest;

public interface SimCardService {

    public SIMCardDetailsRequest getSimCardDetails(int id);
}
