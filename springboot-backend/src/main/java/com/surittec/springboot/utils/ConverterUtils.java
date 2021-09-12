package com.surittec.springboot.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ConverterUtils {

    public static <T> T convertTo(Object source, Class<T> target, String ... ignoreProperties) {
        if (source == null)
            return null;

        try {
            T result = target.getConstructor().newInstance();
            BeanUtils.copyProperties(source, result, ignoreProperties);
            return result;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Não foi possivel realizar conversão de objeto");
        }
    }

    public static <T> T convertTo(Object source, Class<T> target) {
        return convertTo(source, target, "");
    }

}