package wifi4eu.wifi4eu.service.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.thread.ThreadMapper;
import wifi4eu.wifi4eu.repository.thread.ThreadRepository;

@Service
public class ThreadService {
    @Autowired
    ThreadMapper threadMapper;

    @Autowired
    ThreadRepository threadRepository;
}