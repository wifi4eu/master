package wifi4eu.wifi4eu.entity.helpdesk;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QHelpdeskComment is a Querydsl query type for HelpdeskComment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QHelpdeskComment extends EntityPathBase<HelpdeskComment> {

    private static final long serialVersionUID = -1029072098L;

    public static final QHelpdeskComment helpdeskComment = new QHelpdeskComment("helpdeskComment");

    public final StringPath comment = createString("comment");

    public final DateTimePath<java.util.Date> commentDate = createDateTime("commentDate", java.util.Date.class);

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final NumberPath<Long> issueId = createNumber("issueId", Long.class);

    public final StringPath type = createString("type");

    public QHelpdeskComment(String variable) {
        super(HelpdeskComment.class, forVariable(variable));
    }

    public QHelpdeskComment(Path<? extends HelpdeskComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHelpdeskComment(PathMetadata<?> metadata) {
        super(HelpdeskComment.class, metadata);
    }

}

