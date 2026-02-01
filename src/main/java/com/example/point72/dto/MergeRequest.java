package com.example.point72.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MergeRequest {
  private List<Integer> firstArray;
  private List<Integer> secondArray;

  public List<Integer> getFirstArray() {
    return firstArray;
  }

  public List<Integer> getSecondArray() {
    return secondArray;
  }

}
