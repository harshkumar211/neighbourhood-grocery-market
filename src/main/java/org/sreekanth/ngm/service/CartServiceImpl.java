package org.sreekanth.ngm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreekanth.ngm.model.Item;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CartServiceImpl implements CartService{
    @Override
    public Map<Item, Integer> listCart() {
        Map<Item, Integer> cart = new HashMap<>();
        cart.put(new Item("Apple", "Fruit", 3), 2);
        cart.put(new Item("Banana", "Fruit", 2), 6);
        cart.put(new Item("Pie", "Dessert", 4), 1);
        return cart;
    }

    @Override
    public void addItemToCart(Item item, int quantity) {

    }

    @Override
    public void updateItemInCart(Item item) {

    }

    @Override
    public void deleteItemFromCart(Item item) {

    }
}
