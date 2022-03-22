package com.fundamentosplatzi.sprinboot.fundamentos.bean;

public class BeanMiAsignaturaImplement implements BeanMiAsignatura{

    private String miNombre="Henry Alfonso Garzón Sánchez";
    private BeanMiNombre beanMiNombre;

    public BeanMiAsignaturaImplement(BeanMiNombre beanMiNombre) {
        this.beanMiNombre = beanMiNombre;
    }

    @Override
    public void imprimirMiAsignatura() {

        String Asigna="Fundamentos de JAVA SPRING BOOT";
        System.out.println(beanMiNombre.imprimirMiNombre(this.miNombre));
        System.out.println(" Cursando "+Asigna);
        System.out.println();

        System.out.println("Desde el Bean 'BeanMiAsignatura' con dependencia llamada 'BeanMiNombre' ");
    }
}
