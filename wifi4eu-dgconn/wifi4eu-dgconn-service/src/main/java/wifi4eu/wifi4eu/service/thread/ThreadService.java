package wifi4eu.wifi4eu.service.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.mapper.thread.ThreadMapper;
import wifi4eu.wifi4eu.mapper.thread.ThreadMessageMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadMessageRepository;
import wifi4eu.wifi4eu.repository.thread.ThreadRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThreadService {
    @Autowired
    ThreadMapper threadMapper;

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    ThreadMessageMapper threadMessageMapper;

    @Autowired
    ThreadMessageRepository threadMessageRepository;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    MunicipalityService municipalityService;

    public ThreadDTO getThreadById(int threadId) {
        return threadMapper.toDTO(threadRepository.findOne(threadId));
    }

    public ThreadDTO setMediationToThread(int threadId) {
        ThreadDTO threadDTO = getThreadById(threadId);
        if(!threadDTO.isMediation()){
            threadDTO.setMediation(true);
        }
        threadDTO.setMessages(null);
        return threadMapper.toDTO(threadRepository.save(threadMapper.toEntity(threadDTO)));
    }

    @Transactional
    public ThreadDTO createThread(ThreadDTO threadDTO) {
        if (threadDTO.getMessages() == null) {
            return threadMapper.toDTO(threadRepository.save(threadMapper.toEntity(threadDTO)));
        } else {
            if (threadDTO.getMessages().isEmpty()) {
                return threadMapper.toDTO(threadRepository.save(threadMapper.toEntity(threadDTO)));
            } else {
                Integer threadId = threadDTO.getId();
                List<ThreadMessageDTO> originalMessages = threadDTO.getMessages();
                List<ThreadMessageDTO> correctMessages = new ArrayList<>();
                if (threadId == 0) {
                    threadDTO.setMessages(null);
                    threadDTO = threadMapper.toDTO(threadRepository.save(threadMapper.toEntity(threadDTO)));
                    threadId = threadDTO.getId();
                }
                for (ThreadMessageDTO message : originalMessages) {
                    message.setThreadId(threadId);
                    correctMessages.add(message);
                }
                threadDTO.setMessages(correctMessages);
                return threadMapper.toDTO(threadRepository.save(threadMapper.toEntity(threadDTO)));
            }
        }
    }

    public ThreadDTO getThreadByTypeAndReason(int type, String reason) {
        return threadMapper.toDTO(threadRepository.findByTypeAndReason(type, reason));
    }
}