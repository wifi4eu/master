package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document, Long> {

	Document findByAresReference(String aresReference);

	Document findByPortalId(Long portalId);

	List<Document> findByTypeAndWfStatus(DocumentType grantAgreement, DocumentWorkflowStatus waitingCountersignature);

	Document findByLegalEntityIdAndType(Long legalEntityId, DocumentType documentType);

	List<Document> findByWfStatusOrderByDateCreated(DocumentWorkflowStatus status, Pageable pageable);
}
