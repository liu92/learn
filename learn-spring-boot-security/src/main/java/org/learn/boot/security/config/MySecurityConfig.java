package org.learn.boot.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: MySecurityConfig
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 22:55
 * History:
 * @<version> 1.0
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //定制请求的授权规则, 注意下面的规则是 /level1/**, 这个地方少加了一个斜杠一直没有测试正确
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登陆功能，如果没有登陆，没有权限就会来到登陆页面
        // 默认post形式的/login代表处理登录
        // 但是当定制 longinPage，那么loginPage的post方式就是登录
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                 .loginPage("/userlogin");
//            .and()
//            .authorizeRequests()
//            .antMatchers("level1/**").hasRole("test1")
//            .antMatchers("level2/**").hasRole("test2")
//            .antMatchers("level3/**").hasRole("test3");


        //开启自动配置的注销功能
        //1、访问 /logout表示用户注销，清空session
        //2、注销成功后会返回 /login?logout页面
        //下面设置 注销成功来到首页
        http.logout().logoutSuccessUrl("/");


        //开启记住我
        http.rememberMe().rememberMeParameter("remember");
        //登录成功后，SpringSecurity 会生成一个cookie并发送给浏览器保存，以后再次访问时页面带有这个cookie,只要通过验证检查就可以免登录了
        //点击注销会删除 cookie


    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123").roles("VIP1","VIP2")
                .and()
                .withUser("lin").password("123").roles("VIP2","VIP3")
                .and()
                .withUser("lisi").password("123").roles("VIP1","VIP3")
                .and()
                //如果不设置passwordEncoder的编码方式会报错 There is no PasswordEncoder mapped for the id "null"
                .passwordEncoder(new CustomerPasswordEncoder());
    }
}









