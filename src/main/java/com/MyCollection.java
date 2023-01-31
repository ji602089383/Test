package com;

import java.util.Iterator;

/**
 * @author jicai 2023-01-18
 */
public interface MyCollection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(T t);

    boolean add(T t);

    boolean remove(T t);

    @Override
    Iterator<T> iterator();

    public static <T> void print(MyCollection<T> coll){
        for (T t : coll){
            System.out.println(t.toString());
        }
    }
}
