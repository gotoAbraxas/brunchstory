package com.example.brunchStory.post.domain.request;

import com.example.brunchStory.member.domain.entity.Member;
import com.example.brunchStory.post.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String bookName;
    private List<Integer> posts;

    public Book toEntity(Member member){
        return Book.builder()
                .bookName(bookName)
                .page(posts.size())
                .publishedDate(LocalDate.now())
                .author(member)
                .build();

    }
}
