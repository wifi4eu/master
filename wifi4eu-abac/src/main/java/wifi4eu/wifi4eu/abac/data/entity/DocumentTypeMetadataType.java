package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "WIF_DOCTYPE_METADATA_TYPE")
public class DocumentTypeMetadataType {
	
	@Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long id;

	@Column(name = "CCM2_DOCTYPE_ID", nullable = false, insertable = false)
    private Long ccm2DocTypeId;
    
    @Column(name = "CCM2_DOCTYPE_ABBREV", nullable = false, insertable = false, length=100)
    private String ccm2DoctypeAbbreviation;
    
    @Column(name = "CCM2_METADATA_ID", nullable = false, insertable = false)
    private Long ccm2MetadataId;
    
    @Column(name = "CCM2_METADATA_ABBREV", nullable = true, insertable = false, length=100)
    private String ccm2MetadataAbbreviation;
    
    @Column(name = "METADATA_KEY", nullable = true, insertable = false, length=100)
    private String ccm2MetadataKey;

	public Long getCcm2DocTypeId() {
		return ccm2DocTypeId;
	}

	public String getCcm2DoctypeAbbreviation() {
		return ccm2DoctypeAbbreviation;
	}

	public Long getCcm2MetadataId() {
		return ccm2MetadataId;
	}

	public String getCcm2MetadataAbbreviation() {
		return ccm2MetadataAbbreviation;
	}

	public String getCcm2MetadataKey() {
		return ccm2MetadataKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((ccm2DoctypeAbbreviation == null) ? 0
						: ccm2DoctypeAbbreviation.hashCode());
		result = prime * result
				+ ((ccm2DocTypeId == null) ? 0 : ccm2DocTypeId.hashCode());
		result = prime
				* result
				+ ((ccm2MetadataAbbreviation == null) ? 0
						: ccm2MetadataAbbreviation.hashCode());
		result = prime * result
				+ ((ccm2MetadataId == null) ? 0 : ccm2MetadataId.hashCode());
		result = prime * result
				+ ((ccm2MetadataKey == null) ? 0 : ccm2MetadataKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentTypeMetadataType other = (DocumentTypeMetadataType) obj;
		if (ccm2DoctypeAbbreviation == null) {
			if (other.ccm2DoctypeAbbreviation != null)
				return false;
		} else if (!ccm2DoctypeAbbreviation
				.equals(other.ccm2DoctypeAbbreviation))
			return false;
		if (ccm2DocTypeId == null) {
			if (other.ccm2DocTypeId != null)
				return false;
		} else if (!ccm2DocTypeId.equals(other.ccm2DocTypeId))
			return false;
		if (ccm2MetadataAbbreviation == null) {
			if (other.ccm2MetadataAbbreviation != null)
				return false;
		} else if (!ccm2MetadataAbbreviation
				.equals(other.ccm2MetadataAbbreviation))
			return false;
		if (ccm2MetadataId == null) {
			if (other.ccm2MetadataId != null)
				return false;
		} else if (!ccm2MetadataId.equals(other.ccm2MetadataId))
			return false;
		if (ccm2MetadataKey == null) {
			if (other.ccm2MetadataKey != null)
				return false;
		} else if (!ccm2MetadataKey.equals(other.ccm2MetadataKey))
			return false;
		return true;
	}


	public Serializable getId() {
		return id;
	}

    @Override
    public String toString() {
        return "DocumentTypeMetadataType{" +
                "id=" + id +
                ", ccm2DoctypeId=" + ccm2DocTypeId +
                ", ccm2DoctypeAbbreviation='" + ccm2DoctypeAbbreviation + '\'' +
                ", ccm2MetadataId=" + ccm2MetadataId +
                ", ccm2MetadataAbbreviation='" + ccm2MetadataAbbreviation + '\'' +
                ", ccm2MetadataKey='" + ccm2MetadataKey + '\'' +
                '}';
    }
}
