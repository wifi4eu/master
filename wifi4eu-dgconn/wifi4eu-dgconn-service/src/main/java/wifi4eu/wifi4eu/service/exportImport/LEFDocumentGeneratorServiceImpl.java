package wifi4eu.wifi4eu.service.exportImport;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;
import wifi4eu.wifi4eu.entity.mayor.Mayor;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.representation.Representation;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.repository.representation.RepresentationRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional()
public class LEFDocumentGeneratorServiceImpl implements LEFDocumentGeneratorService {

    private static final Logger _log = LoggerFactory.getLogger(LEFDocumentGeneratorServiceImpl.class);

    //supports all european languages, including Greek and Cyrillic, and gives small pdf documents when embedding
    private static final String UNICODE_FONT = "NotoSans-Regular.ttf";

    private static final int MARGINS = 30;
    private static final int TITLE_LEADING = 40;
    private static final int REPRESENTATION_LEADING = 20;

    private CharsetEncoder WIN_LATIN1_ENCODER = Charset.forName("windows-1252").newEncoder();

    @Value("${lef.document.generator.filename.prefix}")
    private String lefFileName;

    @Value("${lef.document.generator.separator:' : '}")
    private String separator;

    @Value("${lef.document.generator.title}")
    private String lefFileTitle;

    @Value("${lef.document.generator.municipality.title}")
    private String lefMuncipalityTitle;

    @Value("${lef.document.generator.municipality.field.id}")
    private String lefMuncipalityFieldId;

    @Value("${lef.document.generator.municipality.field.name}")
    private String lefMuncipalityFieldName;

    @Value("${lef.document.generator.municipality.field.name.abac}")
    private String lefMuncipalityFieldAbacName;

    @Value("${lef.document.generator.municipality.field.adress}")
    private String lefMuncipalityFieldAdress;

    @Value("${lef.document.generator.municipality.field.postcode}")
    private String lefMuncipalityFieldPostcode;

    @Value("${lef.document.generator.municipality.field.countrycode}")
    private String lefMuncipalityFieldCountrycode;

    @Value("${lef.document.generator.mayor.title}")
    private String lefMayorTitle;

    @Value("${lef.document.generator.mayor.field.id}")
    private String lefMayorFieldId;

    @Value("${lef.document.generator.mayor.field.name}")
    private String lefMayorFieldName;

    @Value("${lef.document.generator.mayor.field.surname}")
    private String lefMayorFieldSurname;

    @Value("${lef.document.generator.mayor.field.email}")
    private String lefMayorFieldEmail;

    @Value("${lef.document.generator.representation.title}")
    private String lefRepresentationTitle;

    @Value("${lef.docment.generator.footer.date.text}")
    private String lefFooterText;

    @Value("${lef.document.generator.footer.dateFormat:'E yyyy.MM.dd - hh:mm:ss a zzz'}")
    private String dateFormat;

    private SimpleDateFormat dateFormater;

    public SimpleDateFormat getDateFormater() {
        if (dateFormater == null) {
            dateFormater = new SimpleDateFormat(dateFormat);
        }
        return dateFormater;
    }

    @Autowired
    private MayorRepository mayorRepository;

    @Autowired
    private RepresentationRepository representationRepository;

    @Override
    public OutputStream generateLefPdf(Municipality municipality, OutputStream os) {

        Document document = new Document(PageSize.A4, MARGINS, MARGINS, MARGINS, MARGINS);

        try {
            _log.debug("Generating LEF supporting document for municipality {}", municipality.getId());

            //gather all data we will need to write first to check the encoding, needed to optimize document size
            String municipalityParagraphText = createPdfMunicipalityText(municipality);
            String mayorParagraphText = null;
            final List<String> representationsParagraphTextList = new ArrayList<>();

            Mayor mayor = mayorRepository.findByMunicipalityId(municipality.getId());
            if (mayor != null) {
                mayorParagraphText = createPdfMayorString(mayor);
            }
            Iterable<Representation> representations = representationRepository.findByMunicipalityId(municipality.getId());
            if (representations.iterator().hasNext()) {
                representations.forEach(representation -> {
                    representationsParagraphTextList.add(createPdfMayorString(representation.getMayor()));
                });
            }

            //in order to select a proper font, we need to check which encoding the document will need to support, latin1 or unicode?
            boolean needsUnicode = false;
            if (!WIN_LATIN1_ENCODER.canEncode(municipalityParagraphText)) {
                needsUnicode = true;
            } else if (mayorParagraphText != null && !WIN_LATIN1_ENCODER.canEncode(mayorParagraphText)) {
                needsUnicode = true;
            } else {
                Iterator<String> representationIterator = representationsParagraphTextList.iterator();
                for (String representationText = representationIterator.next(); representationIterator.hasNext() && !needsUnicode;) {
                    needsUnicode = !WIN_LATIN1_ENCODER.canEncode(representationText);
                }
            }

            _log.debug("Municipality {} is in unicode {} ", municipality.getId(), needsUnicode);

            //pickup the right font
            BaseFont documentFont;
            if (needsUnicode) {
                //the data contains unicode characters outside Latin1, set a font that can show those
                documentFont = BaseFont.createFont(UNICODE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                documentFont.setSubset(true);
            } else {
                //the data is only latin1, we can use a pdf default font and reduce the size of the final document significantly (10x)
                documentFont = BaseFont.createFont();
            }

            //create all the font styles
            Font pageTitleFont  = new Font(documentFont, 24, Font.BOLD);
            Font tittleFont = new Font(documentFont, 18, Font.BOLD);
            Font paragraphFont = new Font(documentFont, 12);
            Font footerFont = new Font(documentFont, 10);

            //create the PDF document
            PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
            document.open();
            document.addTitle(lefFileTitle);

            Paragraph titlePar = new Paragraph(lefFileTitle, pageTitleFont);
            titlePar.setAlignment(Element.ALIGN_CENTER);
            titlePar.setSpacingAfter(20);
            document.add(titlePar);

            document.add(new Paragraph(lefMuncipalityTitle, tittleFont));
            document.add(new Paragraph(municipalityParagraphText, paragraphFont));

            if (StringUtils.isNotEmpty(mayorParagraphText)) {
                document.add(new Paragraph(TITLE_LEADING, lefMayorTitle, tittleFont));
                document.add(new Paragraph(mayorParagraphText.toString(), paragraphFont));
            }

            if (!representationsParagraphTextList.isEmpty()) {
                document.add(new Paragraph(TITLE_LEADING, lefRepresentationTitle, tittleFont));
                for (int i = 0; i < representationsParagraphTextList.size(); i++) {
                    int leading = (i==0)? 0 : REPRESENTATION_LEADING;
                    document.add(new Paragraph(leading, representationsParagraphTextList.get(i), paragraphFont));
                }
            }

            //add footer with date of generation
            String footerText = lefFooterText + separator + getDateFormater().format(System.currentTimeMillis());
            ColumnText.showTextAligned(pdfWriter.getDirectContent(), Element.ALIGN_CENTER, new Phrase(footerText, footerFont), 298, 20+MARGINS, 0);

            document.close();
        } catch (DocumentException | IOException e) {
            _log.error("Unable to generate PDF for the Municipality {}", municipality.getId(), e);
            throw new RuntimeException("Unable to generate PDF for the Municipality " + municipality.getId(), e);
        }
        return os;
    }

    private String createPdfMunicipalityText(Municipality municipality) {
        StringBuilder municipalityParagraphText = new StringBuilder();
        municipalityParagraphText.append(lefMuncipalityFieldId).append(separator).append(municipality.getId()).append("\n");
        municipalityParagraphText.append(lefMuncipalityFieldName).append(separator).append(municipality.getName()).append("\n");
        List<ExportImportRegistrationData> municipalitiesAbac = municipality.getMunicipalitiesAbac();
        if (!municipalitiesAbac.isEmpty()) {
            String abacName = municipalitiesAbac.get(0).getAbacStandarName();
            if (StringUtils.isNotEmpty(abacName)) {
                municipalityParagraphText.append(lefMuncipalityFieldAbacName).append(separator).append(abacName).append("\n");
            }
        }
        municipalityParagraphText.append(lefMuncipalityFieldAdress).append(separator).append(municipality.getAddress()).append("\n");
        municipalityParagraphText.append(lefMuncipalityFieldPostcode).append(separator).append(municipality.getPostalCode()).append("\n");
        municipalityParagraphText.append(lefMuncipalityFieldCountrycode).append(separator).append(municipality.getCountry()).append("\n");
        return municipalityParagraphText.toString();
    }

    private String createPdfMayorString(Mayor mayor) {
        StringBuilder mayorParagraphText = new StringBuilder();
        mayorParagraphText.append(lefMayorFieldId).append(separator).append(mayor.getId()).append("\n");
        mayorParagraphText.append(lefMayorFieldName).append(separator).append(mayor.getName()).append("\n");
        mayorParagraphText.append(lefMayorFieldSurname).append(separator).append(mayor.getSurname()).append("\n");
        mayorParagraphText.append(lefMayorFieldEmail).append(separator).append(mayor.getEmail()).append("\n");
        return mayorParagraphText.toString();
    }

}
