package com.learning.concept.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Configuration
public class CustomAsyncConfig implements AsyncConfigurer {
    @Autowired
    private DefaultCustomAsyncException asyncException;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return this.asyncException;
    }
}

@Component
class DefaultCustomAsyncException implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("Default custom Exception " + ex);
    }
}
