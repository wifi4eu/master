package wifi4eu.wifi4eu.entity.supplier;

import wifi4eu.wifi4eu.entity.location.Nuts;

import javax.persistence.*;

@Entity
@Table(name = "supplied_regions")
public class SuppliedRegion {
    @Id
    @SequenceGenerator(name = "suppreg_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suppreg_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "region")
    private Nuts region;

    public SuppliedRegion() {
    }

    public SuppliedRegion(Integer id, Supplier supplier, Nuts region) {
        this.id = id;
        this.supplier = supplier;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Nuts getRegion() {
        return region;
    }

    public void setRegion(Nuts region) {
        this.region = region;
    }
}