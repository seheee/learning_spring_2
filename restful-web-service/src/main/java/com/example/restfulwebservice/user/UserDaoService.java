package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "sehee1", new Date(), "test1", "701010-1111111"));
        users.add(new User(2, "sehee2", new Date(), "test2", "801111-2222222"));
        users.add(new User(3, "sehee3", new Date(), "test3", "901313-1111111"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateById(int id, User user) {
        int i = 0;
        for(User userTemp : users) {
            if(userTemp.getId() == id) {
                user.setId(id);
                users.set(i, user);
                return user;
            }
            i++;
        }
        return null;
    }

}
