package com.schedule.votation.service.impl;

import com.schedule.votation.dto.user.InUserDto;
import com.schedule.votation.dto.user.OutUserDto;
import com.schedule.votation.entity.User;
import com.schedule.votation.mapper.UserMapper;
import com.schedule.votation.repository.UserRepository;
import com.schedule.votation.service.UserInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    @Override
    public OutUserDto findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User ID does not exist"));

        return userMapper.OutUserDtoToUser(user);
    }

    @Override
    public Page<User> findAllServiceAvailability(Pageable pageable) {
        return userRepository.findAllServiceAvailability(pageable);
    }

    @Override
    public OutUserDto createUser(InUserDto inUserDto) {
        User user = userMapper.inUserDtoToUser(inUserDto);
        return userMapper.OutUserDtoToUser(userRepository.save(user));
    }

    @Override
    public OutUserDto updateUser(Long id, InUserDto inUserDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User ID does not exist, it was not possible to update"));

        return userMapper.OutUserDtoToUser(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
