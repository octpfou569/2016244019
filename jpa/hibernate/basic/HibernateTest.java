package com.practice.jpaTest;


public class HibernateTest {
    private HibernateUserStore hibernateUserStore;

    public static void main(String[] args) {
        HibernateTest ht = new HibernateTest();

        ht.hibernateUserStore = new HibernateUserStore();

        User user = ht.hibernateUserStore.selectUser(1);
        System.out.println(user.getName());
    }
}