package com.superstore.storesever.controller;

import com.superstore.storesever.error.ItemNotFoundException;
import com.superstore.storesever.model.PatchOperation;
import com.superstore.storesever.model.StoreItem;
import com.superstore.storesever.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<ResponseDataView> addNewItems(@RequestBody() StoreItem item) throws ItemNotFoundException {

        StoreItem saved = storeService.addNewItem(item);
        return ResponseEntity.ok().body(new ResponseDataView(saved));

    }

    @PatchMapping("/eans")
    public ResponseEntity<ResponseDataView> patchStoreItem(@RequestBody PatchOperation operation) throws ItemNotFoundException {

        boolean success =  false;

        switch(operation.getAction()) {
            case INCEMENT:
                success = storeService.incrementStoreItem(operation.getEan(), operation.getQauntity());
                break;
            case DECREMENT:
                success = storeService.decrementStoreItem(operation.getEan(), operation.getQauntity());
                break;
            default:
                throw new UnsupportedOperationException("We don't support operation: " + operation.getAction().getAction());
        }

        Optional<StoreItem> sItem = storeService.getItemById(operation.getEan());

        StoreItem item = sItem.orElseThrow(() -> new ItemNotFoundException(operation.getEan()));

        if(success)
            return ResponseEntity.ok(new ResponseDataView(item));
        else
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new ResponseDataView(item));

    }
}
