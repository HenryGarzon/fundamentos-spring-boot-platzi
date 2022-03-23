package com.fundamentosplatzi.sprinboot.fundamentos.repository;

import com.fundamentosplatzi.sprinboot.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {



}
