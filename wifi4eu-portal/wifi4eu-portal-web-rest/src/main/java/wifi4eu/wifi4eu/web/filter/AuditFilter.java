package wifi4eu.wifi4eu.web.filter;


import org.apache.commons.io.output.TeeOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.dto.audit.AuditDataDTO;
import wifi4eu.wifi4eu.service.audit.AuditService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

//import wifi4eu.wifi4eu.service.security.UserRetrieverHelper;

public class AuditFilter extends OncePerRequestFilter {

    private static final Logger logger = LogManager.getLogger(AuditFilter.class);

    @Autowired
    private AuditService auditService;

    @Autowired
//    private UserRetrieverHelper userRetrieverHelper;

    @Override
    protected String getAlreadyFilteredAttributeName() {
        return "AuditFilter";
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
    }

    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {

        try{

            BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpServletRequest);
            BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);

            filterChain.doFilter (bufferedRequest, bufferedResponse);

            if(bufferedRequest.getServletPath().contains("api")) {

                String auth = bufferedRequest.getHeader("Authorization");

                Long userId = 0L; //If user is not logged in, userId = 0

                if(auth != null ) {
                    String cleanToken = auth.substring(7);

//                    userId = userRetrieverHelper.getUserId(cleanToken);
                }

                AuditDataDTO auditDataDTO = new AuditDataDTO(httpServletRequest.getPathInfo(), httpServletRequest.getMethod(), bufferedRequest.getRequestBody(), bufferedResponse.getContent(), userId);
                auditService.createAuditData(auditDataDTO);
            }

            bufferedResponse.finish();

        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /*private Map<String, String> getTypeSafeRequestMap(HttpServletRequest request) {
        Map<String, String> typeSafeRequestMap = new HashMap<>();
        Enumeration<?> requestParamNames = request.getParameterNames();
        while (requestParamNames.hasMoreElements()) {
            String requestParamName = (String)requestParamNames.nextElement();
            String requestParamValue = request.getParameter(requestParamName);
            typeSafeRequestMap.put(requestParamName, requestParamValue);
        }
        return typeSafeRequestMap;
    }*/



    private static final class BufferedRequestWrapper extends HttpServletRequestWrapper {

        private ByteArrayInputStream bais = null;
        private ByteArrayOutputStream baos = null;
        private BufferedServletInputStream bsis = null;
        private byte[] buffer = null;


        public BufferedRequestWrapper(HttpServletRequest req) throws IOException {
            super(req);
            // Read InputStream and store its content in a buffer.
            InputStream is = req.getInputStream();
            this.baos = new ByteArrayOutputStream();
            byte buf[] = new byte[1024];
            int letti;
            while ((letti = is.read(buf)) > 0) {
                this.baos.write(buf, 0, letti);
            }
            this.buffer = this.baos.toByteArray();
        }


        @Override
        public ServletInputStream getInputStream() {
            this.bais = new ByteArrayInputStream(this.buffer);
            this.bsis = new BufferedServletInputStream(this.bais);
            return this.bsis;
        }



        String getRequestBody() throws IOException  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getInputStream()));
            String line = null;
            StringBuilder inputBuffer = new StringBuilder();
            do {
                line = reader.readLine();
                if (null != line) {
                    inputBuffer.append(line.trim());
                }
            } while (line != null);
            reader.close();
            return inputBuffer.toString().trim();
        }

    }

    private static final class BufferedServletInputStream extends ServletInputStream {

        private ByteArrayInputStream bais;

        public BufferedServletInputStream(ByteArrayInputStream bais) {
            this.bais = bais;
        }

        @Override
        public int available() {
            return this.bais.available();
        }

        @Override
        public int read() {
            return this.bais.read();
        }

        @Override
        public int read(byte[] buf, int off, int len) {
            return this.bais.read(buf, off, len);
        }


    }

    public class TeeServletOutputStream extends ServletOutputStream {

        private final TeeOutputStream targetStream;

        public TeeServletOutputStream( OutputStream one, OutputStream two ) {
            targetStream = new TeeOutputStream( one, two);
        }

        @Override
        public void write(int arg0) throws IOException {
            this.targetStream.write(arg0);
        }

        public void flush() throws IOException {
            super.flush();
            this.targetStream.flush();
        }

        public void close() throws IOException {
            super.close();
            this.targetStream.close();
        }
    }

    public class BufferedResponseWrapper extends HttpServletResponseWrapper {

        TeeServletOutputStream tee;
        ByteArrayOutputStream bos;

        public BufferedResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        public String getContent() {
            return bos.toString();
        }

        public PrintWriter getWriter() throws IOException {
            return getResponse().getWriter();
        }

        public ServletOutputStream getOutputStream() throws IOException {
            if( tee == null ){
                bos = new ByteArrayOutputStream();
                tee = new TeeServletOutputStream( getResponse().getOutputStream(), bos );
            }
            return tee;

        }

        public void finish() throws IOException {
            if (this.tee != null) {
                this.tee.close();
            }
            if (this.tee != null) {
                this.tee.close();
            }
        }

    }

}
