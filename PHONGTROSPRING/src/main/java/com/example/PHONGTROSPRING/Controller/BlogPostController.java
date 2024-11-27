package com.example.PHONGTROSPRING.Controller;

import com.example.PHONGTROSPRING.entities.BlogPost;
import com.example.PHONGTROSPRING.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blog")
    public String showBlogPage(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "views/blog"; // Trỏ đến file blog.html trong thư mục templates
    }
}
