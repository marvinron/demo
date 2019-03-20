package com.example.demo.proxy;

/**
 * @author houlei
 * @DESC:买房子代理公司
 * @create 2019-01-16 9:38
 */
public class BuyHouseCompany {
    private  BuyHouse buyHouse = new BuyHouse();
     public void proxyBuyHouse(){
         System.out.println("我是买房代理，请问有什么需求");
         buyHouse.buyHouse();
         System.out.println("好，我这就为你买房");
     }

    public static void main(String[] args) {
        BuyHouseCompany buyHouseCompany = new BuyHouseCompany();
        buyHouseCompany.proxyBuyHouse();
    }
}
