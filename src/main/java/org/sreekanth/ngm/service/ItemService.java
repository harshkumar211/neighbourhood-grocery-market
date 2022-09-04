package org.sreekanth.ngm.service;

import org.sreekanth.ngm.model.Item;

import java.util.List;

public interface ItemService {
    public void addItem(Item item);
    public void updateItem(Item item);
    public List<Item> listItems();
    public List<String> listCategories();
    public List<Item> listItemsByCategory(String category);
    public Item getItemById(int id);
    public void removeItem(int id);
    public void loadItems();
}
