package org.sreekanth.ngm.repository;

import org.sreekanth.ngm.model.Item;

import java.util.List;

public interface ItemRepository {
    public void addItem(Item item);
    public void updateItem(Item item);
    public List<Item> listItems();
    public Item getItemById(int id);
    public void removeItem(int id);
}
