package com.user.postwise.dtos;

import com.user.postwise.models.comment.Comment;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Postdto {
    private Long id;
    private String title;
    private String description;
    private List<Comment> comments = new ArrayList<>();
}

//inputstr = comp2uter scien1ce world4 rook3s
//
//output :
//
////csmputer wcience worrd rocks
