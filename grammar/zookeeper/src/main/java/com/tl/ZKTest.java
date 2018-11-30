package com.tl;

import org.apache.zookeeper.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianlei on 2018/11/28
 */
public class ZKTest {


    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            try {
                ZooKeeper zk = new ZooKeeper("localhost:2181", 2000, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("1" + event.toString());
                        Event.KeeperState keeperState = event.getState();
                        Event.EventType eventType = event.getType();
                        System.out.println(event);
                        if (Event.KeeperState.SyncConnected == keeperState) {
                            if (Event.EventType.None == eventType) {
                                System.out.println("连接成功");
                            }
                        }

                    }
                });


                String path = "/testRoot/temp";
                String name = zk.create(path, "value=1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                //
                System.out.println("createNode:" + name);
                System.out.println("children:" + zk.getChildren("/testRoot", false));


                //
                zk.delete(path, -1);
                TimeUnit.SECONDS.sleep(5);
                byte[] data = zk.getData("/testRoot", false, null);
                System.out.println(new String(data));
                System.out.println(zk.getChildren("/testRoot", false));

                TimeUnit.SECONDS.sleep(20);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }).start();


        new Thread(() -> {

            try {


                ZooKeeper zk = new ZooKeeper("localhost:2181", 2000, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("1" + event.toString());
                        Event.KeeperState keeperState = event.getState();
                        Event.EventType eventType = event.getType();
                        System.out.println(event);
                        if (Event.KeeperState.SyncConnected == keeperState) {
                            if (Event.EventType.None == eventType) {
                                System.out.println("连接成功");
                            }
                        }

                    }
                });

                zk.exists("/testRoot/temp", new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("watcher: " + event.toString());
                    }
                });

                TimeUnit.SECONDS.sleep(20);

            } catch (Exception e) {
                e.printStackTrace();
            }


        });


//        zk.create("/testRoot", "value=0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//
//        try {
//            zk.create("/testRoot", "value=0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        } catch (KeeperException.NodeExistsException e) {
//            System.out.println("节点已经存在");
//        }


    }


}
