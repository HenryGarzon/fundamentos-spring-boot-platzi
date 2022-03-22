package com.fundamentosplatzi.sprinboot.fundamentos.bean;

public class BeanMiNombreImplement implements BeanMiNombre{

    @Override
    public String imprimirMiNombre(String nombre) {

        return "Soy "+nombre;
    }
}
