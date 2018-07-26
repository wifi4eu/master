package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

	Document findByAresReference(String aresReference);

}
