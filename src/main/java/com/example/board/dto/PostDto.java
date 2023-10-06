package com.example.board.dto;

import com.example.board.entity.CategoryEnum;
import com.example.board.entity.CommentEntity;
import com.example.board.entity.LikeEntity;
import com.example.board.entity.PostEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private UserDto userName;
    private LocalDateTime createdDate;
    private List<CommentEntity> comments; //댓글 리스트 추가
    private List<CategoryEnum> categories; //카테고리 표시
    private List<LikeEntity> likes; //좋아요 표시

    public void setId(Long id) {
        this.id = id;
    }


    public static PostDto convertToDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setTitle(postEntity.getTitle());
        postDto.setContent(postEntity.getContent());
        // set other properties as needed
        return postDto;
    }


    public PostDto(PostEntity postEntity){
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
        this.createdDate = postEntity.getRegDate();
        this.comments = postEntity.getComments();
        this.categories = postEntity.getCategories();
        this.likes = postEntity.getLikes();
    }


}
