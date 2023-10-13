package com.example.board.repository;

import com.example.board.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAllByOrderByIdDesc();
}
