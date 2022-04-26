package com.schedule.votation.controller;

import com.schedule.votation.dto.user.InUserDto;
import com.schedule.votation.dto.user.OutUserDto;
import com.schedule.votation.mapper.UserMapper;
import com.schedule.votation.service.impl.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public ResponseEntity<Page<OutUserDto>> findAllServiceAvailability(final @RequestParam(required = false, defaultValue = "0") Integer page,
                                                                       final @RequestParam(required = false, defaultValue = "5") Integer limit,
                                                                       final @RequestParam(required = false, defaultValue = "DESC") Sort.Direction order,
                                                                       final @RequestParam(required = false, defaultValue = "name") String sortColumn) {
        var pageable = PageRequest.of(
                page,
                limit,
                Sort.by(order, sortColumn)
        );
        Page<OutUserDto> outServiceAvailabilityDtoList = userService.findAllServiceAvailability(pageable)
                .map(userMapper::OutUserDtoToUser);
        return new ResponseEntity<>(outServiceAvailabilityDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutUserDto> findUserById(@PathVariable Long id) {
        OutUserDto outUserDto = userService.findUserById(id);
        return new ResponseEntity<>(outUserDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OutUserDto> createUser(@RequestBody InUserDto inUserDto) {
        OutUserDto outUserDto = userService.createUser(inUserDto);
        return new ResponseEntity<>(outUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutUserDto> updateUser(@PathVariable Long id, @RequestBody InUserDto inUserDto) {
        OutUserDto outUserDto = userService.updateUser(id, inUserDto);
        return new ResponseEntity<>(outUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
