package wifi4eu.wifi4eu.entity.beneficiary;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMayor is a Querydsl query type for Mayor
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMayor extends EntityPathBase<Mayor> {

    private static final long serialVersionUID = -102564334L;

    public static final QMayor mayor = new QMayor("mayor");

    public final StringPath email = createString("email");

    public final NumberPath<Long> legalEntityId = createNumber("legalEntityId", Long.class);

    public final NumberPath<Long> mayorId = createNumber("mayorId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath surname = createString("surname");

    public final StringPath treatment = createString("treatment");

    public QMayor(String variable) {
        super(Mayor.class, forVariable(variable));
    }

    public QMayor(Path<? extends Mayor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMayor(PathMetadata<?> metadata) {
        super(Mayor.class, metadata);
    }

}

