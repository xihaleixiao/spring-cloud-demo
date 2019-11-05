package com.xhlx.service;


import com.xhlx.client.UserServiceClient;
import com.xhlx.dao.BlogDao;
import com.xhlx.dto.BlogDetailDTO;
import com.xhlx.dto.RespDTO;
import com.xhlx.entity.Blog;
import com.xhlx.entity.User;
import com.xhlx.exception.CommonException;
import com.xhlx.exception.ErrorCode;
import com.xhlx.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    UserServiceClient userServiceClient;

    public Blog postBlog(Blog blog) {
        return blogDao.save(blog);
    }

    public List<Blog> findBlogs(String username) {
        return blogDao.findByUsername(username);
    }


    public BlogDetailDTO findBlogDetail(Long id) {
        Optional<Blog> blogOptional = blogDao.findById(id);
        Blog blog=null;
        if(blogOptional!=null){
            blog=blogOptional.get();
        }
        if (null == blog) {
            throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
        }
        RespDTO<User> respDTO = userServiceClient.getUser(UserUtils.getCurrentToken(), blog.getUsername());
        if (respDTO==null) {
            throw new CommonException(ErrorCode.RPC_ERROR);
        }
        BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
        blogDetailDTO.setBlog(blog);
        blogDetailDTO.setUser(respDTO.data);
        return blogDetailDTO;
    }

}
