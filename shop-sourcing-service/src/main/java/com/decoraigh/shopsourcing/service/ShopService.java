
package com.decoraigh.shopsourcing.service;

import com.decoraigh.shopsourcing.entity.Shop;
import com.decoraigh.shopsourcing.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found with id: " + id));
    }

    public List<Shop> getShopsByLocation(String location) {
        return shopRepository.findByLocation(location);
    }

    public List<Shop> getShopsByCategory(String category) {
        return shopRepository.findByCategory(category);
    }

    public List<Shop> getShopsByLocationAndCategory(String location, String category) {
        return shopRepository.findByLocationAndCategory(location, category);
    }

    public List<Shop> getVerifiedShops() {
        return shopRepository.findByVerified(true);
    }

    public Shop updateShop(Long id, Shop updatedShop) {
        Shop shop = getShopById(id);
        shop.setName(updatedShop.getName());
        shop.setOwnerName(updatedShop.getOwnerName());
        shop.setLocation(updatedShop.getLocation());
        shop.setCategory(updatedShop.getCategory());
        shop.setContactNumber(updatedShop.getContactNumber());
        shop.setEmail(updatedShop.getEmail());
        shop.setRadiusKm(updatedShop.getRadiusKm());
        shop.setStockDescription(updatedShop.getStockDescription());
        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}