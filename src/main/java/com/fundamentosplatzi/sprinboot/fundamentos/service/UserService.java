package com.fundamentosplatzi.sprinboot.fundamentos.service;


import com.fundamentosplatzi.sprinboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprinboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG= LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

@Transactional
        public void saveTransactional(List<User> users){
        users.stream()
                .peek(user->LOG.info("Usuario insertado : "+user))
                    .forEach(userRepository::save);


    }

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }

    public Object save(User newUser) {
        return userRepository.save(newUser);

    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
        return
        userRepository.findById(id)
                .map(
                        user->{
                            user.setEmail(newUser.getEmail());
                            user.setBirdDate(newUser.getBirdDate());
                            user.setName1(newUser.getName1());
                            return userRepository.save(user);
                        }
                ).get();
    }
}
