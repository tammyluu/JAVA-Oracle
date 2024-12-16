package org.example;
@FunctionalInterface
public interface DataTransformer<T> {
    T transform(T input);
}
