package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.ThreadMapper;
import wifi4eu.wifi4eu.repository.ThreadRepository;

public class ThreadService {
    @Autowired
    ThreadMapper threadMapper;

    @Autowired
    ThreadRepository threadRepository;
}