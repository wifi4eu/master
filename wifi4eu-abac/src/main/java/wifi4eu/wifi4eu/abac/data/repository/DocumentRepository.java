package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.data.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

	Document findByAresReference(String aresReference);

}
