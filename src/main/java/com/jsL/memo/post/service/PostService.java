package com.jsL.memo.post.service;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsL.memo.FileManager;
import com.jsL.memo.post.domain.Post;
import com.jsL.memo.post.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	
	
	public boolean addPost(int userId, String title, String contents, MultipartFile file){
		
		String urlPath = FileManager.saveFile(userId, file);
		
		Post post = Post.builder()
		.userId(userId)
		.title(title)
		.contents(contents)
		.imgPath(urlPath)
		.build();
		
		try {
			postRepository.save(post);
		}
		catch(PersistenceException e) {
			return false;
		}
		return true;
		
	}
	
	
	
	public List<Post>getPostList(int userId){
		List<Post>post = postRepository.findByUserIdOrderByIdDesc(userId);
		return post;
	}
	
	
	public Post getPost(int id){
		Optional<Post>optionalPost = postRepository.findById(id);
		
		return optionalPost.orElse(null);
	}
	
	
	
	
	
	
	
	
	
	
}
