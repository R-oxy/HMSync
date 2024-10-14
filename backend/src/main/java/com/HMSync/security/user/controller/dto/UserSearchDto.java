package com.HMSync.security.user.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserSearchDto {
    private String search;
}
