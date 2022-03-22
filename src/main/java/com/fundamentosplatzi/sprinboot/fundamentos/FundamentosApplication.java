package com.fundamentosplatzi.sprinboot.fundamentos;

import com.fundamentosplatzi.sprinboot.fundamentos.Component.ComponentDependency;
import com.fundamentosplatzi.sprinboot.fundamentos.bean.BeanMiAsignatura;
import com.fundamentosplatzi.sprinboot.fundamentos.bean.BeanMiNombre;
import com.fundamentosplatzi.sprinboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.sprinboot.fundamentos.bean.MyBeanWithDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private BeanMiAsignatura beanMiAsignatura;


	//public FundamentosApplication(@Qualifier("componentImplement") ComponentDependency componentDependency){
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, BeanMiAsignatura beanMiAsignatura){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.beanMiAsignatura=beanMiAsignatura;
	}

	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		beanMiAsignatura.imprimirMiAsignatura();

	}
}
