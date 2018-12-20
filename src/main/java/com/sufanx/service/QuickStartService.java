package com.sufanx.service;

public interface QuickStartService {

    void sayHello();

    void sayBefore(String param);

    boolean sayAfterReturning();

    void sayAfterThrowing();

    boolean sayAfterFinally();

    void sayAround(String param);

    void sayAdvisorBefore(String param);
}
