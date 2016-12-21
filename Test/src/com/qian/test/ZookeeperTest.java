package com.qian.test;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import com.qian.listener.MyCuratorListener;

public class ZookeeperTest {

	private CuratorFramework client;
	private LeaderSelector leaderSelector;
		static CuratorFramework zkclient=null;
	 public CuratorEvent event;
		static String nameSpace="php";
		static {
			  String zkhost="211.88.2.250:2181";//zk的host
			  RetryPolicy rp=new ExponentialBackoffRetry(1000, 3);//重试机制
			  Builder builder = CuratorFrameworkFactory.builder().connectString(zkhost)
					  .connectionTimeoutMs(5000)
					  .sessionTimeoutMs(5000)
					  .retryPolicy(rp);
			  //builder.namespace(nameSpace);
			  CuratorFramework zclient = builder.build();
			  zkclient=zclient;
			  zkclient.start();// 放在这前面执行
//			  zkclient.newNamespaceAwareEnsurePath(nameSpace);
		}
		public static void main(String[] args) throws Exception{
		    ZookeeperTest zoo=new ZookeeperTest();
		    //zoo.testZoo();
		    //创建一个节点用java
		    zoo.createrOrUpdate("/test/java", "我是测试的");
		    //删除一个节点
		   // zoo.delete("/maypath");

		    //
		    zoo.watch("/maypath1");
		}
		
		public void testZoo(){
		  
			client = CuratorFrameworkFactory.newClient("211.88.2.250:2181", new ExponentialBackoffRetry(2000,2));
			client.start();
		}
		
		/**
		 * 创建或更新一个节点
		 * 
		 * @param path 路径
		 * @param content 内容
		 * **/
		public void createrOrUpdate(String path,String content)throws Exception{
//			zkclient.newNamespaceAwareEnsurePath(path).ensure(zkclient.getZookeeperClient());
//		    zkclient.setData().forPath(path,content.getBytes());	
		    zkclient.create().withMode(CreateMode.PERSISTENT).forPath("/mypath1",new byte[88]);
		    System.out.println("添加成功！！！");
		 
		    
		}
		/**
		 * 删除zk节点
		 * @param path 删除节点的路径
		 * 
		 * **/
		public void delete(String path)throws Exception{
			zkclient.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
			System.out.println("删除成功!");
		}
		
		/**
		 * 为节点设置监视点
		 */
		public void watch(String path) throws Exception{
		    zkclient.getData().inBackground().forPath(path);
//		    MyCuratorListener mc=new MyCuratorListener();
//		    mc.eventReceived(zkclient, event);
		    zkclient.getCuratorListenable().addListener(new CuratorListener() {
                
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
            });
		   
		    System.out.println("设置监视点成功");
		}
		/**
		 * 判断路径是否存在
		 * @param path
		 * **/
		public void checkExist(String path)throws Exception{
			if(zkclient.checkExists().forPath(path)==null){
				System.out.println("路径不存在!");
			}else{
				System.out.println("路径已经存在!");
			}
		}
		/**
		 * 读取的路径
		 * @param path
		 * **/
		public void read(String path)throws Exception{
			String data=new String(zkclient.getData().forPath(path),"gbk");
			System.out.println("读取的数据:"+data);
		}
		/**
		 * @param path 路径
		 * 获取某个节点下的所有子文件
		 * */
		public void getListChildren(String path)throws Exception{
			List<String> paths=zkclient.getChildren().forPath(path);
			for(String p:paths){
				System.out.println(p);
			}
		}
		/**
		 * @param zkPath zk上的路径
		 * @param localpath 本地上的文件路径
		 * 
		 * **/
		public void upload(String zkPath,String localpath)throws Exception{
			createrOrUpdate(zkPath, "");//创建路径
			byte[] bs=FileUtils.readFileToByteArray(new File(localpath));
			zkclient.setData().forPath(zkPath, bs);
			System.out.println("上传文件成功！");
		}
	
}
