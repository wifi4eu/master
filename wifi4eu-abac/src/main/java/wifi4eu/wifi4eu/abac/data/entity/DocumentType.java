package wifi4eu.wifi4eu.abac.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

@Entity

@Table(name = "WIF_DOCUMENT_TYPE", uniqueConstraints = @UniqueConstraint(columnNames = "DOCT_TYPE_NAME"))
public class DocumentType {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long id;

    @Column(name = "DOCT_TYPE_NAME", unique = true, nullable = false, length = 50)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true, length=200)
    private String description;

    @Column(name = "CCM2_DOCTYPE_PARENT_ID", nullable = false, insertable = false)
    private Long ccm2DoctypeParentId;

    @Column(name = "CCM2_DOCTYPE_PARENT_ABBREV", nullable = false, insertable = false)
    private String ccm2DoctypeParentAbbreviation;


    @Column(name = "CCM2_DOCTYPE_ID", nullable = false, insertable = false)
    private Long ccm2DoctypeId;

    @Column(name = "CCM2_DOCTYPE_ABBREV", nullable = false, insertable = false, length=100)
    private String ccm2DoctypeAbbreviation;


	public DocumentType() {
    }

    public DocumentType(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Long getCcm2DoctypeId() {
		return ccm2DoctypeId;
	}

	public String getCcm2DoctypeParentAbbreviation() {
		return ccm2DoctypeParentAbbreviation;
	}



	public Long getCcm2DoctypeParentId() {
		return ccm2DoctypeParentId;
	}

	public String getCcm2DoctypeAbbreviation() {
		return ccm2DoctypeAbbreviation;
	}



	public void setCcm2DoctypeParentId(Long ccm2DoctypeParentId) {
		this.ccm2DoctypeParentId = ccm2DoctypeParentId;
	}

	public void setCcm2DoctypeParentAbbreviation(
			String ccm2DoctypeParentAbbreviation) {
		this.ccm2DoctypeParentAbbreviation = ccm2DoctypeParentAbbreviation;
	}



	public void setCcm2DoctypeId(Long ccm2DoctypeId) {
		this.ccm2DoctypeId = ccm2DoctypeId;
	}

	public void setCcm2DoctypeAbbreviation(String ccm2DoctypeAbbreviation) {
		this.ccm2DoctypeAbbreviation = ccm2DoctypeAbbreviation;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((ccm2DoctypeParentAbbreviation == null) ? 0
						: ccm2DoctypeParentAbbreviation.hashCode());
		result = prime
				* result
				+ ((ccm2DoctypeId == null) ? 0 : ccm2DoctypeId
						.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DocumentType)) return false;
		DocumentType that = (DocumentType) o;
		return Objects.equals(ccm2DoctypeId, that.ccm2DoctypeId);
	}

	@Override
	public String toString() {
		return "DocumentType{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", ccm2DoctypeParentId=" + ccm2DoctypeParentId +
				", ccm2DoctypeParentAbbreviation='" + ccm2DoctypeParentAbbreviation + '\'' +
				", ccm2DoctypeId=" + ccm2DoctypeId +
				", ccm2DoctypeAbbreviation='" + ccm2DoctypeAbbreviation + '\'' +
				'}';
	}
}
