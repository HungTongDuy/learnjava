package com.example.demo.GenericType;

public class MyGeneric<T> {

    private T tobject;

    public MyGeneric(Class<T> tclass) throws IllegalAccessException, InstantiationException {
        this.tobject = (T) tclass.newInstance();
    }

    public T getTobject() {
        return tobject;
    }

    public void setTobject(T tobject) {
        this.tobject = tobject;
    }
}
