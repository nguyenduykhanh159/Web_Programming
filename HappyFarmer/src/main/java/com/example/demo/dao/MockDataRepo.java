package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;

public class MockDataRepo{
    private static List<UserModel> users;
    private static List<ProductModel> products;
    private MockDataRepo()
    {
        UserModel user1=new UserModel();
        user1.setUserId(1);
        user1.setName("Phung Xuan Quan");
        user1.setPhone("0974654xxx");
        user1.setAddress("Back Khoa, Hai Ba Trung, Ha Noi");
        UserModel user2=new UserModel();
        user2.setUserId(1);
        user2.setName("Nguyen Duy Khanh");
        user2.setPhone("0974654xxx");
        user2.setAddress("Le Thanh Nghi, Hai Ba Trung, Ha Noi");
        UserModel user3=new UserModel();
        user3.setUserId(1);
        user3.setName("Tran Hoang Viet");
        user3.setPhone("0974654xxx");
        user3.setAddress("Tan Van, Hai Ba Trung, Ha Noi");
        
        users.add(user1);
        users.add(user2);
        users.add(user3);

        ProductModel prod1=new ProductModel(1,"SanPham1","HTX Bach Khoa",50.9f,100,"20/12/2022");
        ProductModel prod2=new ProductModel(2,"SanPham2","HTX Bach Khoa",60.9f,100,"20/12/2022");
        ProductModel prod3=new ProductModel(3,"SanPham3","HTX Bach Khoa",70.9f,100,"20/12/2022");
        ProductModel prod4=new ProductModel(4,"SanPham4","HTX Bach Khoa",80.9f,100,"20/12/2022");
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);



    }
    //User info
    public List<UserModel> getAllUsers()
    {
        return users;
    }
    public UserModel getUser(int userId)
    {
        for(UserModel u:users)
        {
            if(u.getUserId()==userId)
            {
                return u;
            }
        }
        return null;
    }
    public void addUser(UserModel user)
    {
        users.add(user);
    }

    //Products info
    public List<ProductModel> getAllProducts()
    {
        return products;
    }
    public ProductModel getProduct(int prodId)
    {
        for(ProductModel prod:products)
        {
            if(prod.getProductID()==prodId)
            {
                return prod;
            }
        }
        return null;
    }
    public void addProduct(ProductModel prod)
    {
        products.add(prod);
    }
    
}
