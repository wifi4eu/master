package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ContactPersonDTO;
import wifi4eu.wifi4eu.mapper.supplier.ContactPersonMapper;
import wifi4eu.wifi4eu.repository.supplier.ContactPersonRepository;

import java.util.List;

@Service
public class ContactPersonService {

    Logger _log = LoggerFactory.getLogger(ContactPersonService.class);

    @Autowired
    ContactPersonRepository contactPersonRepository;

    @Autowired
    ContactPersonMapper contactPersonMapper;


    public List<ContactPersonDTO> getAllContactPersons() {
        return contactPersonMapper.toDTOList(Lists.newArrayList(contactPersonRepository.findAll()));
    }

    public ContactPersonDTO getContactPersonById(Long contactPersonId) {
        return contactPersonMapper.toDTO(contactPersonRepository.findOne(contactPersonId));
    }

    public ContactPersonDTO createContactPerson(ContactPersonDTO contactPersonDTO) {
        return contactPersonMapper.toDTO(contactPersonRepository.save(contactPersonMapper.toEntity(contactPersonDTO)));
    }

}
