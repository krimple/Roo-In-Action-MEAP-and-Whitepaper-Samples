package org.distracted.tracker.model;

import static java.text.DateFormat.SHORT;

import java.text.DateFormat;
import java.text.ParseException;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.transaction.annotation.Transactional;

@RooIntegrationTest(entity = CalendarEvent.class)
public class CalendarEventIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
    
    @Test
    @Transactional
    public void testPersistAnEvent() throws ParseException {
    		DateFormat format = DateFormat.getDateTimeInstance(SHORT, SHORT);
    		CalendarEvent event = new CalendarEvent();
    		event.setName("Dr. Hack N. Slash");
    		event.setDescription("Ask him to take a little off the top...");
    		event.setDateStart(format.parse("6/21/2010 12:15 PM"));
    		event.setDateEnd(format.parse("6/21/2010 01:45 PM"));
    		event.persist();
    		event.flush();    	
    		assertNotNull("ID should not be null after persist and flush", event.getId());
    }
}
