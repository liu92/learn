package org.learn.jdk.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

/**
 *  使用 WebMvcAutoConfiguration 可以来扩展springMvc的功能
 *  @EnableWebMvc 不要接管springMvc
 * @ClassName: MyConfig
 * @Description:
 * @Author: lin
 * @Date: 2019/8/29 22:28
 * History:
 * @<version> 1.0
 */
//@Configuration
public class MyConfig extends WebMvcAutoConfiguration {



//    @Bean  EmbeddedServletContainerCustomizer 这个在2.x 已经被修改了
    public TomcatServletWebServerFactory embeddedServletContainerCustomizer(){
        // 定制嵌入式的servlet容器相关的规则

        return null;
    }


//    public MyConfig(ResourceProperties resourceProperties, WebMvcProperties mvcProperties, ListableBeanFactory beanFactory,
//                    ObjectProvider<HttpMessageConverters> messageConvertersProvider,
//                    ObjectProvider<WebMvcAutoConfiguration.ResourceHandlerRegistrationCustomizer> resourceHandlerRegistrationCustomizerProvider) {
//        super(resourceProperties, mvcProperties, beanFactory, messageConvertersProvider, resourceHandlerRegistrationCustomizerProvider);
//    }
}
