package wifi4eu.wifi4eu.entity.supplier;

import wifi4eu.wifi4eu.entity.location.Nuts;

import javax.persistence.*;

@Entity
@Table(name = "supplied_regions")
public class SuppliedRegion {
    @Id
    @SequenceGenerator(name = "supplied_region_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplied_region_seq")
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "supplier")
    Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "region")
    Nuts region;

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