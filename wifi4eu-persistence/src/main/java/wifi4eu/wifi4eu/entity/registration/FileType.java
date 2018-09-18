package wifi4eu.wifi4eu.entity.registration;

// TODO: waiting for the reply from Everis with the mapping.
public enum FileType {

    GRANT_AGREEMENT(1),

    IDENTIFICATION_FORM(2),

    GRANT_AGREEMENT_SIGNATURE(3),

    COUNTERSIGNED_GRANT_AGREEMENT(4),

    OTHER(5);

    private int code;

    FileType(int code) {
        this.code = code;
    }

    public static FileType fromCode(Integer code) {
        if (code != null) {
            for (final FileType fileType : values()) {
                if (fileType.code == code) {
                    return fileType;
                }
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
