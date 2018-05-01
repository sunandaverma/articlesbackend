package com.niit.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.domain.Cart;

@Component
public interface CartDAO
{

	public Cart getCartbyID(int cartid);
	public boolean saveCart(Cart cart);
	public boolean updateCart(Cart cart);
	public List<Cart> CartList(String useremail);
	public boolean deleteFromCart(int cartid);
	public boolean emptyCart(String useremail);
	public int getCartQuantity(int cartid);
	
}