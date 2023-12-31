package com.example.board.repository;

import com.example.board.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    public List<PostEntity> findAllByOrderByIdDesc();
    public Page<PostEntity> findAllByOrderByRegDateDesc(Pageable pageable);

//    public Page<BoardEntity> findByBoardTypeOrderByIdDesc(BoardType boardType,Pageable pageable);

}
