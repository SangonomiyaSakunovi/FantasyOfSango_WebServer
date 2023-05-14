package com.fantasy.sangoCommon.utils;


import com.fantasy.sangoCommon.entity.CommonResult;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CommonResultSerializer extends JsonSerializer<CommonResult<?>> {
    @Override
    public void serialize(CommonResult<?> commonResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeNumber(commonResult.getCode());
        jsonGenerator.writeFieldName("message");
        jsonGenerator.writeString(commonResult.getMessage());
        jsonGenerator.writeObjectField("data", commonResult.getData());
        jsonGenerator.writeEndObject();
    }
}

