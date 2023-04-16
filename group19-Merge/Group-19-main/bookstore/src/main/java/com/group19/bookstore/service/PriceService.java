package com.group19.bookstore.service;

import com.group19.bookstore.models.Cart;
import com.group19.bookstore.models.Price;
import com.group19.bookstore.repository.Cartrepo;
import com.group19.bookstore.repository.Pricerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private Pricerepo pricerepo;
    public List<Price> getPriceByUsername(long username) {
        return pricerepo.findPriceByUsername(username);
    }
    }
