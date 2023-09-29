package org.sreekanth.ngm.service;

import org.sreekanth.ngm.model.Item;

import java.util.Map;

public interface CartService {
    public Map<Item, Integer> listCart();
    public void addItemToCart(Item item, int quantity);
    public void updateItemInCart(Item item);
    public void deleteItemFromCart(Item item);
}
