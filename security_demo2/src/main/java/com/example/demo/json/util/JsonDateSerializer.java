package com.example.demo.json.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Date>{
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String convertedDate = format.format(value);
		gen.writeString(convertedDate);
	}
}
