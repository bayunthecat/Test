package com.lwd.platform.testing.repo.tools.impl;

import com.lwd.platform.testing.repo.tools.IdInjectionStrategy;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO implement logging with AOP later, somehow

@Component
public class DefaultIdInjectionStrategy implements IdInjectionStrategy {

    private static final Logger LOG = Logger.getLogger(DefaultIdInjectionStrategy.class);

    @Override
    public Object injectId(Object object, Object id) {
        Field field = getRequiredField(object);
        if (field != null) {
            setValue(field, object, id);
        }
        return object;
    }

    @Override
    public Serializable getId(Object object) {
        Field field = getRequiredField(object);
        if (field != null) {
            return (Serializable) getValue(field, object);
        }
        return null;
    }

    private Field getRequiredField(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = getAllFields(clazz, new ArrayList<>());
        for (Field field : fields) {
            if (containAnnotation(field, Id.class)) {
                return field;
            }
        }
        return null;
    }

    private Field[] getAllFields(Class<?> clazz, List<Field> fields) {
        if (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            getAllFields(clazz.getSuperclass(), fields);
        }
        return fields.toArray(new Field[]{});
    }

    private Object getValue(Field field, Object object) {
        Object value = null;
        try {
            if (field.isAccessible()) {
                value = field.get(object);
            } else {
                field.setAccessible(true);
                value = field.get(object);
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            LOG.error(e.getMessage());
        }
        return value;
    }

    private void setValue(Field field, Object object, Object id) {
        try {
            if (field.isAccessible()) {
                field.set(object, id);
            } else {
                field.setAccessible(true);
                field.set(object, id);
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            LOG.error(e.getMessage());
        }
    }

    private boolean containAnnotation(AnnotatedElement element, Class<?> annotation) {
        Annotation[] annotations = element.getAnnotations();
        for (Annotation a : annotations) {
            if (a.annotationType().equals(annotation)) {
                return true;
            }
        }
        return false;
    }

}
