package wifi4eu.wifi4eu.util.reports;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.repository.call.CallRepository;

@Component
public class ReportTimeToGrant {

    @Autowired
    CallRepository callRepository;

    public void generate(HSSFWorkbook workbook){

    }

}
