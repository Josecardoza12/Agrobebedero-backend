package com.example.ms_flushing.repository;

import com.example.ms_flushing.model.RegistroFlushing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlushingRepository extends JpaRepository<RegistroFlushing, Long> {
}