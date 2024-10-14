package com.HMSync.security.user.service;

import com.HMSync.security.user.controller.dto.ChangePasswordRequestDto;
import com.HMSync.security.user.controller.dto.UserSearchDto;
import com.HMSync.security.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.UUID;

public interface UserService {
    void changePassword(ChangePasswordRequestDto request, Principal connectedUser);
    Page<User> search(UserSearchDto searchDto, Pageable pageable);
    User get(UUID userId);
}
