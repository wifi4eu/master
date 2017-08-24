package wifi4eu.wifi4eu.entity.location;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QLau is a Querydsl query type for Lau
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLau extends EntityPathBase<Lau> {

    private static final long serialVersionUID = 2105423732L;

    public static final QLau lau = new QLau("lau");

    public final NumberPath<Long> area = createNumber("area", Long.class);

    public final StringPath change = createString("change");

    public final StringPath countryCode = createString("countryCode");

    public final StringPath lau1 = createString("lau1");

    public final StringPath lau2 = createString("lau2");

    public final NumberPath<Long> lauId = createNumber("lauId", Long.class);

    public final StringPath name1 = createString("name1");

    public final StringPath name2 = createString("name2");

    public final StringPath nuts3 = createString("nuts3");

    public final NumberPath<Long> pop = createNumber("pop", Long.class);

    public QLau(String variable) {
        super(Lau.class, forVariable(variable));
    }

    public QLau(Path<? extends Lau> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLau(PathMetadata<?> metadata) {
        super(Lau.class, metadata);
    }

}

