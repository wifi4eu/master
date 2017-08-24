package wifi4eu.wifi4eu.entity.call;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCall is a Querydsl query type for Call
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCall extends EntityPathBase<Call> {

    private static final long serialVersionUID = 1577318273L;

    public static final QCall call = new QCall("call");

    public final NumberPath<Long> callId = createNumber("callId", Long.class);

    public final NumberPath<Long> endDate = createNumber("endDate", Long.class);

    public final StringPath event = createString("event");

    public final NumberPath<Long> startDate = createNumber("startDate", Long.class);

    public QCall(String variable) {
        super(Call.class, forVariable(variable));
    }

    public QCall(Path<? extends Call> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCall(PathMetadata<?> metadata) {
        super(Call.class, metadata);
    }

}

