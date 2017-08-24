package wifi4eu.wifi4eu.entity.timeline;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTimeline is a Querydsl query type for Timeline
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTimeline extends EntityPathBase<Timeline> {

    private static final long serialVersionUID = 1718610913L;

    public static final QTimeline timeline = new QTimeline("timeline");

    public final NumberPath<Long> endDate = createNumber("endDate", Long.class);

    public final StringPath event = createString("event");

    public final NumberPath<Long> startDate = createNumber("startDate", Long.class);

    public final NumberPath<Long> timelineId = createNumber("timelineId", Long.class);

    public QTimeline(String variable) {
        super(Timeline.class, forVariable(variable));
    }

    public QTimeline(Path<? extends Timeline> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimeline(PathMetadata<?> metadata) {
        super(Timeline.class, metadata);
    }

}

