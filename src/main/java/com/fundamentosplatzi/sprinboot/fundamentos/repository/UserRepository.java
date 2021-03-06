package com.fundamentosplatzi.sprinboot.fundamentos.repository;

import com.fundamentosplatzi.sprinboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprinboot.fundamentos.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("Select u from User u WHERE u.name1 like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName1(String name1);

    Optional<User> findByEmailAndName1(String email,String name1);

    List<User> findByName1Like(String name1);

    List<User> findByName1OrEmail(String name1,String email);

    List<User> findByBirdDateBetween(LocalDate begin, LocalDate end);

    List<User> findByName1LikeOrderByIdDesc(String name1);

    List<User> findByName1ContainingOrderByIdDesc(String name1);

    @Query("Select new com.fundamentosplatzi.sprinboot.fundamentos.dto.UserDto(u.id, u.name1, u.birdDate)" +
        " from User u " +
        " where u.birdDate=:parametroFecha " +
        " and u.email=:parametroEmail "
    )
    Optional<UserDto> getAllByBirdDateAndEmail(@Param("parametroFecha") LocalDate date,
                                               @Param("parametroEmail") String email);

    List<User> findAll();



}
