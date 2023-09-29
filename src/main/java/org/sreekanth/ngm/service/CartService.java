package org.sreekanth.ngm.service;

import java.util.Map;

public interface CartService {
    public Map<Integer, Integer> listCart();
    public int getQuantityByItemId(int itemId);
    public void addItemToCart(int itemId);
    public void updateItemInCart(int itemId, int quantity);
    public void deleteItemFromCart(int itemId);
}
