package wifi4eu.wifi4eu.repository.timeline;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.timeline.Timeline;

/**
 * Created by rgarcita on 02/03/2017.
 */
public interface TimelineRepository extends CrudRepository<Timeline, Long> {
}
