package org.sreekanth.ngm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CartServiceImpl implements CartService{

    private Map<Integer, Integer> cart = new HashMap<>();;

    @Override
    public Map<Integer, Integer> listCart() {
        return cart;
    }

    @Override
    public int getQuantityByItemId(int itemId) {
        if(cart.containsKey(itemId)){
            return cart.get(itemId);
        }else {
            return 0;
        }
    }

    @Override
    public void addItemToCart(int itemId) {
        cart.put(itemId, 1);
    }

    @Override
    public void updateItemInCart(int itemId, int quantity) {
        cart.put(itemId, cart.get(itemId) + quantity);
    }

    @Override
    public void deleteItemFromCart(int itemId) {

    }
}
