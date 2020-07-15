package com.lianghaihui;

public class RectangleMethod {
    /**
     * 获取右下角标点
     * @param r 需计算的矩阵
     * @Return
     */
    public static point getRightPoint(rectangle r){
        double Rx = r.getP().getX()+r.getWidth(); //要获取中心标点需要获得右下角的坐标，此为右下标的x
        double Ry ;
        Ry = r.getP().getY()-r.getHeight(); //要获取中心标点需要获得右下角的坐标，此为右下标的y
        //System.out.println(new point(Rx,Ry).toString());
        return new point(Rx,Ry);
    }
    /**
     * 计算矩形的中心标点并返回
     * @param r 需计算的矩阵
     * @Return 中心标点
     */
    public static point getCentral(rectangle r){
        double Rx = getRightPoint(r).getX();
        double Ry = getRightPoint(r).getY();
        double Cx = (Rx+r.getP().getX())/2;
        double Cy = (Ry+r.getP().getY())/2;
        return new point(Cx,Cy);
    }
    /**
     * 判断是否存在相交,重叠等
     * @param a, b 判断的两个矩阵
     * @Return 返回
     */
    public static boolean isIntersect(rectangle a,rectangle b){
        boolean is = false;
        point cpa = getCentral(a); //a的中心标点
        point cpb = getCentral(b);  //b的中心标点
        //中间变量
        double temp1 = Math.abs(cpa.getX()-cpb.getX());
        double temp2 = Math.abs(cpa.getY()-cpb.getY());
        double i = (a.getWidth()+b.getWidth())/2;
        double j = (a.getHeight()+b.getHeight())/2;
        //判断是否相交
        if (temp1<=i&&temp2<=j){
            is = true;
        }
        return is;
    }
    /**
     * 获取相交的左上角与宽高
     * @param a, b 两个矩阵
     */
    public static void getIntersectionPointAndWH(rectangle a,rectangle b){
        double Rax = getRightPoint(a).getX();  //获取a的右下角x坐标
        double Ray = getRightPoint(a).getY();  //获取a的右下角y坐标
        double Rbx = getRightPoint(b).getX();  //获取b的右下角x坐标
        double Rby = getRightPoint(b).getY();  //获取b的右下角y坐标
        //计算相交矩阵的左上角坐标,此处考虑上某个矩形重叠的情况，也包含十字相交的情况
        double Lcx = Math.max(a.getP().getX(),b.getP().getX());
        double Lcy = 0;
        //右下角
        double Rcx = Math.min(Rax,Rbx);
        double Rcy = 0;
        //这里主要判断在重叠和十字相交情况下，公共区域的左右坐标的纵坐标情况
        if((b.getP().getX()<=a.getP().getX())&&(a.getP().getX()<=b.getP().getX()+b.getWidth())){
            Lcy = Math.min(a.getP().getY(),b.getP().getY());
            Rcy = Math.max(Ray,Rby);
        }else  if((a.getP().getX()<=b.getP().getX())&&(b.getP().getX()<=a.getP().getX()+a.getWidth())){
            Lcy = Math.min(a.getP().getY(),b.getP().getY());
            Rcy = Math.max(Ray,Rby);
        }else{
            Lcy = Math.max(a.getP().getY(),b.getP().getY());
            Rcy = Math.min(Ray,Rby);
        }
        //计算相交矩阵的宽高
        double Wc = Math.abs(Rcx-Lcx);
        double Hc = getH(Lcy,Rcy);
        System.out.println("相交矩阵的左上角坐标为："+new point(Lcx,Lcy));
        //System.out.println("相交矩阵的右上角坐标为："+new point(Rcx,Rcy));
        System.out.println("相交矩阵的宽："+Wc+";相交矩阵的高："+Hc);
    }
    /**
     * 防止纵坐标运算得到高时出现特殊情况
     * @param a 这里a指左上纵坐标的值；b 这里b指右下纵坐标的值
     */
    public static double getH(double a,double b){
        double h ;
        if(a>0&&b<0){
            h= a-b;
        }
        else{
            h= Math.abs(Math.abs(b)-Math.abs(a));
        }
        return h;
    }

}
