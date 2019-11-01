package org.learn.boot.datasource.convert;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: CommonObjectMapper
 * @Description:
 * @Author: lin
 * @Date: 2019/10/30 23:17
 * History:
 * @<version> 1.0
 */
@Component
public class CommonObjectMapper extends ObjectMapper {

    public  CommonObjectMapper(){
        super();
        SimpleModule module = new SimpleModule("customer enum Serializer",
                new Version(1, 0 , 0,"custom-enum-jsonmodule"));
        module.addSerializer(Date.class, new DateJacksonConverter());
        this.registerModule(module);
        this.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }
}
