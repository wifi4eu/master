package wifi4eu.wifi4eu.service.thread;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserThreadsDTO;
import wifi4eu.wifi4eu.common.mapper.thread.UserThreadsMapper;
import wifi4eu.wifi4eu.repository.thread.UserThreadsRepository;

import java.util.List;

@Service
public class UserThreadsService {
    @Autowired
    UserThreadsMapper userThreadsMapper;

    @Autowired
    UserThreadsRepository userThreadsRepository;

    Logger _log = LogManager.getLogger(UserThreadsService.class);

    public List<UserThreadsDTO> getAllUserThreads() {
        return userThreadsMapper.toDTOList(Lists.newArrayList(userThreadsRepository.findAll()));
    }

    public UserThreadsDTO getUserThreadsById(int userThreadsId) {
        return userThreadsMapper.toDTO(userThreadsRepository.findOne(userThreadsId));
    }

    public UserThreadsDTO createUserThreads(UserThreadsDTO userThreadsDTO) {
    	if (userThreadsDTO.getId() != 0) {
    		_log.warn("Call to a create method with id set, the value has been removed ({})", userThreadsDTO.getId());
    		userThreadsDTO.setId(0);	
    	}    	
        return userThreadsMapper.toDTO(userThreadsRepository.save(userThreadsMapper.toEntity(userThreadsDTO)));
    }

    public UserThreadsDTO deleteUserThreads(int userThreadsId) {
        UserThreadsDTO userThreadsDTO = userThreadsMapper.toDTO(userThreadsRepository.findOne(userThreadsId));
        if (userThreadsDTO != null) {
            userThreadsRepository.delete(userThreadsMapper.toEntity(userThreadsDTO));
            return userThreadsDTO;
        } else {
            return null;
        }
    }

    public List<UserThreadsDTO> getUserThreadsByUserId(int userId) {
        return userThreadsMapper.toDTOList(Lists.newArrayList(userThreadsRepository.findByUserId(userId)));
    }

    public List<UserThreadsDTO> getUserThreadsByThreadId(int threadId) {
        return userThreadsMapper.toDTOList(Lists.newArrayList(userThreadsRepository.findByThreadId(threadId)));
    }

    public UserThreadsDTO getByUserIdAndThreadId(int userId, int threadId) {
        return userThreadsMapper.toDTO(userThreadsRepository.findByUserIdAndThreadId(userId, threadId));
    }
}