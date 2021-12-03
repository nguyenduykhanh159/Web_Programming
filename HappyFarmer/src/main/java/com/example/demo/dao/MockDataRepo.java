package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.CartModel;
import com.example.demo.model.ProductDetail;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

@Repository("mockData")
public class MockDataRepo{
    private static List<UserModel> users=new ArrayList<UserModel>();
    private static List<ProductModel> products=new ArrayList<ProductModel>();
    private static List<CartModel> carts=new ArrayList<CartModel>();
    public MockDataRepo()
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

        ProductDetail prodDetail1=new ProductDetail();
        prodDetail1.setProductId(1);
        prodDetail1.setPrice(30.7f);
        prodDetail1.setQuantity(20);
        ProductDetail prodDetail2=new ProductDetail();
        prodDetail2.setProductId(3);
        prodDetail2.setPrice(30.7f);
        prodDetail2.setQuantity(20);
        ProductDetail prodDetail3=new ProductDetail();
        prodDetail3.setProductId(3);
        prodDetail3.setPrice(30.7f);
        prodDetail3.setQuantity(20);
        ProductDetail prodDetail4=new ProductDetail();
        prodDetail4.setProductId(4);
        prodDetail4.setPrice(30.7f);
        prodDetail4.setQuantity(20);

        //Cart 1
        CartModel cart1=new CartModel();
        cart1.setCartId(1);
        List<ProductDetail> prodsInCart1=new ArrayList<ProductDetail>();
        prodsInCart1.add(prodDetail1);
        prodsInCart1.add(prodDetail2);
        cart1.setProducts(prodsInCart1);

        //Cart 2
        CartModel cart2=new CartModel();
        cart2.setCartId(2);
        List<ProductDetail> prodsInCart2=new ArrayList<ProductDetail>();
        prodsInCart2.add(prodDetail1);
        prodsInCart2.add(prodDetail3);
        cart2.setProducts(prodsInCart2);

        //Cart 3
        CartModel cart3=new CartModel();
        cart3.setCartId(3);
        List<ProductDetail> prodsInCart3=new ArrayList<ProductDetail>();
        prodsInCart3.add(prodDetail2);
        prodsInCart3.add(prodDetail4);
        cart3.setProducts(prodsInCart3);

        carts.add(cart1);
        carts.add(cart2);
        carts.add(cart3);



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


    //Cart info
    public CartModel getCartInfo(int cartId)
    {
        for(CartModel cart : carts)
        {
            if(cart.getCartId()==cartId)
            {
                return cart;
            }
        }
        return null;
    }
    public List<CartModel> getAllCarts()
    {
        return carts;
    }
    public void addCart(CartModel cart)
    {
        carts.add(cart);
    }
    public boolean addProductToCart(int cartId,ProductDetail productDetail)
    {
        CartModel cart=getCartInfo(cartId);
        if(cart!=null)
        {
            cart.getProducts().add(productDetail);
            return true;
        }
        return false;
    }
    
}
