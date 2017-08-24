package wifi4eu.wifi4eu.entity.security;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTempToken is a Querydsl query type for TempToken
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTempToken extends EntityPathBase<TempToken> {

    private static final long serialVersionUID = -1148987612L;

    public static final QTempToken tempToken = new QTempToken("tempToken");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final StringPath email = createString("email");

    public final DateTimePath<java.util.Date> expiryDate = createDateTime("expiryDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath token = createString("token");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QTempToken(String variable) {
        super(TempToken.class, forVariable(variable));
    }

    public QTempToken(Path<? extends TempToken> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTempToken(PathMetadata<?> metadata) {
        super(TempToken.class, metadata);
    }

}

