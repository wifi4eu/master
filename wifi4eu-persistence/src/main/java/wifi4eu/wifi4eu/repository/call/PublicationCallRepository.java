package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.PublicationCall;

import java.util.Date;
import java.util.List;

/**
 * Created by rgarcita on 21/02/2017.
 */
public interface PublicationCallRepository extends CrudRepository<PublicationCall,Long>{
    List<PublicationCall> findByCallDateLessThanEqual(Date now);
    List<PublicationCall> findByClosingDateGreaterThanEqual(Date now);
}
