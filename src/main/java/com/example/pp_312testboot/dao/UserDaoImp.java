package com.example.pp_312testboot.dao;

import com.example.pp_312testboot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers(String sql) {
        return entityManager.createQuery(sql, User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        if (entityManager.find(User.class, id) != null) {
            return entityManager.find(User.class, id);
        } else {
            throw new EntityNotFoundException("getUser no User");
        }
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(int id, User user) {
        if (entityManager.find(User.class, id) != null) {
            User user1 = getUser(id);
            user1.setName(user.getName());
        } else {
            throw new EntityNotFoundException("editUser no User");
        }
    }

    @Override
    public void deleteUser(int id) {
        if (entityManager.find(User.class, id) != null) {
            entityManager.remove(entityManager.find(User.class, id));
        } else {
            throw new EntityNotFoundException("deleteUser no User");
        }
    }
}
