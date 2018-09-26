package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.municipality.MunicipalitiesAbac;

public interface MunicipalitiesAbacRepository extends JpaRepository<MunicipalitiesAbac, Integer> {

    @Query("SELECT ma.abacReference FROM MunicipalitiesAbac ma WHERE ma.municipality =:municipalityId")
    String getAbacReferenceByMunicipalityId(@Param("municipalityId") Integer municipalityId);

}
