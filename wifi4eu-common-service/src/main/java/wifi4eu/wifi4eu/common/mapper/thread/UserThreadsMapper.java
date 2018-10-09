package wifi4eu.wifi4eu.common.mapper.thread;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.UserThreadsDTO;
import wifi4eu.wifi4eu.entity.thread.UserThreads;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserThreadsMapper {
    @Mappings({
            @Mapping(source = "entity.thread.id", target = "threadId"),
            @Mapping(source = "entity.user.id", target = "userId")
    })
    UserThreadsDTO toDTO(UserThreads entity);

    @Mappings({
            @Mapping(source = "vo.threadId", target = "thread.id"),
            @Mapping(source = "vo.userId", target = "user.id")
    })
    UserThreads toEntity(UserThreadsDTO vo);

    List<UserThreadsDTO> toDTOList(List<UserThreads> list);

    List<UserThreads> toEntityList(List<UserThreadsDTO> list);

}

