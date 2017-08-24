package wifi4eu.wifi4eu.entity.location;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNuts is a Querydsl query type for Nuts
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNuts extends EntityPathBase<Nuts> {

    private static final long serialVersionUID = 843705138L;

    public static final QNuts nuts = new QNuts("nuts");

    public final StringPath code = createString("code");

    public final StringPath countryCode = createString("countryCode");

    public final NumberPath<Long> level = createNumber("level", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> nutsId = createNumber("nutsId", Long.class);

    public final NumberPath<Long> order = createNumber("order", Long.class);

    public final NumberPath<Long> sorting = createNumber("sorting", Long.class);

    public final ListPath<wifi4eu.wifi4eu.entity.supplier.Supplier, wifi4eu.wifi4eu.entity.supplier.QSupplier> suppliers = this.<wifi4eu.wifi4eu.entity.supplier.Supplier, wifi4eu.wifi4eu.entity.supplier.QSupplier>createList("suppliers", wifi4eu.wifi4eu.entity.supplier.Supplier.class, wifi4eu.wifi4eu.entity.supplier.QSupplier.class, PathInits.DIRECT2);

    public QNuts(String variable) {
        super(Nuts.class, forVariable(variable));
    }

    public QNuts(Path<? extends Nuts> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNuts(PathMetadata<?> metadata) {
        super(Nuts.class, metadata);
    }

}

