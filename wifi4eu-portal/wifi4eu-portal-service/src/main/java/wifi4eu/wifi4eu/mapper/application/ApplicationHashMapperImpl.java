package wifi4eu.wifi4eu.mapper.application;


import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationHashMapperImpl extends ApplicationMapperImpl {

    public Map<Integer, ApplicationDTO> toDTOMap(List<Application> list){
        if ( list == null ) {
            return null;
        }

        Map<Integer, ApplicationDTO> map_ = new HashMap<>();
        int index =0;
        for ( Application application : list ) {
            map_.put( index, toDTO( application ) );
            index++;
        }

        return map_;

    }

}
