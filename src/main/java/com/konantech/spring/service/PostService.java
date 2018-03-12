package com.konantech.spring.service;

import com.konantech.spring.exceptions.DemoNotFoundException;
import com.konantech.spring.model.Author;
import com.konantech.spring.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class PostService {

    private List<Post> posts;

    @PostConstruct
    public void init() {
        posts = new ArrayList<>();
        posts.add(new Post("IDX001", "Cyberpunk is near", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 555, new Author("Anna")));
        posts.add(new Post("IDX002", "Welcome aboard of the hype train", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 55, new Author("Josh")));
        posts.add(new Post("IDX003", "How to improve programming skills ", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 555, new Author("Kobe")));
        posts.add(new Post("IDX004", "Top exercises for IT people", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 55, new Author("Leo")));
        posts.add(new Post("IDX005", "Case study of 75 years project", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 55, new Author("Tom")));
        posts.add(new Post("IDX006", "Machine Learning", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 255, new Author("Alexa")));
        posts.add(new Post("IDX007", "Memory leaks, how to find them ", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 55, new Author("Frank")));
        posts.add(new Post("IDX008", "Robots builds robots", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 155, new Author("Milagros")));
        posts.add(new Post("IDX009", "Quantum algorithms, from the scratch", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 455, new Author("Sarah")));
        posts.add(new Post("IDX010", "Coding, coding, coding", "Description", "https://127.0.0.1/images/xvn84934fnls.jpg", 255, new Author("Adam")));
    }

    public void updatePost(Post post) {
        posts = posts.stream().filter(p -> p.getId() != post.getId()).collect(Collectors.toList());
        posts.add(post);
    }

    public void deletePost(String postID) {
        posts = posts.stream().filter(p -> !p.getId().equals(postID)).collect(Collectors.toList());
    }


    /**
     * Load post content from DB *Long running method
     */
    public Post getPostByID(String postID) throws DemoNotFoundException {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return posts.stream()
                .filter(p -> p.getId().equals(postID))
                .findFirst()
                .orElseThrow(() -> new DemoNotFoundException("Cannot find post with id:" + postID));
    }


    /**
     * Load top ten posts from DB *Long running method
     */
    public List<Post> getTopPosts() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
