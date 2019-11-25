package com.superstore.storesever.service;

import com.superstore.storesever.model.StoreItem;
import com.superstore.storesever.repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreItemRepository storeItemRepository;

    public Optional<StoreItem> getItemById(String ean) {
        Optional<StoreItem> item = storeItemRepository.findById(ean);
        return item;
    }

    public StoreItem addNewItem(StoreItem item) {
        throw new NotImplementedException();
    }

    public boolean incrementStoreItem(String ean, int qauntity) {
        throw new NotImplementedException();
    }

    public boolean decrementStoreItem(String ean, int qauntity) {
        throw new NotImplementedException();
    }
}
