package wifi4eu.wifi4eu.service.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.mapper.thread.ThreadMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadRepository;

@Service
public class ThreadService {
    @Autowired
    private ThreadMapper threadMapper;

    @Autowired
    private ThreadRepository threadRepository;

    public ThreadDTO getThreadByTypeAndReason(int type, String reason) {
        return threadMapper.toDTO(threadRepository.findByTypeAndReason(type, reason));
    }
}