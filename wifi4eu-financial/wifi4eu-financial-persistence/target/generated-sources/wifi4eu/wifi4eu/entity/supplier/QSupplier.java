package wifi4eu.wifi4eu.entity.supplier;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSupplier is a Querydsl query type for Supplier
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSupplier extends EntityPathBase<Supplier> {

    private static final long serialVersionUID = -1358301119L;

    public static final QSupplier supplier = new QSupplier("supplier");

    public final BooleanPath abacStatus = createBoolean("abacStatus");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath address = createString("address");

    public final StringPath bic = createString("bic");

    public final StringPath contactEmail = createString("contactEmail");

    public final StringPath contactName = createString("contactName");

    public final StringPath contactPhoneNumber = createString("contactPhoneNumber");

    public final StringPath contactPhonePrefix = createString("contactPhonePrefix");

    public final StringPath contactSurname = createString("contactSurname");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final BooleanPath legalCheck1 = createBoolean("legalCheck1");

    public final BooleanPath legalCheck2 = createBoolean("legalCheck2");

    public final StringPath logo = createString("logo");

    public final StringPath name = createString("name");

    public final StringPath nutsIds = createString("nutsIds");

    public final NumberPath<Long> supplierId = createNumber("supplierId", Long.class);

    public final StringPath vat = createString("vat");

    public final StringPath website = createString("website");

    public QSupplier(String variable) {
        super(Supplier.class, forVariable(variable));
    }

    public QSupplier(Path<? extends Supplier> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupplier(PathMetadata<?> metadata) {
        super(Supplier.class, metadata);
    }

}

