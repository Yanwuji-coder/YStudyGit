package com.dgd.test;

import java.sql.*;
public class databasetest{

private static Connection con; //声明 Connection 对象
private static PreparedStatement pStmt;//声明预处理 PreparedStatement 对象
private static ResultSet res;//声明结果 ResultSet 对象

private static String url = "jdbc:mysql://localhost:3306/Monitoring?serverTimezone=UTC";// 协议：子协议：//目标IP地址：端口/数据库  在这里Monitoring是之前创建的数据库名
private static String user = "root";
private static String password = "12345678";

public Connection getConnection() {//建立返回值为 Connection 的方法

        //代码块（1）：加载数据库驱动类
        try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }

        //代码块（2）：通过访问数据库的URL获取数据库连接对象
        try {
        con = DriverManager.getConnection(url, user, password);
        System.out.println("数据库连接成功");
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return con;
        }

public static void main(String[] args) {//主方法
        databasetest h = new databasetest();//创建本类对象
        con = h.getConnection();//与数据库建立连接
        queryData();//查询数据
        addData();//增添数据
        //queryData();//查询数据
        //updateData();//更新数据
        //queryData();//查询数据
        //deleteData();//删除数据
        queryData();//查询数据
        }

//代码块（3）：运用SQL语句进行操作
public static void queryData() {

        try {   //mysql查询语句
        String sql = "SELECT * FROM sys_merch";

        //代码块（4）：得到结果集
        pStmt = con.prepareStatement(sql);
        res = pStmt.executeQuery();

        while (res.next()) {//如果当前语句不是最后一条，则进入循环
        //代码块（5）：展示数据集
        System.out.println(res.getString("merch_no") + " "
        + res.getString("merchname") + " " + res.getString("address") +
        " " + res.getString("business") + " " + res.getString("create_merch_no") +
        " " + res.getString("create_time")) ;
        // System.out.println(rs.getString("merch_no"));
        // System.out.println(rs.getString("merchname"));
        // System.out.println( rs.getString("address") + rs.getString("business"));
        }
        res.close();//释放资源
        pStmt.close();
        } catch (SQLException e) {//捕获异常
        e.printStackTrace();
        }
        }


public static void addData() {//添加数据操作
        try {
        //pStmt = con.prepareStatement

        pStmt = con.prepareStatement("insert into sys_merch (merch_no, merchname,address,business,create_merch_no,create_time)" +
                " values('1','man','changsha','buy','1','2016-11-11 11:11:11')");
        pStmt.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace();
        }
        }

public static void updateData() {//更新数据操作
        try {
        pStmt = con.prepareStatement("update sys_merch set address = 'wuhan' where merch_no = 1");
        // pStmt.setString(1, "周礼");通配符
        pStmt.executeUpdate();

        } catch (Exception e) {
        e.printStackTrace();
        }
        }


public static void deleteData() {//删除数据操作
        try {
        Statement stmt = con.createStatement();//创建Statement对象
        stmt.executeUpdate("delete from sys_merch where merch_no = 1 ");
        } catch (Exception e) {
        e.printStackTrace();
        }
        }
}