package com.schedule.votation.mapper;

import com.schedule.votation.dto.user.InUserDto;
import com.schedule.votation.dto.user.OutUserDto;
import com.schedule.votation.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T21:16:56-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User inUserDtoToUser(InUserDto inUserDto) {
        if ( inUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( inUserDto.getName() );

        return user;
    }

    @Override
    public OutUserDto OutUserDtoToUser(User user) {
        if ( user == null ) {
            return null;
        }

        OutUserDto outUserDto = new OutUserDto();

        outUserDto.setId( user.getId() );
        outUserDto.setName( user.getName() );

        return outUserDto;
    }
}
