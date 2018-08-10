package wifi4eu.wifi4eu.abac.integration.eris.model;

import java.util.HashMap;
import java.util.Map;

public class ErisClientParams {

	private Map<ErisMetadataParamType, ErisMetadataParam> erisParams = new HashMap<>();

	private String firstName;
	private String lastName;
	private String username;

	private String attachmentType;
	private String attachmentTypeCCM2;
	private String saveNumCCM2Code;

	private boolean externalSender;
	private boolean messageAttachment;

	public ErisMetadataParam getMetadataParam(ErisDocTypeEnum key) {
		return erisParams.get(key);
	}

	public void setMetadataParam(ErisMetadataParamType key, ErisMetadataParam param) {
		erisParams.put(key, param);
	}

	public void removeMetadataParam(ErisDocTypeEnum key) {
		erisParams.remove(key);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String senderUsername) {
		this.username = senderUsername;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getAttachmentTypeCCM2() {
		return attachmentTypeCCM2;
	}

	public void setAttachmentTypeCCM2(String attachmentTypeCCM2) {
		this.attachmentTypeCCM2 = attachmentTypeCCM2;
	}

	public String getSaveNumCCM2Code() {
		return saveNumCCM2Code;
	}

	public void setSaveNumCCM2Code(String saveNumCCM2Code) {
		this.saveNumCCM2Code = saveNumCCM2Code;
	}

	public boolean isExternalSender() {
		return externalSender;
	}

	public void setExternalSender(boolean externalSender) {
		this.externalSender = externalSender;
	}

	public boolean isMessageAttachment() {
		return messageAttachment;
	}

	public void setMessageAttachment(boolean messageAttachment) {
		this.messageAttachment = messageAttachment;
	}
}
