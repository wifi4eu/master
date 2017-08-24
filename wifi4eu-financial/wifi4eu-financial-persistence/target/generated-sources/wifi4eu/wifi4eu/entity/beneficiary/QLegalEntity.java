package wifi4eu.wifi4eu.entity.beneficiary;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QLegalEntity is a Querydsl query type for LegalEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLegalEntity extends EntityPathBase<LegalEntity> {

    private static final long serialVersionUID = 253420678L;

    public static final QLegalEntity legalEntity = new QLegalEntity("legalEntity");

    public final BooleanPath abacStatus = createBoolean("abacStatus");

    public final StringPath address = createString("address");

    public final StringPath addressNum = createString("addressNum");

    public final StringPath countryCode = createString("countryCode");

    public final BooleanPath legalCheckbox1 = createBoolean("legalCheckbox1");

    public final BooleanPath legalCheckbox2 = createBoolean("legalCheckbox2");

    public final BooleanPath legalCheckbox3 = createBoolean("legalCheckbox3");

    public final NumberPath<Long> legalEntityId = createNumber("legalEntityId", Long.class);

    public final StringPath municipalityCode = createString("municipalityCode");

    public final StringPath postalCode = createString("postalCode");

    public QLegalEntity(String variable) {
        super(LegalEntity.class, forVariable(variable));
    }

    public QLegalEntity(Path<? extends LegalEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLegalEntity(PathMetadata<?> metadata) {
        super(LegalEntity.class, metadata);
    }

}

