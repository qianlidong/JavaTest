package com.qian.listener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.qian.user.User;

/**
 * 
 * @author qld
 *
 * @param <T>
 */
public abstract class AbstrcMq<A extends Serializable>{

    //一个抽象的before
    public abstract A before(A t);
    
    public <T> void show(Collection<T> C){

        List<T> list=new ArrayList();
        
    }
}
