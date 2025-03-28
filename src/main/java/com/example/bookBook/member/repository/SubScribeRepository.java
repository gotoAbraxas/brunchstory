package com.example.bookBook.member.repository;

import com.example.bookBook.member.domain.entity.Member;
import com.example.bookBook.member.domain.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubScribeRepository extends JpaRepository<Subscribe, Long> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Subscribe s WHERE s.author = :author AND s.member = :member")
    boolean existsByAuthorAndMember(@Param("author") Member author, @Param("member") Member member);

    @Query("SELECT s FROM Subscribe s WHERE s.author = :author AND s.member = :member")
    List<Subscribe> findByMemberAndAuthor(@Param("author") Member author, @Param("member") Member member);

    @Modifying
    @Query("DELETE FROM Subscribe s WHERE s.author = :author AND s.member = :member")
    void deleteByAuthorAndMember(@Param("author") Member author, @Param("member") Member member);

    @Query("SELECT COUNT(s) FROM Subscribe s WHERE s.author = :author")
    Long countByAuthor(@Param("author") Member author);
}
