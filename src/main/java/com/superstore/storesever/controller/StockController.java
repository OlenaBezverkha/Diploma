package com.superstore.storesever.controller;

import com.superstore.storesever.error.ItemAllredyExistException;
import com.superstore.storesever.error.ItemNotFoundException;
import com.superstore.storesever.error.QuantityLessThenZero;
import com.superstore.storesever.model.Attributes;
import com.superstore.storesever.model.PatchOperation;
import com.superstore.storesever.model.StoreItem;
import com.superstore.storesever.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/store/products")
public class StockController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/{ean}")
    public ResponseEntity<ResponseDataView> getSingleItem(@PathVariable("ean") String ean) throws ItemNotFoundException {

        Optional<StoreItem> item = storeService.getItemById(ean);
        return ResponseEntity.ok().body(new ResponseDataView(item.orElseThrow(() -> new ItemNotFoundException(ean))));

    }

    @PutMapping("")
    public ResponseEntity<ResponseDataView> addNewItems(@RequestBody() Attributes attributes) throws ItemAllredyExistException {

        StoreItem item = new StoreItem();
        item.setId(attributes.getEan());
        item.setType("stock");
        item.setAttributes(attributes);
        StoreItem saved = storeService.addNewItem(item);
        return ResponseEntity.ok().body(new ResponseDataView(saved));

    }

    @PatchMapping("/eans")
    public ResponseEntity<ResponseDataView> patchStoreItem(@RequestBody PatchOperation operation) throws ItemNotFoundException, QuantityLessThenZero {

        StoreItem item;

        switch(operation.getAction()) {
            case INCEMENT:
                item = storeService.incrementStoreItem(operation.getEan(), operation.getQuantity());
                break;
            case DECREMENT:
                item = storeService.decrementStoreItem(operation.getEan(), operation.getQuantity());
                break;
            default:
                throw new UnsupportedOperationException("We don't support operation: " + operation.getAction().getActionDescriptor());
        }

        return ResponseEntity.ok(new ResponseDataView(item));

    }
}
