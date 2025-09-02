package service;

import entity.Post;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    public PostRepository postRepository;

    public PostService(PostRepository postRepository) {this.postRepository = postRepository;}

    public List<Post> listarPosts() {return this.postRepository.findAll();}

}
