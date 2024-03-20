package com.fis.mylittleboard.domain.comment.repository;

import com.fis.mylittleboard.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
