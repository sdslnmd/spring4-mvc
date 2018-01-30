package com.boraji.tutorial.spring.tool;

import org.roaringbitmap.RoaringBitmap;

public class RoaringBitmapTest {

  public static void main(String[] args) {

    RoaringBitmap bitmap = RoaringBitmap.bitmapOf(1, 2, 10);
    System.out.println(bitmap.getLongCardinality());
    for (Integer integer : bitmap) {
      System.out.println(integer);
    }




  }
}
