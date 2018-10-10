package wifi4eu.wifi4eu.service.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserThreadsDTO;
import wifi4eu.wifi4eu.common.mapper.thread.UserThreadsMapper;
import wifi4eu.wifi4eu.repository.thread.UserThreadsRepository;

@Service
public class UserThreadsService {
    @Autowired
    private UserThreadsMapper userThreadsMapper;

    @Autowired
    private UserThreadsRepository userThreadsRepository;

    public UserThreadsDTO getByUserIdAndThreadId(int userId, int threadId) {
        return userThreadsMapper.toDTO(userThreadsRepository.findByUserIdAndThreadId(userId, threadId));
    }
}