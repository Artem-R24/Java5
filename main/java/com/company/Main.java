package com.company;

import somePackage.SomeBean;

public class Main {

    public static void main(String[] args) { // в main реализован пример из задания
        SomeBean sb = (new Injector()).inject(new SomeBean());
        sb.foo();
    }
}
