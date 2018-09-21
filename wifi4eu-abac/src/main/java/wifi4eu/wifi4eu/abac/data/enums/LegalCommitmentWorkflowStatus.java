package wifi4eu.wifi4eu.abac.data.enums;

public enum LegalCommitmentWorkflowStatus {

	IMPORTED("IMPORTED", "Imported"),
	READY_TO_BE_COUNTERSIGNED("READY_TO_BE_COUNTERSIGNED", "Ready to be Counter Signed"),
	COUNTERSIGNATURE_REQUESTED("COUNTERSIGNATURE_REQUESTED", "Waiting Counter Signature"),
	COUNTERSIGNED("COUNTERSIGNED", "Waiting ABAC Validation"),
	WAITING_FOR_ABAC("WAITING_FOR_ABAC", "Waiting ABAC Validation"),
	WAITING_APPROVAL("WAITING_APPROVAL", "Waiting ABAC Validation"),
	ABAC_ERROR("ABAC_ERROR", "Error sending to ABAC"),
    ABAC_VALID("ABAC_VALID", "Validated in ABAC"),
    ABAC_REJECTED("ABAC_REJECTED", "Rejected in ABAC"),
	UNMAPPED_STATUS("UNMAPPED_STATUS", "Unknown status");

	private String value;
	private String userInterfaceTitle;

	private LegalCommitmentWorkflowStatus(String value, String userInterfaceTitle) {
		this.value = value;
		this.userInterfaceTitle = userInterfaceTitle;
	}

	public String getValue() {
		return value;
	}
	
	public String getUserInterfaceTitle() {
		return userInterfaceTitle;
	}

	@Override
	public String toString() {
		return getValue();
	}
}