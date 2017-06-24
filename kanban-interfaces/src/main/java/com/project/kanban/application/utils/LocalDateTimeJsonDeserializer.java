package com.project.kanban.application.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.project.kanban.application.utils.CommonFormmater.FORMATTED_YYYYMMDDHHMMSS;

public final class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		return LocalDateTime.parse(p.getText(), FORMATTED_YYYYMMDDHHMMSS);
	}
}
