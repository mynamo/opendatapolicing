package com.opendatapolicing.enus.java;

import java.io.IOException;
import java.time.LocalTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.opendatapolicing.enus.page.PageLayout;

public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

	@Override()
	public void  serialize(LocalTime o, JsonGenerator generator, SerializerProvider provider) throws IOException, IOException {
		generator.writeString(PageLayout.FORMATTimeDisplay.format(o));
	}
}
