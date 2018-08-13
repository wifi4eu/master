package wifi4eu.wifi4eu.abac.utils;

import eu.europa.ec.research.fp.model.code_ref.v3.CodeRefType;
import eu.europa.ec.research.fp.model.document.v5.AttachmentIdType;
import eu.europa.ec.research.fp.model.document.v5.BooleanType;
import eu.europa.ec.research.fp.model.document.v5.DateTimeType;
import eu.europa.ec.research.fp.model.document.v5.DocumentAttachmentRefType;
import eu.europa.ec.research.fp.model.document.v5.DocumentMetaDataType;
import eu.europa.ec.research.fp.model.document.v5.EntityType;
import eu.europa.ec.research.fp.model.document.v5.ExternaLEntityType;
import eu.europa.ec.research.fp.model.document.v5.ExternalPersonType;
import eu.europa.ec.research.fp.model.document.v5.InternalEntityType;
import eu.europa.ec.research.fp.model.document.v5.InternalOrganisationType;
import eu.europa.ec.research.fp.model.document.v5.LocalDocumentType;
import eu.europa.ec.research.fp.model.document.v5.MetaDataValueType;
import eu.europa.ec.research.fp.model.document.v5.PersonType;
import eu.europa.ec.research.fp.model.document.v5.RecipientType;
import eu.europa.ec.research.fp.model.document.v5.SenderType;
import eu.europa.ec.research.fp.model.document.v5.SendersRecipients;
import eu.europa.ec.research.fp.model.document.v5.StringType;
import eu.europa.ec.research.fp.model.document.v5.TransmitType;
import eu.europa.ec.research.fp.model.document_ref.v3.DocumentRefType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.CreateFileParamsType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.DocumentMetaDataListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.EditorListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.FileDocumentType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.LinkType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.ParentFileIdType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.ReaderListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.ServiceDocumentRefType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.UploadDocAttachmentType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.UserListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.VirtualAttachmentRefListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.VirtualAttachmentRefType;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.integration.eris.model.CreateAutomaticFileParams;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisClientParams;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisDocTypeEnum;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisMetadataParam;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ErisHelper {

	private static final Logger LOG = LoggerFactory.getLogger(ErisHelper.class);

    private static final String ERIS_FILE_PREFIX = "WIF-";
    private static final String ERIS_FILE_SUFFIX = "-ID";

	private static final String ATTACHMENTREF_SEPARATOR = ":";
	private static final int ATTACHMENTREF_SIZE = 2;

	private static final String DEFAULT_ATTACHMENT_CCM2 = "31047701";
	private static final String DEFAULT_ATTACHMENT_TYPE = "Generic";

	private static final String DEFAULT_MASTER = "HERMES";
	private static final String DEFAULT_KIND = "MAIN";
	private static final String DEFAULT_LANGUAGE = "EN";

	@Value("${integration.eris.servlet.url}")
	private String endpoint;

	@Value("${integration.eris.servlet.username}")
	private String username;

	@Value("${integration.eris.servlet.passwd}")
	private String password;

	@Value("${integration.eris.ws.ecas.enabled}")
	private boolean ecasAuthEnabled;

	@Value("${integration.eris.ws.system.id}")
	private String systemId;

	@Value("${integration.eris.ws.file.heading.limited}")
	private boolean headingLimited;

	@Value("${integration.eris.ws.file.heading.chefdefile}")
	private String chefDeFile;

	@Value("${integration.eris.ws.file.partition}")
	private Integer partitionId;

	@Value("${integration.eris.ws.recipients.code}")
	private String recipientCode;

	@Value("${integration.eris.ws.organisation.code}")
	private String organisationCode;

	@Value("${integration.eris.ws.file.filePlan}")
	private String filePlan;

	@Value("${integration.eris.ws.file.fileType}")
	private String fileType;

	@Value("${integration.eris.ws.subfile.limited}")
	private boolean subFileLimited;

	@Value("${integration.eris.ws.subfile.chefdefile}")
	private String subFileChefDeFile;

	@Value("${integration.eris.ws.subfile.activate}")
	private boolean subFileActivate;

	@Value("${integration.eris.ws.subfile.readers}")
	private String subFileReaders;

	@Value("${integration.eris.ws.subfile.users}")
	private String subFileUsers;

	@Value("${integration.eris.ws.subfile.editors}")
	private String subFileEditors;


	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEcasAuthEnabled() {
		return ecasAuthEnabled;
	}

	public void setEcasAuthEnabled(boolean ecasAuthEnabled) {
		this.ecasAuthEnabled = ecasAuthEnabled;
	}

	public CreateAutomaticFileParams buildCreateFileParams(String mid) {
		CreateAutomaticFileParams createFileParams = new CreateAutomaticFileParams();
		createFileParams.setFileTitle(ERIS_FILE_PREFIX + mid);
        createFileParams.setSpecificCode(ERIS_FILE_PREFIX + mid);
        createFileParams.setChefDeFile(chefDeFile);
        createFileParams.setFilePlan(filePlan);
        createFileParams.setFileType(fileType);
        return createFileParams;
    }

	public CreateFileParamsType buildCreatePersonalDataSubFileParams(String mid, String hermesFileId) {
		CreateFileParamsType createFileParams = new CreateFileParamsType();
		String specificCode = ERIS_FILE_PREFIX + mid + ERIS_FILE_SUFFIX;

		ParentFileIdType parentFileId = new ParentFileIdType();
		parentFileId.setValue(hermesFileId);
		createFileParams.setHeadingIdOrParentFileId(parentFileId);
		createFileParams.setEnglishName(specificCode);
		createFileParams.setLimited(subFileLimited);
		createFileParams.setSpecificCode(specificCode);
		createFileParams.setChefDeFile(chefDeFile);
		createFileParams.setActivate(subFileActivate);
		createFileParams.setReaders(getSubFileReaders());
		createFileParams.setUsers(getSubFileUsers());
		createFileParams.setEditors(getSubFileEditors());
		return createFileParams;
	}

	public UploadDocAttachmentType buildUploadDocAttachment(Document document, ErisClientParams params) {
        UploadDocAttachmentType uploadDocAttachment = new UploadDocAttachmentType();
        uploadDocAttachment.setAttachmentName(FilenameUtils.getBaseName(document.getFileName()));
        eu.europa.ec.research.fp.model.document_ref.v3.DocumentRefType documentRefType = new eu.europa.ec.research.fp.model.document_ref.v3.DocumentRefType();
        documentRefType.setMasterID(document.getHermesRef());
        uploadDocAttachment.setDocumentRef(documentRefType);

        uploadDocAttachment.setAttachmentType(buildAttachmentType(params));

        // NO Information stored for the following two values in the original attachment - We set default ones.
        uploadDocAttachment.setLanguage(DEFAULT_LANGUAGE);
        uploadDocAttachment.setKind(DEFAULT_KIND);
        return uploadDocAttachment;
    }

    public FileDocumentType buildFileDocument(Document document) {
        FileDocumentType fileDocument = new FileDocumentType();
        DocumentRefType docRefType = buildDocumentRef(document.getHermesRef());

        ServiceDocumentRefType serviceDocumentRefType = new ServiceDocumentRefType();
        serviceDocumentRefType.setDocumentVersionRefOrAresRef(docRefType);

        fileDocument.setDocumentRef(serviceDocumentRefType);


        String hermesFileId = document.getLegalEntity().getHermesFileId();
        if(StringUtils.isEmpty(hermesFileId)) {
            throw new RuntimeException("Hermes file/subFile ID missing for :" + document.getLegalEntity().getMid());
        }
        String fileExpression = "fileId=\'" + hermesFileId + "\'";
        fileDocument.setFileExpr(fileExpression);
        return fileDocument;
    }

	public DocumentMetaDataListType buildMetadata(ErisClientParams params, ErisDocTypeEnum[] keys) {
	    DocumentMetaDataListType metadata = new DocumentMetaDataListType();
	    for(ErisDocTypeEnum key : keys) {
	        ErisMetadataParam param = params.getMetadataParam(key);
	        if(param != null && param.getValue() != null) {
	            metadata.getDocumentMetaData().add(createDocumentMetadataType(param));
	        }
	    }
	    return metadata;
	}

	private CodeRefType buildAttachmentType(ErisClientParams params) {
		CodeRefType codeRefType = new CodeRefType();
		// Check the ErisParameters and if you don't find anything set the following default values
		if (!StringUtils.isEmpty(params.getAttachmentType()) && !StringUtils.isEmpty(params.getAttachmentTypeCCM2())) {
			codeRefType.setId(params.getAttachmentTypeCCM2());
			codeRefType.setAbbreviation(params.getAttachmentType());
		} else {
			codeRefType.setId(DEFAULT_ATTACHMENT_CCM2);
			codeRefType.setAbbreviation(DEFAULT_ATTACHMENT_TYPE);
		}
		return codeRefType;
	}

	/**
	 * Builds the senders and recipients based on the following conditions:
	 *
	 * <table border=1>
	 * 	<tr>
	 * 		<th>Document Type</th>
	 * 		<th>Senders</th>
	 * 		<th>Recipients (TO)</th>
	 *  </tr>
	 *  <tr>
	 *  	<td>Internal Document</td>
	 *  	<td>External.Organisation: Legal name</td>
	 *  	<td>Internal.Organisation.Code: REA.C</td>
	 *  </tr>
	 *  <tr>
	 *  	<td>External Document</td>
	 *  	<td>External.Person: Legal name + First name + Last name</td>
	 *  	<td>Internal.Organisation.Code: REA.C</td>
	 *  </tr>
	 *  <tr>
	 *  	<td>Message Attachment</td>
	 *  	<td>Internal.Organisation.Code: REA.C / Internal.Person.EcasId: username</td>
	 *  	<td>External.Organisation: Legal name</td>
	 *  </tr>
	 * </table>
	 */
	public SendersRecipients getSendersAndRecipients(Document document, ErisClientParams params) {
		SendersRecipients sendersRecipients = new SendersRecipients();
		if(params.isMessageAttachment()) {
			sendersRecipients.getSenders().add(getSender(getInternalPerson(params)));
			sendersRecipients.getSenders().add(getSender(getInternalOrganisationCode()));
			sendersRecipients.getRecipients().add(getRecipient(getExternalOrganisationName(document.getLegalEntity().getOfficialName())));
		} else {
			if(params.isExternalSender()) {
				sendersRecipients.getSenders().add(getSender(getExternalPerson(document.getLegalEntity().getOfficialName(), params)));
			} else {
				sendersRecipients.getSenders().add(getSender(getExternalOrganisationName(document.getLegalEntity().getOfficialName())));
			}
			sendersRecipients.getRecipients().add(getRecipient(getInternalOrganisationCode()));
		}
		return sendersRecipients;
	}

	public Serializable getMetadataProperty(String ccm2Code, LocalDocumentType document) {
		if(document != null && !CollectionUtils.isEmpty(document.getMetaData())) {
			for(DocumentMetaDataType metaData : document.getMetaData()) {
				if(ccm2Code.equals(metaData.getMetaDataRef().getId()) &&
				   (metaData.getValue() != null) &&
				   (metaData.getValue().getStringOrDateOrBoolean() != null)) {

					Serializable value = metaData.getValue().getStringOrDateOrBoolean();
					if(value instanceof StringType) {
						return ((StringType)value).getValue();
					}
					if(value instanceof BooleanType) {
						return ((BooleanType)value).isValue();
					}
					if(value instanceof DateTimeType) {
						return ((DateTimeType)value).getValue();
					}
				}
			}
		}
		LOG.warn("Unable to find DocumentMetadata with CCM2Code = " + ccm2Code + " in ErisResponse.");
		return null;
	}

	public VirtualAttachmentRefListType buildVirtualAttachmentRefs(Document document, ErisClientParams params) {
		VirtualAttachmentRefListType attachmentRefList = new VirtualAttachmentRefListType();
		VirtualAttachmentRefType virtualAttachmentRef = new VirtualAttachmentRefType();
		virtualAttachmentRef.setName(FilenameUtils.getBaseName(document.getFileName()));
		virtualAttachmentRef.setSourceAttachment(buildDocumentAttachmentRef(document.getHermesAttachmentId()));
		virtualAttachmentRef.setType(buildAttachmentType(params));
		virtualAttachmentRef.setLinkType(LinkType.STICKY);
		attachmentRefList.getVirtualAttachmentRef().add(virtualAttachmentRef);
		return attachmentRefList;
	}

    public DocumentAttachmentRefType buildDocumentAttachmentRef(String hermesAttachmentId) {
        if (StringUtils.isEmpty(hermesAttachmentId)) {
            throw new IllegalArgumentException("Empty Hermes attachment reference was passed as argument.");
        }
        DocumentAttachmentRefType attachmentRef = new DocumentAttachmentRefType();
        String[] hermesParams = hermesAttachmentId.split(ATTACHMENTREF_SEPARATOR);
        if (hermesParams.length == 0 || hermesParams.length != ATTACHMENTREF_SIZE) {
            throw new IllegalArgumentException("Improper Hermes reference ids were passed as arguments.");
        }
        attachmentRef.setMasterID(hermesParams[0]);
        AttachmentIdType id = new AttachmentIdType();
        id.setValue(hermesParams[1]);
        attachmentRef.setAttachmentIdOrAttachmentName(id);
        attachmentRef.setMaster(DEFAULT_MASTER);
        return attachmentRef;
    }

    public DocumentRefType buildDocumentRef(String hermesRef) {
        DocumentRefType docRefType = new DocumentRefType();
        docRefType.setMaster(DEFAULT_MASTER);
        docRefType.setMasterID(hermesRef);
        return docRefType;
    }

	/**
	 * Generic helper method for creating DocumentMetadataTypes
	 */
	private DocumentMetaDataType createDocumentMetadataType(ErisMetadataParam param) {
		if(param == null || param.getValue() == null) {
			return null;
		}
		DocumentMetaDataType documentMetaDataType = new DocumentMetaDataType();
		CodeRefType codeRefType = new CodeRefType();
		codeRefType.setId(param.getCcm2Code());
		codeRefType.setAbbreviation(param.getAbbreviation());
		documentMetaDataType.setMetaDataRef(codeRefType);

		documentMetaDataType.setValue(createMetaDataValueType(param.getValue()));

		return documentMetaDataType;
	}

	private MetaDataValueType createMetaDataValueType(Serializable value) {
		if(value == null) {
			return null;
		}
		if(value instanceof String) {
			return createMetaDataValueType((String) value);
		}
		if(value instanceof Timestamp) {
			return createMetaDataValueType((Timestamp) value);
		}
		throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getName());
	}

	private MetaDataValueType createMetaDataValueType(String value) {
		MetaDataValueType metaDataValueType = new MetaDataValueType();
		StringType stringType = new StringType();
		stringType.setValue(value);
		metaDataValueType.setStringOrDateOrBoolean(stringType);
		return metaDataValueType;
	}

	private MetaDataValueType createMetaDataValueType(Timestamp value) {
		MetaDataValueType metaDataValueType = new MetaDataValueType();
		DateTimeType dateTimeType = new DateTimeType();
		dateTimeType.setValue(value);
		metaDataValueType.setStringOrDateOrBoolean(dateTimeType);
		return metaDataValueType;
	}

	private SenderType getSender(Serializable internalOrExternalEntity) {
		SenderType sender = new SenderType();
		EntityType entity = new EntityType();
		entity.setInternalOrExternal(internalOrExternalEntity);
		sender.setEntity(entity);
		return sender;
	}

	private RecipientType getRecipient(Serializable internalOrExternalEntity) {
		RecipientType recipient = new RecipientType();
		EntityType entity = new EntityType();
		entity.setInternalOrExternal(internalOrExternalEntity);
		recipient.setEntity(entity);
		if (TransmitType.TO.name().equalsIgnoreCase(recipientCode)) {
			recipient.setCode(TransmitType.TO);
		} else {
			recipient.setCode(TransmitType.CC);
		}
		return recipient;
	}

	private ExternaLEntityType getExternalPerson(String legalName, ErisClientParams params) {
		ExternaLEntityType person = new ExternaLEntityType();
		ExternalPersonType personType = new ExternalPersonType();
		personType.setFirstName(params.getFirstName());
		personType.setLastName(params.getLastName());
		personType.setOrganizationName(legalName);
		person.setPersonOrOrganisationName(personType);
		return person;
	}

	private ExternaLEntityType getExternalOrganisationName(String legalName) {
		ExternaLEntityType organisation = new ExternaLEntityType();
		organisation.setPersonOrOrganisationName(legalName);
		return organisation;
	}

	private InternalEntityType getInternalPerson(ErisClientParams params) {
		InternalEntityType entity = new InternalEntityType();
		PersonType person = new PersonType();
		person.setEcasId(params.getUsername());
		entity.setPersonOrOrganisation(person);
		return entity;
	}

	private InternalEntityType getInternalOrganisationCode() {
		InternalEntityType organisation = new InternalEntityType();
		InternalOrganisationType internalOrganisationType = new InternalOrganisationType();
		internalOrganisationType.setCode(organisationCode);
		organisation.setPersonOrOrganisation(internalOrganisationType);
		return organisation;
	}

	private ReaderListType getSubFileReaders() {
    	ReaderListType subFileReaders = null;
    	List<String> readers = new ArrayList<String>(Arrays.asList(this.subFileReaders.split(" , ")));
		if (!CollectionUtils.isEmpty(readers)) {
			subFileReaders = new ReaderListType();
			for(String reader: readers) {
				subFileReaders.getReader().add(reader);
			}
		}
		return subFileReaders;
	}

    private UserListType getSubFileUsers() {
    	UserListType subFileUsers = null;
    	List<String> users = new ArrayList<String>(Arrays.asList(this.subFileUsers.split(" , ")));
		if (!CollectionUtils.isEmpty(users)) {
			subFileUsers = new UserListType();
			for(String user: users) {
				subFileUsers.getUser().add(user);
			}
		}
		return subFileUsers;
	}

    private EditorListType getSubFileEditors() {
    	EditorListType subFileEditors = null;
    	List<String> editors = new ArrayList<String>(Arrays.asList(this.subFileEditors.split(" , ")));
		if (!CollectionUtils.isEmpty(editors)) {
			subFileEditors = new EditorListType();
			for(String editor: editors) {
				subFileEditors.getEditor().add(editor);
			}
		}
		return subFileEditors;
	}
}
