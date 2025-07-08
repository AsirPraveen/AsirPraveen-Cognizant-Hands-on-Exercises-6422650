package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);
    List<Stock> findByCodeAndCloseGreaterThan(String code, double close);
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
