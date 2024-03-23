package au.com.telstra.simcardactivator.dao;


import au.com.telstra.simcardactivator.entity.SIMCardDetailsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimDao extends JpaRepository<SIMCardDetailsRequest, Integer> {
}
