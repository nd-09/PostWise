package com.user.postwise.models.post;


import com.user.postwise.models.comment.AddComments;
import com.user.postwise.models.comment.Comment;


public interface Ipost {
   Post addComment(AddComments comment);
}
