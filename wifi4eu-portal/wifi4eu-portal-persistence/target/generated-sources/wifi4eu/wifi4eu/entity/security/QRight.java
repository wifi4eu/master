package wifi4eu.wifi4eu.entity.security;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRight is a Querydsl query type for Right
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRight extends EntityPathBase<Right> {

    private static final long serialVersionUID = -106039749L;

    public static final QRight right = new QRight("right");

    public final StringPath name = createString("name");

    public final NumberPath<Long> rightId = createNumber("rightId", Long.class);

    public final ListPath<Role, QRole> roles = this.<Role, QRole>createList("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public QRight(String variable) {
        super(Right.class, forVariable(variable));
    }

    public QRight(Path<? extends Right> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRight(PathMetadata<?> metadata) {
        super(Right.class, metadata);
    }

}

