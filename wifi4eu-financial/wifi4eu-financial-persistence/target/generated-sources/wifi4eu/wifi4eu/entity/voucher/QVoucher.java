package wifi4eu.wifi4eu.entity.voucher;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QVoucher is a Querydsl query type for Voucher
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QVoucher extends EntityPathBase<Voucher> {

    private static final long serialVersionUID = -1819470719L;

    public static final QVoucher voucher = new QVoucher("voucher");

    public final NumberPath<Long> callId = createNumber("callId", Long.class);

    public final StringPath countryCode = createString("countryCode");

    public final DatePath<java.util.Date> createDate = createDate("createDate", java.util.Date.class);

    public final StringPath lau1 = createString("lau1");

    public final StringPath lau2 = createString("lau2");

    public final NumberPath<Long> legalEntityId = createNumber("legalEntityId", Long.class);

    public final StringPath nuts3 = createString("nuts3");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> voucherId = createNumber("voucherId", Long.class);

    public QVoucher(String variable) {
        super(Voucher.class, forVariable(variable));
    }

    public QVoucher(Path<? extends Voucher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVoucher(PathMetadata<?> metadata) {
        super(Voucher.class, metadata);
    }

}

