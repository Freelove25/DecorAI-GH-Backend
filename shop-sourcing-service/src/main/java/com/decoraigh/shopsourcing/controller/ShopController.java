package com.decoraigh.shopsourcing.controller;

import com.decoraigh.shopsourcing.entity.Shop;
import com.decoraigh.shopsourcing.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.createShop(shop));
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.getShopById(id));
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Shop>> getShopsByLocation(@PathVariable String location) {
        return ResponseEntity.ok(shopService.getShopsByLocation(location));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Shop>> getShopsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(shopService.getShopsByCategory(category));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Shop>> searchShops(
            @RequestParam String location,
            @RequestParam String category) {
        return ResponseEntity.ok(shopService.getShopsByLocationAndCategory(location, category));
    }

    @GetMapping("/verified")
    public ResponseEntity<List<Shop>> getVerifiedShops() {
        return ResponseEntity.ok(shopService.getVerifiedShops());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.updateShop(id, shop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.ok("Shop deleted successfully");
    }
}