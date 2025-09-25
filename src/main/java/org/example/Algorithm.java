package org.example;

public interface Algorithm<T, R> {
    R run(T input);
}
