
package com.decoraigh.shopsourcing.repository;

import com.decoraigh.shopsourcing.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findByLocation(String location);
    List<Shop> findByCategory(String category);
    List<Shop> findByVerified(boolean verified);
    List<Shop> findByLocationAndCategory(String location, String category);
}