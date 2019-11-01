package org.learn.boot.datasource.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateJacksonConverter
 * @Description:
 * @Author: lin
 * @Date: 2019/10/30 23:15
 * History:
 * @<version> 1.0
 */
@Component
public class DateJacksonConverter extends JsonSerializer<Date> {

    private static  final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (null != value){
            gen.writeString(FORMAT.format(value));
        }
    }
}
