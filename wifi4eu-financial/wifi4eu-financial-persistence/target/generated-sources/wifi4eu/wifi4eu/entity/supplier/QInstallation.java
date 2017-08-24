package wifi4eu.wifi4eu.entity.supplier;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QInstallation is a Querydsl query type for Installation
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QInstallation extends EntityPathBase<Installation> {

    private static final long serialVersionUID = -1361241553L;

    public static final QInstallation installation = new QInstallation("installation");

    public final NumberPath<Long> installationId = createNumber("installationId", Long.class);

    public final StringPath nip = createString("nip");

    public QInstallation(String variable) {
        super(Installation.class, forVariable(variable));
    }

    public QInstallation(Path<? extends Installation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInstallation(PathMetadata<?> metadata) {
        super(Installation.class, metadata);
    }

}

