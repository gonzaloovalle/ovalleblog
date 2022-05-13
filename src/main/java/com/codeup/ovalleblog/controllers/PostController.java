package com.codeup.ovalleblog.controllers;

import com.codeup.ovalleblog.dao.PostRepository;
import com.codeup.ovalleblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> postList = postDao.findAll();


        model.addAttribute("title", "All Posts");
        model.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
        Post post = postDao.getById(id);

        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@RequestParam(name = "post-title") String title, @RequestParam(name = "post-body") String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);
        return "redirect:/posts";
    }
}
