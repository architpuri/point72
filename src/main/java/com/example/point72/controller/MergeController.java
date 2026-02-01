package com.example.point72.controller;

import com.example.point72.dto.MergeRequest;
import com.example.point72.exception.InvalidInputException;
import com.example.point72.exception.ResourceNotFoundException;
import com.example.point72.model.MergeDetails;
import com.example.point72.repository.RecordRepository;
import com.example.point72.service.MergeService;
import com.example.point72.util.CommonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  @Operation(summary = "Merge two sorted arrays", description = "Uses O(n+m) logic to merge and persist arrays.")
  public MergeDetails merge(@RequestBody MergeRequest req) {
    CommonUtils.validateSorted(req.getFirstArray(),"First");
    CommonUtils.validateSorted(req.getSecondArray(),"Second");
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
  @Operation(summary = "Find merges by length", description = "Returns a list of all historical merges resulting in a specific size.")
  public List<MergeDetails> getByLength(@PathVariable int len) {
    List<MergeDetails> results= repository.findByResultLength(len);
    if (results.isEmpty()) {
      throw new ResourceNotFoundException("No merge records found with length: " + len);
    }
    return results;
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFound(ResourceNotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleInvalidInput(InvalidInputException ex) {
    return ex.getMessage();
  }
}