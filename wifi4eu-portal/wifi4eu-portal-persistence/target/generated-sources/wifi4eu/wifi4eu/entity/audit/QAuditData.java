package wifi4eu.wifi4eu.entity.audit;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAuditData is a Querydsl query type for AuditData
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAuditData extends EntityPathBase<AuditData> {

    private static final long serialVersionUID = -1631604507L;

    public static final QAuditData auditData = new QAuditData("auditData");

    public final NumberPath<Long> auditDataId = createNumber("auditDataId", Long.class);

    public final StringPath requestBody = createString("requestBody");

    public final StringPath requestEndpoint = createString("requestEndpoint");

    public final StringPath requestMethod = createString("requestMethod");

    public final StringPath responseBody = createString("responseBody");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QAuditData(String variable) {
        super(AuditData.class, forVariable(variable));
    }

    public QAuditData(Path<? extends AuditData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditData(PathMetadata<?> metadata) {
        super(AuditData.class, metadata);
    }

}

