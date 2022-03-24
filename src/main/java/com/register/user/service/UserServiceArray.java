package com.register.user.service;

import com.register.user.document.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class UserServiceArray
{
    private ArrayList<User> usersList = new ArrayList<>();


    public User create(User user) {
        int size = usersList.size()+1;
        User test = usersList.get(size);
        String id = test.getId()+1;
        user.setId(id);
        usersList.add (user);
        return user;
    }

    public User findByDni(long dni)
    {
        for (User user : usersList)
        {
            if (user.getDni()== dni)
            {
                return user;
            }
        }

        return null;
    }
    public User updatePassword(long dni, String password)
    {
        for(User user : usersList)
        {
          if(user.getDni() == dni) {
              user.setPassword(password);
              return user;
          }
        }
        return null;
    }


    public boolean delete(long dni)
    {
        for(User user: usersList){
            if(user.getDni()== dni){
                usersList.remove(user);
                return true;
            }
        }
        return false;
    }


    public List<User> all() {
        return usersList;
    }
}
