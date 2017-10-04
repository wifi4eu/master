package wifi4eu.wifi4eu.service.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.thread.ThreadMessageMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadMessageRepository;

@Service
public class ThreadMessageService {
    @Autowired
    ThreadMessageMapper threadMessageMapper;

    @Autowired
    ThreadMessageRepository threadMessageRepository;
}