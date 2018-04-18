package com.jiejing.vo;

import java.util.*;

/**
 * Created by yt on 2017/1/5.
 */
public class AuthBTree {

    private BTreeNode root;

    public AuthBTree() {
        root = new BTreeNode();
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    public BTreeNode getRoot() {
        return this.root;
    }

    /**
     * "15,1501,1502,150103,14,1401,1402,1403,1404,1405,140502,16,1601,17,1701,1702,1704"
     */
    public void buildBTree(ArrayList<Integer> keys) {
        int rootV = -1;
        BTreeNode bTreeRoot = new BTreeNode(rootV);
        setRoot(bTreeRoot);
        int maxV = -1;
        for (Integer k : keys)
            if (k > maxV) maxV = k;
        int level = findLevel(maxV);
        int curLevel = 1;
        while (curLevel <= level) {
            BTreeNode bTreeNode = null;
            List<BTreeNode> levelKeys = new ArrayList<BTreeNode>();
            if (curLevel == 1) {
                bTreeNode = bTreeRoot;
                for (int j = 0; j < keys.size(); j++) {
                    Integer key = keys.get(j);
                    if (9 < key && key < 100) {
                        levelKeys.add(new BTreeNode(key));
                        keys.remove(j);
                        j--;
                    }
                }
                Collections.sort(levelKeys, (o1, o2) -> {
                    return o1.compareTo(o2);
                });
                bTreeNode.setChildren(levelKeys);
            } else {
                for (int m = 0; m < keys.size(); m++) {
                    Integer key = keys.get(m);
                    if (Math.pow(10, 2 * curLevel - 1) - 1 < key && key < Math.pow(10, 2 * curLevel)) {
                        m -= 1;
                        bTreeNode = findParentToFollow(curLevel, key, bTreeRoot);
                        int min = bTreeNode.getKey() * 100;
                        int max = bTreeNode.getKey() * 100 + 99;
                        levelKeys = new ArrayList<BTreeNode>();
                        for (int n = 0; n < keys.size(); n++) {
                            Integer tempKey = keys.get(n);
                            if (tempKey >= min && tempKey <= max) {
                                levelKeys.add(new BTreeNode(tempKey));
                                keys.remove(n);
                                n--;
                            }
                        }
                        Collections.sort(levelKeys, (o1, o2) -> {
                            return o1.compareTo(o2);
                        });
                        bTreeNode.setChildren(levelKeys);
                    }
                }

            }
            curLevel += 1;
        }

    }

    private int findLevel(int value) {
        int level = 0;
        while (Math.floor(value) != 0) {
            value /= 100;
            level += 1;
        }
        return level;
    }

    private BTreeNode findParentToFollow(int curLevel, Integer key, BTreeNode bTreeRoot) {
        BTreeNode retBTree = null;
        BTreeNode bTreeNode = bTreeRoot;
        if (curLevel == 1)
            retBTree = bTreeRoot;
        else {
            for (int i = 1; i < curLevel; i++) {
                int curIValue = (int) Math.floor(key / Math.pow(10, 2 * (curLevel - i)));
                List<BTreeNode> bTreeNodeList = bTreeNode.children;
                for (BTreeNode bTreeNode1 : bTreeNodeList) {
                    if (bTreeNode1.getKey().equals(curIValue)) {
                        retBTree = bTreeNode1;
                        bTreeNode = bTreeNode1;
                    }
                }
            }
        }
        return retBTree;
    }

    public boolean searchKey(Integer key) {
        if (key == 0 || key == -1) {
            if (key.equals(getRoot().getKey()))
                return true;
            else return false;
        }
        int level = findLevel(key);
        BTreeNode bTreeNode = getRoot();
        for (int i = 1; i <= level; i++) {
            int curLevelValue = (int) Math.floor(key / Math.pow(10, 2 * (level - i)));
            List<BTreeNode> bTreeNodeList = bTreeNode.children;
            bTreeNode = elementSearch(bTreeNodeList, curLevelValue);
            if (bTreeNode == null)
                return false;
        }
        return bTreeNode == null ? false : true;

    }

    /**
     * TODO 改为二分查找
     */
    public BTreeNode elementSearch(List<BTreeNode> bTreeNodeList, Integer element) {
        if (bTreeNodeList == null || bTreeNodeList.size() == 0)
            return null;
        for (BTreeNode bTreeNode : bTreeNodeList)
            if (bTreeNode.getKey().equals(element)) {
                return bTreeNode;
            }
        return null;
    }


    /**
     * 一个简单的层次遍历B树实现，用于输出B树。
     */
    public void output() {
        Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BTreeNode node = queue.poll();
            System.out.println(node.getKey());
            if (!node.isLeaf())
                node.children.forEach(n->queue.offer(n));
        }
    }

    private static class BTreeNode implements Comparable<BTreeNode> {
        private Integer key;
        private List<BTreeNode> children;

        private BTreeNode() {
        }

        private BTreeNode(Integer i) {
            key = i;
        }

        public boolean isLeaf() {
            if (children == null || children.size() == 0)
                return true;
            return false;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer k) {
            this.key = k;
        }

        public List<BTreeNode> getChildren() {
            return this.children;
        }

        public void setChildren(List<BTreeNode> bTreeNodeList) {
            this.children = bTreeNodeList;
        }

        @Override
        public int compareTo(BTreeNode o) {
            if (this == o)
                return 0;
            else if (o != null) {
                if (this.key > o.key)
                    return 1;
                else if (this.key < o.key)
                    return -1;
                return 0;
            }
            return 0;
        }
    }

    public boolean simpleSearch(String str,String searchKey){
        String[] strs=str.split(",");
        for(String s:strs)
            if(s.equals(searchKey))
                return true;
        return false;
    }

    public static void main(String args[]) {
        String str = "13,1301,1302,1303,1304,130101,130102,130201,130202,130302,130303,1400,1404,1405,140502,140102,140103,16,1601,1602,1603,17,15,1501,1502,1503,1504,150101,150102,150103,150201,150202,14,1401,1402,1403,1701,1702,1703,1704,1705,1706,170101,170102,170103,170203,170204";
        AuthBTree authBTree = new AuthBTree();
        String[] strs = str.split(",");
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (String s : strs)
            integers.add(Integer.parseInt(s));
        authBTree.buildBTree(integers);
//        String s1=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
//        System.out.println(s1);
        System.out.println(System.currentTimeMillis());//粒度更小
//        System.out.println(authBTree.searchKey(150103));
//        System.out.println(authBTree.searchKey(160101));
//        System.out.println(authBTree.searchKey(0));
//        System.out.println(authBTree.searchKey(15));
//        System.out.println(authBTree.searchKey(1701));
//        System.out.println(authBTree.searchKey(1400));
        System.out.println(authBTree.searchKey(170204));
        System.out.println(authBTree.searchKey(170203));
        System.out.println(authBTree.searchKey(170103));
        System.out.println(authBTree.searchKey(170102));
        System.out.println(authBTree.searchKey(170101));
        System.out.println(authBTree.searchKey(1706));
        System.out.println(authBTree.searchKey(1707));
        System.out.println(authBTree.searchKey(1708));
        System.out.println(authBTree.searchKey(1709));



//        System.out.println(authBTree.simpleSearch(str,"150103"));
//        System.out.println(authBTree.simpleSearch(str,"160101"));
//        System.out.println(authBTree.simpleSearch(str,"0"));
//        System.out.println(authBTree.simpleSearch(str,"15"));
//        System.out.println(authBTree.simpleSearch(str,"1701"));
//        System.out.println(authBTree.simpleSearch(str,"1400"));
//        System.out.println(authBTree.simpleSearch(str,"170204"));
//        System.out.println(authBTree.simpleSearch(str,"170203"));
//        System.out.println(authBTree.simpleSearch(str,"170103"));
//        System.out.println(authBTree.simpleSearch(str,"170102"));
//        System.out.println(authBTree.simpleSearch(str,"170101"));
//        System.out.println(authBTree.simpleSearch(str,"1706"));
//        System.out.println(authBTree.simpleSearch(str,"1707"));
//        System.out.println(authBTree.simpleSearch(str,"1708"));
//        System.out.println(authBTree.simpleSearch(str,"1709"));

//        String e1=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
//        System.out.println(e1);
        System.out.println(System.currentTimeMillis());//粒度更小

//        System.out.println(authBTree.searchKey(1401));
//        System.out.println(authBTree.searchKey(1604));
//        System.out.println(authBTree.searchKey(160101));
//        System.out.println(authBTree.searchKey(150103));
//        System.out.println(authBTree.searchKey(0));
//        System.out.println(authBTree.searchKey(-1));
//        System.out.println(authBTree.searchKey(14));
//        System.out.println(authBTree.searchKey(10));

    }
}