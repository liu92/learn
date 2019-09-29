package org.learn.boot.demo.listener;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *  测试 SpringApplicationRunListener 监听, 如何让其生效呢？ApplicationContextInitializer和
 *  SpringApplicationRunListener要让其进行配置到 META-INF/spring.factories文件中
 *
 * @ClassName: HelloSpringApplicationRunListeners
 * @Description:
 * @Author: lin
 * @Date: 2019/9/6 17:02
 * History:
 * @<version> 1.0
 */
public class HelloSpringApplicationRunListeners implements SpringApplicationRunListener {

    /**
     * 如果在启动 报错
     * java.lang.NoSuchMethodException: org.learn.boot.demo.listener.
     * HelloSpringApplicationRunListeners.<init>(org.springframework.boot.SpringApplication, [Ljava.lang.String;)
     * 这是因为在HelloSpringApplicationRunListeners 在是SpringApplicationRunListener 接口是没有 有参的构造器
     *
     */
    public HelloSpringApplicationRunListeners(SpringApplication application, String[] args){

    }


    /**
     * Called immediately when the run method has first started. Can be used for very
     * early initialization.
     */
    @Override
    public void starting() {
       System.out.println("SpringApplicationRunListener...starting...IOC容器还没有创建之前starting...");
    }

    /**
     * Called once the environment has been prepared, but before the
     * {@link ApplicationContext} has been created.
     *
     * @param environment the environment
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener...environmentPrepared...环境准备"+o);
    }

    /**
     * Called once the {@link ApplicationContext} has been created and prepared, but
     * before sources have been loaded.
     *
     * @param context the application context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextPrepared...IOC容器准备好了");
    }

    /**
     * Called once the application context has been loaded but before it has been
     * refreshed.
     *
     * @param context the application context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded...容器环境已经加载完成");
    }

    /**
     * The context has been refreshed and the application has started but
     * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
     * ApplicationRunners} have not been called.
     *
     * @param context the application context.
     * @since 2.0.0
     */
    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...started...上下文已刷新，应用程序已启动但是 尚未调用ApplicationRunner和CommandLineRunner");
    }

    /**
     * Called immediately before the run method finishes, when the application context has
     * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
     * {@link ApplicationRunner ApplicationRunners} have been called.
     *
     * @param context the application context.
     * @since 2.0.0
     */
    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...running...在run方法完成前立即调用，刷新应用程序并调用ApplicationRunner和CommandLineRunner");
    }

    /**
     * Called when a failure occurs when running the application.
     *
     * @param context   the application context or {@code null} if a failure occurred before
     *                  the context was created
     * @param exception the failure
     * @since 2.0.0
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListener...failed...在应用程序发生故障时调用");
    }
}
