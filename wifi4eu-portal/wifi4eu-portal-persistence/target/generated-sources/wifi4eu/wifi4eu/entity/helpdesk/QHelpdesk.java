package wifi4eu.wifi4eu.entity.helpdesk;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QHelpdesk is a Querydsl query type for Helpdesk
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QHelpdesk extends EntityPathBase<Helpdesk> {

    private static final long serialVersionUID = -823453695L;

    public static final QHelpdesk helpdesk = new QHelpdesk("helpdesk");

    public final StringPath assignedTo = createString("assignedTo");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath from = createString("from");

    public final NumberPath<Long> issueId = createNumber("issueId", Long.class);

    public final StringPath issueSummary = createString("issueSummary");

    public final StringPath memberState = createString("memberState");

    public final StringPath portal = createString("portal");

    public final StringPath status = createString("status");

    public final StringPath topic = createString("topic");

    public QHelpdesk(String variable) {
        super(Helpdesk.class, forVariable(variable));
    }

    public QHelpdesk(Path<? extends Helpdesk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHelpdesk(PathMetadata<?> metadata) {
        super(Helpdesk.class, metadata);
    }

}

