package com.sufanx.quickstart.service;

public interface QuickStartService {

    void quickStart();

    void before(String param);

    boolean sayAfterReturning();

    void sayAfterThrowing();

    boolean sayAfterFinally();

    void sayAround(String param);

    void sayAdvisorBefore(String param);
}
