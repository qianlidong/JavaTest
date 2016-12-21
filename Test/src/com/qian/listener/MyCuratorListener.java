package com.qian.listener;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;

public class MyCuratorListener implements CuratorListener {

    @Override
    public void eventReceived(CuratorFramework f, CuratorEvent event) throws Exception {
        // TODO Auto-generated method stub
        try {
            System.out.println("自己写一个就行了");
            switch (event.getType()) {
            case CHILDREN:
                System.out.println("监控到CHILDREN变化");
                break;
            case CREATE:
                System.out.println("监控到CREATE变化,"+event.getPath());
            default:
                System.out.println("监控到别的变化");
                break;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }

}
