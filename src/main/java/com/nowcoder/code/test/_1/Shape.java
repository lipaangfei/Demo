package com.nowcoder.code.test._1;

/**
 * @author Pengfei Li
 * @date 2021/1/22
 */
public class Shape {
  private int length;
  private int width;

  public Shape(int length, int width){
//    assert length > 0 && width > 0;
    if (!(length > 0 && width > 0)){
      throw new IllegalArgumentException("Illegal length, width : " + this.length);
    }
    this.length = length;
    this.width = width;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public String toString() {
    return "Shape{" +
        "length=" + length +
        ", width=" + width +
        '}';
  }
}
