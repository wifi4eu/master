package wifi4eu.wifi4eu.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskTicketDTO;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.util.ScheduledTasks;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value={ScheduledTasks.class, HelpdeskService.class, DataOutputStream.class})
@PowerMockIgnore("javax.management.*")
public class ScheduleTaskTest {
	
	private final String CYRILLIC_ALPHABET = "А а,Б б,В в,Г г,Д д,Е е,Ж ж,З з,И и,Й й,К к,Л л,М м,Н н,О о,П п,Р р,С с,Т т,У у,Ф ф,Х х,Ц ц,Ч ч,Ш ш,Щ щ,Ь ь";

	private final String GERMAN_ALPHABET = "Ä ä, Ö ö, Ü ü, ẞ ß ";
	private final String SPANISH_ALPHABET = "á é í ó ú ¿ ¡ ü ñ ";
	private final String PORTUGUESE_ALPHABET = "à, À, á, Á, ã, Ã, ç, Ç, é, É, ê, Ê, Í, í, ó, Ó, ú, Ú, ü, Ü ";
	
	private final String GREEK_ALPHABET = "Α α,Β β,Γ γ,Δ δ,Ε ε,Ζ ζ,Η η,Θ θ,Ι ι,Κ κ,Λ λ,Μ μ,Ν ν,Ξ ξ,Ο ο,Π π,Ρ ρ,Σ σ/ς,Τ τ,Υ υ,Φ φ,Χ χ,Ψ ψ,Ω ω";
	
	@Mock
	private HelpdeskService helpdeskServiceMock;
	
	@InjectMocks
	private ScheduledTasks scheduledTasks;
	
	@Before
	public void setup() throws Exception {
	}	
	
	/**
	 * Testing the POSTING of issues to the third party system
	 * 
	 * @throws Exception
	 */
	@Test
	public void executePost_test() throws Exception {
		DataOutputStream dataOutputStreamMock = PowerMockito.mock(DataOutputStream.class);
		HttpURLConnection httpURLConnectionMock = PowerMockito.mock(HttpURLConnection.class);
		StringBuilder stringBuilderMock = PowerMockito.mock(StringBuilder.class);
		URL urlMock = PowerMockito.mock(URL.class);
		InputStream inputStreamMock = PowerMockito.mock(InputStream.class);
		BufferedReader bufferedReaderMock = PowerMockito.mock(BufferedReader.class);
		
		PowerMockito.when(stringBuilderMock.toString()).thenReturn("Thankyou.js");
		
		PowerMockito.whenNew(URL.class).withAnyArguments().thenReturn(urlMock);
		PowerMockito.when(urlMock.openConnection()).thenReturn(httpURLConnectionMock);
		PowerMockito.when(httpURLConnectionMock.getInputStream()).thenReturn(inputStreamMock);
		PowerMockito.whenNew(BufferedReader.class).withAnyArguments().thenReturn(bufferedReaderMock);
		PowerMockito.whenNew(DataOutputStream.class).withAnyArguments().thenReturn(dataOutputStreamMock);
		PowerMockito.whenNew(StringBuilder.class).withAnyArguments().thenReturn(stringBuilderMock);

		PowerMockito.when(stringBuilderMock.toString()).thenReturn("");
        HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();
        
        ScheduledTasks.executePost("mock.url", helpdeskTicketDTO.toString());
        Mockito.verify(dataOutputStreamMock, Mockito.times(1)).writeBytes(Mockito.anyString());
	}

	/**
	 * Testing if all messages read from database are being marked as sent
	 * @throws Exception
	 */
//	@Test
	public void scheduleHelpdeskIssues_test() throws Exception {
		HelpdeskIssueDTO helpdeskIssueDTO1 = new HelpdeskIssueDTO();
		helpdeskIssueDTO1.setId(1);
		helpdeskIssueDTO1.setTicket(false);

		HelpdeskIssueDTO helpdeskIssueDTO2 = new HelpdeskIssueDTO();
		helpdeskIssueDTO1.setId(2);
		helpdeskIssueDTO1.setTicket(false);
		
		HelpdeskIssueDTO helpdeskIssueDTO3 = new HelpdeskIssueDTO();
		helpdeskIssueDTO1.setId(3);
		helpdeskIssueDTO1.setTicket(false);
		
		List<HelpdeskIssueDTO> listHelpdeskInssueDTOs = Arrays.asList(helpdeskIssueDTO1, helpdeskIssueDTO2, helpdeskIssueDTO3);
		
		DataOutputStream dataOutputStreamMock = PowerMockito.mock(DataOutputStream.class);
		HttpURLConnection httpURLConnectionMock = PowerMockito.mock(HttpURLConnection.class);
		StringBuilder stringBuilderMock = PowerMockito.mock(StringBuilder.class);
		InputStream inputStreamMock = PowerMockito.mock(InputStream.class);
		BufferedReader bufferedReaderMock = PowerMockito.mock(BufferedReader.class);
		
		PowerMockito.when(this.helpdeskServiceMock.getAllHelpdeskIssueNoSubmited()).thenReturn(listHelpdeskInssueDTOs);

		PowerMockito.when(httpURLConnectionMock.getInputStream()).thenReturn(inputStreamMock);
		PowerMockito.whenNew(BufferedReader.class).withAnyArguments().thenReturn(bufferedReaderMock);
		PowerMockito.whenNew(DataOutputStream.class).withAnyArguments().thenReturn(dataOutputStreamMock);
		PowerMockito.whenNew(StringBuilder.class).withAnyArguments().thenReturn(stringBuilderMock);

		PowerMockito.when(stringBuilderMock.toString()).thenReturn("");
        HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();
        helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());

        ScheduledTasks.executePost("https://webtools.ec.europa.eu/form-tools/process.php", helpdeskTicketDTO.toString());
        Mockito.verify(dataOutputStreamMock, Mockito.times(1)).writeBytes(Mockito.anyString());
	}

	/**
	 * A code to test if the Serco System was creating the tickets on its system.
	 * @throws Exception
	 */
//	@Test
	public void executePost() throws Exception {
        String prodUrl = "https://webtools.ec.europa.eu/form-tools/process.php";
        String testUrl = "https://webgate.acceptance.ec.europa.eu/fpfis/webtools/form-tools/process.php";

        HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();
		helpdeskTicketDTO.setForm_tools_form_id("1047");
		helpdeskTicketDTO.setEmailAdress("fkaswine@everis.com");
		helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());
		helpdeskTicketDTO.setUuid("wifi4eu_368");
		helpdeskTicketDTO.setFirstname("TESTER FIRST NAME");
		helpdeskTicketDTO.setLastname("TESTER SUR NAME");
		helpdeskTicketDTO.setTxtsubjext("TEST TOPIC / SUBJECT (GERMAN/SPANISH/PORTUGUESE)");

        String encodedQuestion = URLEncoder.encode(this.GERMAN_ALPHABET + "|" + this.SPANISH_ALPHABET + "|" + this.PORTUGUESE_ALPHABET, "UTF-8");

		helpdeskTicketDTO.setQuestion(encodedQuestion);

        String response = ScheduledTasks.executePost(testUrl, helpdeskTicketDTO.toString());
        System.out.println(response);
	}


}
