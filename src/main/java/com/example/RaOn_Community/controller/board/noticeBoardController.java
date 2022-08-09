package com.example.RaOn_Community.controller.board;

import com.example.RaOn_Community.dto.CommentForm;
import com.example.RaOn_Community.dto.PostForm;
import com.example.RaOn_Community.entity.Comment;
import com.example.RaOn_Community.entity.Post;
import com.example.RaOn_Community.repository.CommentRepository;
import com.example.RaOn_Community.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api/board")
public class noticeBoardController {
    @Autowired
    private PostRepository pr;
    @Autowired
    private CommentRepository cr;
    @GetMapping("")
    public List<Post> noticeBoard(){
        List<Post> postEntity=pr.findAll();
        return postEntity;
    }
    @GetMapping("/{id}")
    public Post noticeBoardId(@PathVariable Integer id){
        Post post=pr.findById(id).orElse(null);
        return post;
    }
    @GetMapping("/{id}/edit")
    public void noticeBoardEdit(@PathVariable Integer id){
        Post post=pr.findById(id).orElse(null);
    }
    @GetMapping("/api/board/{id}/delete")
    public void noticeBoardDelete(@PathVariable Integer id){
        Post post=pr.findById(id).orElse(null);
        if(post!=null){
            pr.delete(post);
        }
    }
    @PostMapping("/insert")
    public void softwarePost(PostForm post) {
        post.setAuthor("관리자");
        Date now=new Date();
        long time=now.getTime();
        java.sql.Date date1=new java.sql.Date(time);
        post.setBoard_date(date1);
        post.setRecommend(0);
        pr.save(post.toEntity());
    }
    @GetMapping("/comment")
    public List<Comment> boardAllComment(){
        List<Comment> commentEntity=cr.findAll();
        return commentEntity;
    }
    @GetMapping("/{id}/comment")
    public List<Comment> boardComment(@PathVariable Integer id){
        List<Comment> commentEntity=cr.findAll();
        Post post=pr.findById(id).orElse(null);
        List<Comment> resultcomment=new ArrayList<Comment>();
        for(Comment com:commentEntity){
            if(post.getId()==com.getPost_id().getId())
                resultcomment.add(com);
        }
        return resultcomment;
    }
    @PostMapping("/{id}/comment/insert")
    public void boardCommentinsert(CommentForm comment){

    }
    @GetMapping("/{id}/comment/delete")
    public void boardCommentDelete(@PathVariable Integer id){

    }
}
