package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.CallMapper;
import wifi4eu.wifi4eu.repository.CallRepository;

public class CallService {
    @Autowired
    CallMapper callMapper;

    @Autowired
    CallRepository callRepository;
}