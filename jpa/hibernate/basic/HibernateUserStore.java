package com.practice.jpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUserStore {
    private static EntityManagerFactory emFactory;
    public EntityManager createEntityManger() {
        if (emFactory != null) {
            return emFactory.createEntityManager();
        }

        emFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = emFactory.createEntityManager();

        return em;
    } //DB와 연결된 객체와 일반 자바 객체를 구별

    //create
    public void createUser(User user) {
        EntityManager em = this.createEntityManger();
        EntityTransaction tx = em.getTransaction();
        //Transaction 처리

        tx.begin(); //트랜잭션 시작

        //비즈니스 로직
        em.persist(user);

        //트랜잭션 정상 종료(커밋)
        tx.commit();
        em.close();
    }

    //select
    public User selectUser(int userNo) {
        EntityManager em = this.createEntityManger();

        User user =  em.find(User.class, userNo); //기본키로 데이터 찾기

        em.close();

        return user;
    }

    //delete
    public void removeUser(String userId) {
        EntityManager em = this.createEntityManger();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.remove(userId);

        tx.commit();
        em.close();
    }

    //update
    public void updateUser(User paramUser) {
        EntityManager em = this.createEntityManger();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        User user = em.find(User.class, paramUser.getId());
        user.setId(paramUser.getId());
        user.setName(paramUser.getName());
        user.setPassword(paramUser.getPassword());

        tx.commit();
        em.close();
    }
}
