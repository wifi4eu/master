package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.DocumentTypeMetadataType;

import java.util.List;

public interface DocumentTypeMetadataRepository extends CrudRepository<DocumentTypeMetadataType, Long> {

    List<DocumentTypeMetadataType> findDocumentTypeMetadataTypeByCcm2DocTypeId(Long ccm2DoctypeId);

    DocumentTypeMetadataType findFirstByCcm2MetadataKey(String key);

}
