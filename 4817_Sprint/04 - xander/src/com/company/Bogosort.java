package com.company;

import java.util.Random;

public class Bogosort {
  private static Random r = new Random();

  private static int[] shuffleIntArray(int[] array) {
    for (int i = array.length-1; i > 0; i--) {
      int index = r.nextInt(i + 1);
      int temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
    return array;
  }

  private static boolean isSorted(int[] unsortedArray) {
    for (int i = 0; i < unsortedArray.length; i++) {
      if (i == unsortedArray.length-1) {
        return true;
      } else if (unsortedArray[i] > unsortedArray[i+1]) {
        break;
      }
    }
    return false;
  }

  static int[] sort(int[] unsortedArray) {
    while (!isSorted(unsortedArray)) {
      unsortedArray = shuffleIntArray(unsortedArray);
    }
    int[] sortedArray = unsortedArray;
    return sortedArray;
  }




}
