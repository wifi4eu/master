package jgate;


public interface JaGateService {
	LegalEntityStatus getLegalEntityStatusByPic(String pic) throws Exception;
	LegalEntityStatus getLegalEntityStatusByFel(String fel) throws Exception;
}
