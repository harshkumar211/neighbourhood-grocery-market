package org.sreekanth.ngm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreekanth.ngm.model.Item;
import org.sreekanth.ngm.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addItem(Item item) {
        itemRepository.addItem(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.updateItem(item);
    }

    @Override
    public List<Item> listItems() {
        return itemRepository.listItems();
    }

    @Override
    public List<String> listCategories() {
        return itemRepository.listItems().stream().map( i -> i.getCategory()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Item> listItemsByCategory(String category) {
        return itemRepository.listItems().stream().filter(i -> category.equalsIgnoreCase(i.getCategory())).collect(Collectors.toList());
    }

    @Override
    public Item getItemById(int id) {
        return itemRepository.getItemById(id);
    }

    @Override
    public void removeItem(int id) {
        itemRepository.removeItem(id);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void loadItems() {
        addItem(new Item("Apple", "Fruit", 3));
        addItem(new Item("Banana", "Fruit", 2));
        addItem(new Item("Peach", "Fruit", 3));
        addItem(new Item("Broccoli", "Vegetable", 3));
        addItem(new Item("Kale", "Vegetable", 5));
        addItem(new Item("Chicken alfredo", "Pasta", 7));
        addItem(new Item("Pie", "Dessert", 4));
    }
}
