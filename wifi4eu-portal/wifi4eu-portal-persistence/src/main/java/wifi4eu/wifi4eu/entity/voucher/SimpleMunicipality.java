package wifi4eu.wifi4eu.entity.voucher;


import wifi4eu.wifi4eu.entity.location.Lau;

import javax.persistence.*;

@Entity
public class SimpleMunicipality {

    @Id
    private Integer id;

    private String country;

    private Integer lau;
}
