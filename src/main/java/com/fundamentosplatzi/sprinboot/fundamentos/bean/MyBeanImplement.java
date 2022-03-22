package com.fundamentosplatzi.sprinboot.fundamentos.bean;

public class MyBeanImplement implements MyBean{


    @Override
    public void print() {

        System.out.println("Hola desde mi implmentación propia del Bean");
    }
}
