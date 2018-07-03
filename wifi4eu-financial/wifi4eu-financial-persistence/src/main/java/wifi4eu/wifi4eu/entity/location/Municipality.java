package wifi4eu.wifi4eu.entity.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author kieuhuu
 *
 */
@Entity
@Table(name = "MUNICIPALITY")
@SequenceGenerator(sequenceName = "seq_municipality", name = "municipality_seq_name", allocationSize=1)
public class Municipality {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "municipality_seq_name", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "ADDRESS_NUM")
    private String addressNum;
    
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    
    @Column(name = "COUNTRY")
    private String country;

    @Column(name="JAGATE_KEY")
    private String jagateKey;
    
    @Column(name="FEL_ID")
    private String felId;

//  @OneToOne
//  @JoinColumn(name = "LAU_ID", fetch = FetchType.LAZY)
//  private Lau lau;
//  
//  @OneToMany(mappedBy="municipality", fetch = FetchType.LAZY)
//  private List<Registration> registrations;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNum() {
		return addressNum;
	}

	public void setAddressNum(String addressNum) {
		this.addressNum = addressNum;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJagateKey() {
		return jagateKey;
	}

	public void setJagateKey(String jagateKey) {
		this.jagateKey = jagateKey;
	}

	public String getFelId() {
		return felId;
	}

	public void setFelId(String felId) {
		this.felId = felId;
	}
}
