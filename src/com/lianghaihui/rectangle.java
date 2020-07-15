package com.lianghaihui;
public class rectangle {
    private point p ; //左上角坐标
    private double height; //高
    private double width; //宽

    public rectangle(){}

    public rectangle(point p, double width, double height) {
        this.p = p;
        this.height = height;
        this.width = width;
    }

    public point getP() {
        return p;
    }

    public void setP(point p) {
        this.p = p;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}
