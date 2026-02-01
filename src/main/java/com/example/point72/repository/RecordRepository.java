package com.example.point72.repository;

import com.example.point72.model.MergeDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<MergeDetails, Long> {
  List<MergeDetails> findByResultLength(int resultLength);
}
