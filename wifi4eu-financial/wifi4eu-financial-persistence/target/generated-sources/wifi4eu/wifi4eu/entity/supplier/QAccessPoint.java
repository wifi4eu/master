package wifi4eu.wifi4eu.entity.supplier;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAccessPoint is a Querydsl query type for AccessPoint
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccessPoint extends EntityPathBase<AccessPoint> {

    private static final long serialVersionUID = 1476386807L;

    public static final QAccessPoint accessPoint = new QAccessPoint("accessPoint");

    public final NumberPath<Long> accessPointId = createNumber("accessPointId", Long.class);

    public final BooleanPath indoor = createBoolean("indoor");

    public final NumberPath<Long> installationId = createNumber("installationId", Long.class);

    public final StringPath modelNumber = createString("modelNumber");

    public final StringPath name = createString("name");

    public final StringPath productName = createString("productName");

    public final StringPath serialNumber = createString("serialNumber");

    public QAccessPoint(String variable) {
        super(AccessPoint.class, forVariable(variable));
    }

    public QAccessPoint(Path<? extends AccessPoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccessPoint(PathMetadata<?> metadata) {
        super(AccessPoint.class, metadata);
    }

}

