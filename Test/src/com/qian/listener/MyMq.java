package com.qian.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.qian.user.User;

public class MyMq extends AbstrcMq<User>{

    @Override
    public User before(User u) {
        // TODO Auto-generated method stub
     
        return null;
    }

    @Override
    public <User> void show(Collection<User> C) {
        // TODO Auto-generated method stub
        
        C.add(null);
        super.show(C);
    }

    
    
    
}
