package com.qian.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.qian.service.PersonServiceBean;
import com.qian.user.User;
import com.qian.user.UserSon;

public class StudyTest {

    /**
     * @param args
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // TODO Auto-generated method stub
        ArrayList<String> arrayList1=new ArrayList<String>();  
        arrayList1.add("abc");  
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();  
        arrayList2.add(123);  
        System.out.println(arrayList1.getClass()==arrayList2.getClass()); 
        //List<UserSon> list=new ArrayList<User>();
        arrayList2.getClass().getMethod("add", Object.class).invoke(arrayList2, "qian");
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.println(arrayList2.get(i));
        }
        PersonServiceBean p=new PersonServiceBean();
        //p.doSome(new User(0, null, null));
        System.out.println(StudyTest.<Integer>add(1, 2));
        
    }

    public static <T> T add(T x,T y){
       
        return x;
    }

    
    
}
