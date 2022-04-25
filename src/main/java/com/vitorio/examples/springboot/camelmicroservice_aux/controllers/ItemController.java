package com.vitorio.examples.springboot.camelmicroservice_aux.controllers;

import java.security.InvalidParameterException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitorio.examples.springboot.camelmicroservice_aux.models.Book;
import com.vitorio.examples.springboot.camelmicroservice_aux.models.Item;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

    @PostMapping("/receive")
    public ResponseEntity<?> receiveItem(@RequestBody Item item) {
    	System.out.println("I RECEIVED AN ITEM!");
    	System.out.println(item);
    	System.out.println("-------------------------");
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<Item> fetchItem() {
    	Item someItem = new Item();
    	someItem.setFormat("EBOOK");
    	someItem.setAmount(999);

    	Book someBook = new Book();
    	someBook.setCode("abcd99");
    	someBook.setTitle("SOME_TITLE");
    	someBook.setShortTitle("SOME_SHORT_TITLE");
    	someBook.setAuthorName("SOME_AUTHOR");
    	someBook.setPriceEbook(19.99);
    	someBook.setPricePrinted(0);

    	someItem.setBook(someBook);
    	
    	return new ResponseEntity<>(someItem, HttpStatus.OK);
    }
    
    @GetMapping("/fetch-secret-item")
    public ResponseEntity<Item> fetchSecretItem(@RequestParam String secret) throws InvalidParameterException {

    	if (secret != null && !secret.equals("S3cr3t-P455w0rD")) {
    		throw new InvalidParameterException("Secret is wrong!");
    	}

    	Item someItem = new Item();
    	someItem.setFormat("EBOOK");
    	someItem.setAmount(999);

    	Book someBook = new Book();
    	someBook.setCode("abcd99");
    	someBook.setTitle("THIS IS A SECRET BOOK!!");
    	someBook.setShortTitle("SOME_SHORT_TITLE");
    	someBook.setAuthorName("SOME_AUTHOR");
    	someBook.setPriceEbook(19.99);
    	someBook.setPricePrinted(0);

    	someItem.setBook(someBook);
    	
    	return new ResponseEntity<>(someItem, HttpStatus.OK);
    }
}
