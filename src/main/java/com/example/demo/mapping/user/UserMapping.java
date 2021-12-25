package com.example.demo.mapping.user;
public interface UserMapping<T,UserDTO>{
   T mapUserDtoToUser(UserDTO userDTO);
   UserDTO mapUserToUserDto(T user);
   

}
