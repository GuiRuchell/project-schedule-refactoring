package com.schedule.votation.mapper;

import com.schedule.votation.dto.user.InUserDto;
import com.schedule.votation.dto.user.OutUserDto;
import com.schedule.votation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User inUserDtoToUser(InUserDto inUserDto);

    public abstract OutUserDto OutUserDtoToUser(User user);

}
