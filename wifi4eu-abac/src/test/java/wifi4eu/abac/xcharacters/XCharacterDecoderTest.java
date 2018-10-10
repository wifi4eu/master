package wifi4eu.abac.xcharacters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wifi4eu.wifi4eu.abac.utils.XCharacterDecoder;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class XCharacterDecoderTest {

    @Test
    public void testDecodeAbacCharsGreek(){
        assertEquals("ABAC characters replace", "Libadia Ammokhostou", XCharacterDecoder.decode("Λιβάδια Αμμοχώστου"));
    }

    @Test
    public void testDecodeAbacChars(){
        assertEquals("ABAC characters replace", "AAAAAAECEEEEIIIIDNOOOOOOUUUUYss", XCharacterDecoder.decode("ÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝß"));
        assertEquals("ABAC characters replace Òdena", "Odena", XCharacterDecoder.decode("Òdena"));
    }
}
