package com.schedule.votation.service;

import com.schedule.votation.dto.user.InUserDto;
import com.schedule.votation.dto.user.OutUserDto;
import com.schedule.votation.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserInterface {

    OutUserDto findUserById(Long id);
    Page<User> findAllServiceAvailability(Pageable pageable);
    OutUserDto createUser(InUserDto inUserDto);
    OutUserDto updateUser(Long id, InUserDto inUserDto);
    void deleteUser(Long id);
}
