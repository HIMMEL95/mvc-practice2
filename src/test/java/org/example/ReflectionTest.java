package org.example;

// @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        logger.debug("beans: [{}]", beans);
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example"); // 해당 패키지 밑에 있는 걸로 대상

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
//        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class)); // Controller annotation이 붙어 있는 class를 찾아서 해당 HashSet에 담는 코드
//        beans.addAll(reflections.getTypesAnnotatedWith(Service.class)); // Service Annotation이 붙어 있는 클래스 찾아서 HashSet에 담는 코드
        return beans;
    }
}
