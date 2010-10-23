package org.distracted.tracker.model;

import static java.text.DateFormat.SHORT;

import java.text.DateFormat;
import java.text.ParseException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ModelCode")
public class ModelCodeBean implements ModelCode {
	
	/* (non-Javadoc)
	 * @see org.distracted.tracker.model.ModelCode#test()
	 */
	@Transactional
	public void test() throws ParseException {
		DateFormat format = DateFormat.getDateTimeInstance(SHORT, SHORT);
		CalendarEvent event = new CalendarEvent();
		event.setName("Dr. Hack N. Slash");
		event.setDescription("Ask him to take a little off the top...");
		event.setDateStart(format.parse("6/21/2010 12:15 PM"));
		event.setDateEnd(format.parse("6/21/2010 01:45 PM"));
		event.persist();
		event.flush();    	
	}
}
