package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.location.Nuts;

public interface NutsRepository extends CrudRepository<Nuts, Integer> {

    Iterable<Nuts> getNutsByCountryCodeAndLevelOrderByLabelAsc(String countryCode, Integer level);
}