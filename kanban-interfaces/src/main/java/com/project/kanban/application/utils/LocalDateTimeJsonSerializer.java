package com.project.kanban.application.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.project.kanban.application.utils.CommonFormmater.FORMATTED_YYYYMMDDHHMMSS;

public final class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {

	@Override
	public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeString(FORMATTED_YYYYMMDDHHMMSS.format(value));
	}
}
