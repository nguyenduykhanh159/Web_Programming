package com.example.demo.mapping.user;
public interface UserMapping<T,TDTO>{
   T mapUserDtoToUser(TDTO userDTO);
   TDTO mapUserToUserDto(T user);

}
