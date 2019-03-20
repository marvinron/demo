package com.example.demo.common.pattern;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-12 10:45
 */
public class AccountImpl implements Account {
    @Override
    public void queryAccount() {
        System.out.println("查询账户！");
    }

    @Override
    public void updateAccount() {
        System.out.println("更新账户！！");

    }
}
