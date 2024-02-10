package com.example.coments_api.repositores;

import com.example.coments_api.models.ComentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComentsRepository extends JpaRepository<ComentsModel, UUID> {
   List<ComentsModel> findByTitle(String title);
}