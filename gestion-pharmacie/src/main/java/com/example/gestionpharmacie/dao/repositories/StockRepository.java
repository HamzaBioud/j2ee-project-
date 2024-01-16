package com.example.gestionpharmacie.dao.repositories;

import com.example.gestionpharmacie.dao.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
