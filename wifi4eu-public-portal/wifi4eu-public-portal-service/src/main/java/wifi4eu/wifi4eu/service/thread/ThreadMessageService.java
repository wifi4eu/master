package wifi4eu.wifi4eu.service.thread;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.mapper.thread.ThreadMessageMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadMessageRepository;

import java.util.List;

@Service
public class ThreadMessageService {
    @Autowired
    ThreadMessageMapper threadMessageMapper;

    @Autowired
    ThreadMessageRepository threadMessageRepository;

    public List<ThreadMessageDTO> getAllThreadMessages() {
        return threadMessageMapper.toDTOList(Lists.newArrayList(threadMessageRepository.findAll()));
    }

    public ThreadMessageDTO getThreadMessageById(int threadMessageId) {
        return threadMessageMapper.toDTO(threadMessageRepository.findOne(threadMessageId));
    }

    public ThreadMessageDTO createThreadMessage(ThreadMessageDTO threadMessageDTO) {
        return threadMessageMapper.toDTO(threadMessageRepository.save(threadMessageMapper.toEntity(threadMessageDTO)));
    }

    public ThreadMessageDTO deleteThreadMessage(int threadMessageId) {
        ThreadMessageDTO threadMessageDTO = threadMessageMapper.toDTO(threadMessageRepository.findOne(threadMessageId));
        if (threadMessageDTO != null) {
            threadMessageRepository.delete(threadMessageMapper.toEntity(threadMessageDTO));
            return threadMessageDTO;
        } else {
            return null;
        }
    }
}