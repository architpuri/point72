package com.example.point72.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MergeService {

  public List<Integer> merge(List<Integer> a, List<Integer> b) {
    List<Integer> merged = new ArrayList<>();
    int i = 0, j = 0;
    while (i < a.size() && j < b.size()) {
      if (a.get(i) <= b.get(j)) {
        merged.add(a.get(i++));
      } else {
        merged.add(b.get(j++));
      }
    }
    while (i < a.size()) {
      merged.add(a.get(i++));
    }
    while (j < b.size()) {
      merged.add(b.get(j++));
    }
    return merged;
  }
}
