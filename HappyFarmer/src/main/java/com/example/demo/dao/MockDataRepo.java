package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.UserModel;

public class MockDataRepo{
    private static MockDataRepo instance;
    private MockDataRepo()
    {

    }
    public List<UserModel> getAllUsers()
    {
        return new ArrayList<UserModel>();
    }
    public static MockDataRepo getInstance()
    {
        if(instance==null)
        {
            instance=new MockDataRepo();
        }
        return instance;
    }
    
}
