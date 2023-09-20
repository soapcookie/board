package com.example.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long CategoryId;

    private String CategoryName;

    private String CategoryDec; //카테고리 설명

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> posts = new ArrayList<>();

    // 해당 카테고리에 속한 게시물 리스트
//    Cascade : 부모인 카테고리가 변경되거나 삭제될 때 해당 카테고리에 속한 게시물들도 동시에 변경되거나 삭제




}
