package wifi4eu.wifi4eu.entity.beneficiary;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QRepresentative is a Querydsl query type for Representative
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRepresentative extends EntityPathBase<Representative> {

    private static final long serialVersionUID = 1641788627L;

    public static final QRepresentative representative = new QRepresentative("representative");

    public final StringPath email = createString("email");

    public final NumberPath<Long> mayorId = createNumber("mayorId", Long.class);

    public final StringPath municipalityRole = createString("municipalityRole");

    public final StringPath name = createString("name");

    public final NumberPath<Long> representativeId = createNumber("representativeId", Long.class);

    public final StringPath surname = createString("surname");

    public final StringPath treatment = createString("treatment");

    public QRepresentative(String variable) {
        super(Representative.class, forVariable(variable));
    }

    public QRepresentative(Path<? extends Representative> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRepresentative(PathMetadata<?> metadata) {
        super(Representative.class, metadata);
    }

}

