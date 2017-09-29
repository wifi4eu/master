package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.ThreadMessageMapper;
import wifi4eu.wifi4eu.repository.ThreadMessageRepository;

public class ThreadMessageService {
    @Autowired
    ThreadMessageMapper threadMessageMapper;

    @Autowired
    ThreadMessageRepository threadMessageRepository;
}