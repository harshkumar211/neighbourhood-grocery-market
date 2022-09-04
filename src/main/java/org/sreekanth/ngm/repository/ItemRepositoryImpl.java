package org.sreekanth.ngm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sreekanth.ngm.model.Item;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final Logger logger = LoggerFactory.getLogger(ItemRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionfactory;

    @Override
    public void addItem(Item item) {
        Session session = this.sessionfactory.getCurrentSession();
        session.persist(item);
        logger.info("Item Saved Successfully. Item Details = "+item);
    }

    @Override
    public void updateItem(Item item) {
        Session session = this.sessionfactory.getCurrentSession();
        session.update(item);
        logger.info("Item updated successfully. Item details = "+item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Item> listItems() {
        Session session = this.sessionfactory.getCurrentSession();
        List<Item> itemsList = session.createQuery("from Item").list();
        for(Item item : itemsList ){
            logger.info("Item List::"+item);
        }
        return itemsList;
    }

    @Override
    public Item getItemById(int id) {
        Session session = this.sessionfactory.getCurrentSession();
        return session.load(Item.class, id);
    }

    @Override
    public void removeItem(int id) {
        Session session = this.sessionfactory.getCurrentSession();
        Item item = session.load(Item.class, id);
        if(null != item) {
            session.delete(item);
        }
    }
}
