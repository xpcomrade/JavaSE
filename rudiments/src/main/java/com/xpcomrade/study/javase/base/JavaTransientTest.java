package com.xpcomrade.study.javase.base;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jesse
 * Date: 13-5-18
 * Time: 上午11:01
 * To change this template use File | Settings | File Templates.
 */
public class JavaTransientTest {
    

    
    public static void main(String[] args) {
        NetUser user = new NetUser(1, "polkm", "小平", "xpcomrade");
        ObjectOutputStream oos = null;
        try {
            //将对象持久化至本地文件中
            oos = new ObjectOutputStream(new FileOutputStream(new File("D://netuser.out")));
            oos.writeObject(user);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)  oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        ObjectInputStream ois = null;
        try {
            //从文件中反序列化持久对象
            ois = new ObjectInputStream(new FileInputStream(new File("D://netuser.out")));
            NetUser u = (NetUser) ois.readObject();
            System.out.printf("uId:%s\n", u.getuId());
            System.out.printf("uName:%s\n", u.getuName());
            System.out.printf("uNickName:%s\n", u.getuNickName());
            System.out.printf("uPwd:%s\n", u.getuPwd());
        } catch (Exception e) {

        } finally {
            try {
                if (ois != null ) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class NetUser implements Serializable{

        private int uId;

        private transient String uName;

        private String uNickName;

        private transient  String uPwd;

        NetUser() {
        }

        NetUser(int uId, String uPwd, String uNickName, String uName) {
            this.uId = uId;
            this.uPwd = uPwd;
            this.uNickName = uNickName;
            this.uName = uName;
        }

        public int getuId() {
            return uId;
        }

        public void setuId(int uId) {
            this.uId = uId;
        }

        public String getuPwd() {
            return uPwd;
        }

        public void setuPwd(String uPwd) {
            this.uPwd = uPwd;
        }

        public String getuName() {
            return uName;
        }

        public void setuName(String uName) {
            this.uName = uName;
        }

        public String getuNickName() {
            return uNickName;
        }

        public void setuNickName(String uNickName) {
            this.uNickName = uNickName;
        }
    }
}


