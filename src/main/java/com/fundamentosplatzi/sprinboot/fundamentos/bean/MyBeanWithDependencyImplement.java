package com.fundamentosplatzi.sprinboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

        Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {

        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {

        LOGGER.info("Se ha ingresado al método printWithDependency de la clase MyBeanWithDependencyImplement");

        int numero=1;

        LOGGER.debug("El número enviado como parámetro a la dependencia myOperation es "+numero);
        System.out.println(myOperation.sum(numero));

        System.out.println("Hola desde la implementación de un Bean con dependencia");
    }
}
