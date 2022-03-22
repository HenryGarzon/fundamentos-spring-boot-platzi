package com.fundamentosplatzi.sprinboot.fundamentos.configuration;


import com.fundamentosplatzi.sprinboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation() {

        return new MyBean2Implement();
    }
    @Bean
    public MyOperation beanOperationOperation() {

        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWhitDependency(MyOperation myOperation) {

        return new MyBeanWithDependencyImplement(myOperation);
    }


    @Bean
    public BeanMiNombre opearBeanMiNombre () {

        return new BeanMiNombreImplement();
    }
    @Bean
    public BeanMiAsignatura beanOperaMiAsignatura(BeanMiNombre beanMiNombre) {

        return new BeanMiAsignaturaImplement(beanMiNombre);
    }



}
