package shop.service.mapper;

import org.springframework.stereotype.Component;
import shop.dto.response.UserResponseDto;
import shop.model.User;

@Component
public class UserMapper implements
        ResponseDtoMapper<UserResponseDto, User> {
    public UserResponseDto toDto(User model) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(model.getId());
        userResponseDto.setEmail(model.getEmail());
        return userResponseDto;
    }
}
