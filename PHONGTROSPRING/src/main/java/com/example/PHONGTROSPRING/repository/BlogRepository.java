package com.example.PHONGTROSPRING.repository;

import com.example.PHONGTROSPRING.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogPost, Integer> {
    // Các phương thức truy vấn tùy chọn (nếu cần)
}
