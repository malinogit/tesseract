package com.mal.tesseract.configuration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class BeanInitializer {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.quitwait", false);
        javaMailSender.setHost("smtp.wp.pl");
        javaMailSender.setPort(25);
        javaMailSender.setProtocol("smtp");
        javaMailSender.setUsername("neton00001@wp.pl");
        javaMailSender.setPassword("1qazxsw2");
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    @Bean
    public ServletContextInitializer initializer() {

        return servletContext -> servletContext.setInitParameter("contextConfiguration", "resource/servlet-context.xml");
    }
}
