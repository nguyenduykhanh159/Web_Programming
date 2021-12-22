package com.example.demo.service.user;

import java.util.List;

public interface UserService<T> {
    public List<T> getAll();
    public T getUser(int userId);
    public boolean addUser(T userDTO);
    boolean removeUser(int userId);
    
}
