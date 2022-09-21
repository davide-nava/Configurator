package com.configurator.test;

import org.junit.BeforeClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

public class UserServletUnitTest {

    private static HttpServletRequest request;
    private static HttpServletResponse response;

    @BeforeClass
    public static void setUpHttpServletRequestMockInstance() {
        request = mock(HttpServletRequest.class);
    }


}
