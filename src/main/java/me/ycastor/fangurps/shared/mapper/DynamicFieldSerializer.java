package me.ycastor.fangurps.shared.mapper;

import java.io.IOException;

import javax.xml.namespace.QName;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer;

public class DynamicFieldSerializer extends JsonSerializer<DynamicTag> {
    @Override
    public void serialize(DynamicTag value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ToXmlGenerator xmlGen = (ToXmlGenerator) gen;
        xmlGen.setNextName(new QName(value.tagName()));
        xmlGen.writeStartObject();
        XmlBeanSerializer serializer = (XmlBeanSerializer) serializers.findValueSerializer(value.tagName().getClass());
        JsonSerializer<Object> unwrappingSerializer = serializer.unwrappingSerializer(NameTransformer.NOP);
        unwrappingSerializer.serialize(value.tagName(), gen, serializers);
        gen.writeEndObject();
    }
}
