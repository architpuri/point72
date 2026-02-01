package com.example.point72.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class MergeDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ElementCollection
  private List<Integer> array1;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Integer> getArray1() {
    return array1;
  }

  public void setArray1(List<Integer> array1) {
    this.array1 = array1;
  }

  public List<Integer> getArray2() {
    return array2;
  }

  public void setArray2(List<Integer> array2) {
    this.array2 = array2;
  }

  public List<Integer> getMergedResult() {
    return mergedResult;
  }

  public void setMergedResult(List<Integer> mergedResult) {
    this.mergedResult = mergedResult;
  }

  public int getResultLength() {
    return resultLength;
  }

  public void setResultLength(int resultLength) {
    this.resultLength = resultLength;
  }

  @ElementCollection
  private List<Integer> array2;

  @ElementCollection
  private List<Integer> mergedResult;

  private int resultLength;
}
