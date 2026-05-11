package com.queuebite.service;

import com.queuebite.model.MenuItem;
import com.queuebite.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem addMenuItem(MenuItem item) {
        return menuItemRepository.save(item);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}