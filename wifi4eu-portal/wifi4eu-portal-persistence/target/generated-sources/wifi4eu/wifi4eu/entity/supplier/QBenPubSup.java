package wifi4eu.wifi4eu.entity.supplier;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBenPubSup is a Querydsl query type for BenPubSup
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBenPubSup extends EntityPathBase<BenPubSup> {

    private static final long serialVersionUID = 1001044647L;

    public static final QBenPubSup benPubSup = new QBenPubSup("benPubSup");

    public final BooleanPath abacStatus = createBoolean("abacStatus");

    public final BooleanPath awarded = createBoolean("awarded");

    public final NumberPath<Long> beneficiaryId = createNumber("beneficiaryId", Long.class);

    public final NumberPath<Long> benPubSubId = createNumber("benPubSubId", Long.class);

    public final BooleanPath budgetCommited = createBoolean("budgetCommited");

    public final BooleanPath budgetLinked = createBoolean("budgetLinked");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath lastAbacMessage = createString("lastAbacMessage");

    public final NumberPath<Long> publicationId = createNumber("publicationId", Long.class);

    public final NumberPath<Long> supplierId = createNumber("supplierId", Long.class);

    public QBenPubSup(String variable) {
        super(BenPubSup.class, forVariable(variable));
    }

    public QBenPubSup(Path<? extends BenPubSup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBenPubSup(PathMetadata<?> metadata) {
        super(BenPubSup.class, metadata);
    }

}

