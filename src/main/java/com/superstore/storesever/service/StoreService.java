package com.superstore.storesever.service;

import com.superstore.storesever.error.ItemAllredyExistException;
import com.superstore.storesever.error.ItemNotFoundException;
import com.superstore.storesever.error.QuantityLessThenZero;
import com.superstore.storesever.model.StoreItem;
import com.superstore.storesever.repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreItemRepository storeItemRepository;

    public Optional<StoreItem> getItemById(String ean) {
        return storeItemRepository.findById(ean);
    }

    public StoreItem addNewItem(StoreItem item) throws ItemAllredyExistException {
        if(!storeItemRepository.existsById(item.getId())) {
            storeItemRepository.save(item);
            storeItemRepository.flush();
        }else {
            throw new ItemAllredyExistException(item.getId());
        }
        return item;
    }

    public StoreItem incrementStoreItem(String ean, int qauntity) throws ItemNotFoundException {

        Optional<StoreItem> oItem = storeItemRepository.findById(ean);
        StoreItem item = oItem.orElseThrow(() -> new ItemNotFoundException(ean));

        StoreItem.Attributes attributes = item.getAttributes();
        attributes.setQauntity(attributes.getQauntity() + qauntity);
        if(attributes.getQauntity() > 0 )
            attributes.setReasonCode("In Stock");

        item.setAttributes(attributes);

        storeItemRepository.save(item);
        storeItemRepository.flush();

        return item;
    }

    public StoreItem decrementStoreItem(String ean, int qauntity) throws QuantityLessThenZero, ItemNotFoundException {

        Optional<StoreItem> oItem = storeItemRepository.findById(ean);
        StoreItem item = oItem.orElseThrow(() -> new ItemNotFoundException(ean));

        StoreItem.Attributes attributes = item.getAttributes();
        attributes.setQauntity(attributes.getQauntity() - qauntity);
        if(attributes.getQauntity() == 0 )
            attributes.setReasonCode("string");
        else if(attributes.getQauntity() < 0 )
            throw new QuantityLessThenZero(ean, qauntity);

        item.setAttributes(attributes);

        storeItemRepository.save(item);
        storeItemRepository.flush();

        return item;
    }
}
