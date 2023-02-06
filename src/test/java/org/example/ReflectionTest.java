package org.example;

// @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.

import org.example.annotation.Controller;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    void controllerScan() {
        Reflections reflections = new Reflections("org.example"); // 해당 패키지 밑에 있는 걸로 대상

        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class)); // Controller annotation이 붙어 있는 class를 찾아서 해당 HashSet에 담는 코드

        logger.debug("beans: [{}]", beans);
    }
}
