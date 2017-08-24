package wifi4eu.wifi4eu.entity.security;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 1936247927L;

    public static final QRole role = new QRole("role");

    public final StringPath name = createString("name");

    public final ListPath<Right, QRight> rights = this.<Right, QRight>createList("rights", Right.class, QRight.class, PathInits.DIRECT2);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final ListPath<User, QUser> users = this.<User, QUser>createList("users", User.class, QUser.class, PathInits.DIRECT2);

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata<?> metadata) {
        super(Role.class, metadata);
    }

}

