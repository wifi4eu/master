package wifi4eu.jagate.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date2XMLGregorianCalendarConverter {

	private static final long serialVersionUID = 7359465220012144645L;


	public static XMLGregorianCalendar convert(Date date) {

		if (date == null) {
			return null;
		}

		try {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
