package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
    @Query("SELECT i, COALESCE(AVG(r.rating), 0) AS itemRating " +
            "FROM Item i " +
            "LEFT JOIN i.reviews r " +
            "GROUP BY i " +
            "HAVING COALESCE(AVG(r.rating), 0) < :rating")
	public List<Item> findItemsWithAverageRatingLowerThan(Double rating);
}
