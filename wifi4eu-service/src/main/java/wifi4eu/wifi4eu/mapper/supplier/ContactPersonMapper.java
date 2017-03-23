package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.ContactPersonDTO;
import wifi4eu.wifi4eu.entity.supplier.ContactPerson;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ContactPersonMapper {
    ContactPersonDTO toDTO(ContactPerson entity);

    ContactPerson toEntity(ContactPersonDTO vo);

    List<ContactPersonDTO> toDTOList(List<ContactPerson> list);

    List<ContactPerson> toEntityList(List<ContactPersonDTO> list);
}