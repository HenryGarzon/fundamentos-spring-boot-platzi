package com.fundamentosplatzi.sprinboot.fundamentos;

import com.fundamentosplatzi.sprinboot.fundamentos.Component.ComponentDependency;
import com.fundamentosplatzi.sprinboot.fundamentos.bean.*;
import com.fundamentosplatzi.sprinboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprinboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.sprinboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog("FundamentosApplication.class");

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private BeanMiAsignatura beanMiAsignatura;
    private MyBeanWhitProperties myBeanWhitProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;


    //public FundamentosApplication(@Qualifier("componentImplement") ComponentDependency componentDependency){
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, BeanMiAsignatura beanMiAsignatura, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo, UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.beanMiAsignatura = beanMiAsignatura;
        this.myBeanWhitProperties = myBeanWhitProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        ejemplosAnteriores();
        saveUsersInDataBase();
        getInformationJpqlFromUser();

    }

    private void getInformationJpqlFromUser(){
        LOGGER.info("Usuario con el método findByUserEmail  :  " +
                userRepository.findByUserEmail("halgarjr@gmail.com")
                .orElseThrow(()->new RuntimeException("No se encontró el usuario ")));


        userRepository.findAndSort("user", Sort.by("id").descending())
                .stream()
                .forEach(user -> LOGGER.info("Usuario con mètodo sort " + user));

        userRepository.findByName1("Henry")
                .stream()
                .forEach(user -> LOGGER.info("Usuario conquery method " + user));

        LOGGER.info("Usuario con Query Method findByEmailAndName1" + userRepository.findByEmailAndName1("Eva@gmail1.com","Eva")
                .orElseThrow(()->new RuntimeException("No se encontró el usuario ")));

    }



    private void saveUsersInDataBase() {
        User user1=new User("Henry", "halgarjr@gmail.com", LocalDate.of(2022, 03, 22));
        User user2 = new User("Eva", "Eva@gmail1.com", LocalDate.of(2022, 03, 30));
        User user3 = new User("user3", "user3@gmail1.com", LocalDate.of(2022, 8, 01));
        User user4 = new User("user4", "user4@gmail1.com", LocalDate.of(2022, 11, 13));
        User user5 = new User("user5", "user5@gmail1.com", LocalDate.of(2022, 12, 17));
        User user6 = new User("user6", "user6@gmail1.com", LocalDate.of(2022, 1, 16));
        User user7 = new User("user7", "user7@gmail1.com", LocalDate.of(2022, 3, 11));
        User user8 = new User("user8", "user8@gmail1.com", LocalDate.of(2022, 8, 07));
        User user9 = new User("user9", "user9@gmail1.com", LocalDate.of(2022, 9, 04));
        User user10 = new User("user10", "user10@gmail1.com", LocalDate.of(2022, 6, 06));
        User user11 = new User("user11", "user11@gmail1.com", LocalDate.of(2022, 1, 9));
        User user12 = new User("user12", "user12@gmail1.com", LocalDate.of(2022, 7, 19));

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
        list.stream().forEach(userRepository::save);
    }

    private void ejemplosAnteriores() {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        beanMiAsignatura.imprimirMiAsignatura();
        System.out.println(myBeanWhitProperties.function());
        System.out.println(userPojo.getEmail() + " - Password: " + userPojo.getPassword() + " - Edad: " + userPojo.getAge());
        try {
            //error
            int value = 10 / 0;
            LOGGER.info("Mi valor :" + value);
        } catch (Exception e) {
//            LOGGER.error("Esto es un error del aplicativo");
            LOGGER.error("Esto es un error de división por cero" + e.getMessage() + " - " + e.getStackTrace());
        }
//        LOGGER.error("Esto es un error del aplicativo");


    }

}
