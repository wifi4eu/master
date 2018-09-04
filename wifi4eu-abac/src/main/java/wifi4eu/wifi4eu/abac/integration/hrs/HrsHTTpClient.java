package wifi4eu.wifi4eu.abac.integration.hrs;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.integration.EcasProxyTicketClient;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

public class HrsHTTpClient {

    private final Logger log = LoggerFactory.getLogger(HrsHTTpClient.class);

    private final String hrsHttpServiceEndpoint;
    private final String hrsJobAccountUser;
    private final String hrsApplicationID;
    private EcasProxyTicketClient ecasProxyTicketClient;
    private final Boolean useFakeTicket;
    private final String fakeTicket;

    public HrsHTTpClient(String hrsHttpServiceEndpoint, String hrsJobAccountUser, String hrsApplicationID, EcasProxyTicketClient ecasProxyTicketClient, Boolean useFakeTicket, String fakeTicket) {
        this.hrsHttpServiceEndpoint = hrsHttpServiceEndpoint;
        this.hrsJobAccountUser = hrsJobAccountUser;
        this.hrsApplicationID = hrsApplicationID;
        this.ecasProxyTicketClient = ecasProxyTicketClient;
        this.useFakeTicket = useFakeTicket;
        this.fakeTicket = fakeTicket;
    }

    public String uploadAttachment(Document document) throws Exception {
        PostMethod filePost = new PostMethod(hrsHttpServiceEndpoint);

        try {
            final byte[] documentToUpload = IOUtils.toByteArray(new ByteArrayInputStream(document.getData()));
            Part[] parts = {new FilePart("data", new PartSource() {

                public long getLength() {
                    return documentToUpload.length;
                }

                public String getFileName() {
                    return "test.pdf";
                }

                public InputStream createInputStream() {
                    return new ByteArrayInputStream(documentToUpload);
                }
            }, "application/octet-stream", "UTF-8")};

            filePost.setRequestHeader(new Header("X-HRS-USER", hrsJobAccountUser));
            filePost.setRequestHeader(new Header("X-HRS-TICKET", (useFakeTicket)? fakeTicket : ecasProxyTicketClient.getEcasServiceTicket(hrsHttpServiceEndpoint)));
            filePost.setRequestHeader(new Header("X-HRS-APPLICATION", hrsApplicationID));
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            HttpClient client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            int status = client.executeMethod(filePost);
            if (status == HttpStatus.SC_OK) {
                log.info("Upload complete for doc {}, response=", filePost.getResponseBodyAsString());
                return getHermesAttachmentId(filePost.getResponseBodyAsString());
            } else {
                log.error("Upload failed for doc {}, status={}", document.getId(), HttpStatus.getStatusText(status)
                        + " response=" + filePost.getResponseBodyAsString());
            }
        } finally {
            filePost.releaseConnection();
        }

        return null;
    }


    private String getHermesAttachmentId(String xmlResponse) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xmlResponse));

        org.w3c.dom.Document doc = builder.parse(src);
        String attachmentId = doc.getElementsByTagName("content-id").item(0).getTextContent();

        return  attachmentId;
    }
}
