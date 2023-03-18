package com.example.gradle.repository.sql.impl;

import com.example.gradle.repository.sql.UserSql;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserSqlImpl implements UserSql {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long countUser(String userCode) {
        String sql = "select count(*) from user as a where a.user_code like '%" + userCode + "%'";
        Query query = entityManager.createNativeQuery(sql);
        long count = ((Number) query.getSingleResult()).intValue();
        return count;
    }
}
