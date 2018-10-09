package wifi4eu.wifi4eu.service.helpdesk;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.mapper.helpdesk.HelpdeskCommentMapper;
import wifi4eu.wifi4eu.common.mapper.helpdesk.HelpdeskMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskCommentRepository;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class HelpdeskService {

    Logger _log = LoggerFactory.getLogger(HelpdeskService.class);

    private static final String CSV_FILE_NAME = "issues.csv";

    @Autowired
    HelpdeskRepository helpdeskRepository;

    @Autowired
    HelpdeskMapper helpdeskMapper;

    @Autowired
    HelpdeskCommentRepository helpdeskCommentRepository;

    @Autowired
    HelpdeskCommentMapper helpdeskCommentMapper;

    public List<HelpdeskIssueDTO> getAllHelpdeskIssues() {
        return helpdeskMapper.toDTOList(Lists.newArrayList(helpdeskRepository.findAll()));
    }

    public HelpdeskIssueDTO getHelpdeskIssue(Long issueId) {
        return helpdeskMapper.toDTO(helpdeskRepository.findOne(issueId));
    }

    public HelpdeskIssueDTO createHelpdeskIssue(HelpdeskIssueDTO helpdeskDTO) {
        return helpdeskMapper.toDTO(helpdeskRepository.save(helpdeskMapper.toEntity(helpdeskDTO)));
    }

    public HelpdeskCommentDTO createHelpdeskComment(HelpdeskCommentDTO helpdeskCommentDTO) {
        return helpdeskCommentMapper.toDTO(helpdeskCommentRepository.save(helpdeskCommentMapper.toEntity(helpdeskCommentDTO)));
    }

    public List<HelpdeskCommentDTO> getHelpdeskIssueComments(Long issueId) {
        return helpdeskCommentMapper.toDTOList(Lists.newArrayList(helpdeskCommentRepository.findByIssueId(issueId)));
    }

    public File exportHelpdeskIssues() {
        List<HelpdeskIssueDTO> issues = helpdeskMapper.toDTOList(Lists.newArrayList(helpdeskRepository.findAll()));
        File csv = new File(CSV_FILE_NAME);

        ICsvBeanWriter beanWriter = null;
        CellProcessor[] processors = new CellProcessor[] {
                new ParseLong(), // issueId
                new NotNull(), // portal
                new NotNull(), // topic
                new NotNull(), // memberState
                new FmtDate("MM/dd/yyyy"), // date
                new NotNull(), // assignedTo
                new NotNull(), // status
                new NotNull(), // from
                new NotNull(), // issueSummary
        };

        try {
            beanWriter = new CsvBeanWriter(new FileWriter(csv), CsvPreference.STANDARD_PREFERENCE);
            String[] header = {"issueId", "portal", "topic", "memberState", "date", "assignedTo", "status", "from", "issueSummary"};
            beanWriter.writeHeader(header);

            for (HelpdeskIssueDTO issue : issues) {
                _log.info("Issue summary:");
                _log.info(issue.getIssueSummary());

                beanWriter.write(issue, header, processors);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (beanWriter != null) {
                try {
                    beanWriter.close();
                } catch (IOException e) {
                    System.err.println("Error closing the writer: " + e);
                }
            }
        }

        return csv;
    }

}
