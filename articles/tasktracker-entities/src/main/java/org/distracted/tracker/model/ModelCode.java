package org.distracted.tracker.model;

import java.text.ParseException;

import org.springframework.transaction.annotation.Transactional;

public interface ModelCode {

	@Transactional
	public abstract void test() throws ParseException;

}