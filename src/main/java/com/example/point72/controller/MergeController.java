package com.example.point72.controller;

import com.example.point72.dto.MergeRequest;
import com.example.point72.model.MergeDetails;
import com.example.point72.repository.RecordRepository;
import com.example.point72.service.MergeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merge")
@SecurityRequirement(name = "bearer-key")
public class MergeController {

  @Autowired
  private MergeService mergeService;
  @Autowired
  private RecordRepository repository;

  @PostMapping
  public MergeDetails merge(@RequestBody MergeRequest req) {
    List<Integer> result = mergeService.merge(req.getFirstArray(), req.getSecondArray());
    MergeDetails details = new MergeDetails();
    details.setArray1(req.getFirstArray());
    details.setArray2(req.getSecondArray());
    details.setMergedResult(result);
    details.setResultLength(result.size());
    repository.save(details);
    return details;
  }

  @GetMapping("/length/{len}")
  public List<MergeDetails> getByLength(@PathVariable int len) {
    return repository.findByResultLength(len);
  }
}