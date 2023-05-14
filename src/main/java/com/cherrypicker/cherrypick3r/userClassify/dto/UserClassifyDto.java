package com.cherrypicker.cherrypick3r.userClassify.dto;

import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class UserClassifyDto {

    public Long id;

    private List<Long> userClassifyTags;
    private User user;

    @Builder
    public UserClassifyDto(Long id, List<Long> userClassifyTags, User user)  {
        this.id = id;
        this.userClassifyTags = userClassifyTags;
        this.user = user;
    }
}
