package com.cherrypicker.cherrypick3r.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleUserInfoDto {

    private String id;

    private String email;

    private Boolean verified_email;

    private String name;

    private String given_name;

    private String picture;

    private String locale;

}
