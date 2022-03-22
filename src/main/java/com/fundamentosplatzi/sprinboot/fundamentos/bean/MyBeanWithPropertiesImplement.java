package com.fundamentosplatzi.sprinboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWhitProperties{
    private String nombre;
    private String apellido;

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre+" - " + apellido;
    }
}
