package wifi4eu.wifi4eu.common.enums;

public enum FileTypes {
	LEGALFILE1(1),
	LEGALFILE2(2),
	LEGALFILE3(3),
	LEGALFILE4(4);

	private int status;

	FileTypes(int status) {
		this.status = status;
	}

	public int getValue() {
		return this.status;
	}
}
