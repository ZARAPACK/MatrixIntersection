package com.lianghaihui;

public class Main {

    public static void main(String[] args)  {
        //十字相交情况
/*        point pla = new point(0, 6);
        rectangle ra = new rectangle(pla, 1, 10);
        point plb = new point(-2, 2);
        rectangle rb = new rectangle(plb, 8, 4);*/
        //包含情况
/*        point pla = new point(-2, 2);
        rectangle ra = new rectangle(pla, 4, 4);
        point plb = new point(-1, 1);
        rectangle rb = new rectangle(plb, 2, 2);*/
        //普通情况
        point pla = new point(0, 2);
        rectangle ra = new rectangle(pla, 2, 2);
        point plb = new point(1, 1);
        rectangle rb = new rectangle(plb, 3, 3);

        if (RectangleMethod.isIntersect(ra,rb)){
            RectangleMethod.getIntersectionPointAndWH(ra,rb);
        }else{
            System.out.println("当前两个矩阵不相交");
        }
    }
}
