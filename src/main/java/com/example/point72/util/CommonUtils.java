package com.example.point72.util;

import com.example.point72.exception.InvalidInputException;
import java.util.List;

public class CommonUtils {
  public static void validateSorted(List<Integer> list, String name) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) > list.get(i + 1)) {
        throw new InvalidInputException("Array " + name + " is not sorted in ascending order.");
      }
    }
  }
}
