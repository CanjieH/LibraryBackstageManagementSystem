package com.canjie.DAO;

import com.canjie.model.Book;
import com.canjie.model.User;
import com.canjie.util.DBHelper;

import java.sql.*;
import java.util.*;

//数据逻辑类
public class LibDaoImpl {
    //private static final List<User> userDb = new ArrayList<>(); //用户表
    //private static final List<Map<String, Object>>; //图书分类
    //private static final List<Book> booksl  //图书表

    //获取用户表中的数据
    public ArrayList<User> getAllUsers() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>(); // 用户集合
        try {
            conn = DBHelper.getConnection();
            String sql = "select * from users;"; // SQL语句
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                list.add(user);// 把一个商品加入集合
            }
            return list; // 返回集合。
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //用户注册
    public void regist(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if(isUserExist(user.getUsername()) != 1){
                conn = DBHelper.getConnection();
                String sql = "INSERT INTO users(username, password, phone, email) VALUES(?, ?, ?, ?);"; // SQL语句
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getPhone());
                stmt.setString(4, user.getEmail());
                stmt.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //判断指定的用户名在数据库是否存在,存在则返回1，不存在则返回0
    public int isUserExist(String username) {
        ArrayList<User> list = getAllUsers();
        for(User u : list){
            if(u.getUsername().equals(username)) return 1;
        }
        return 0;
    }

    //用户登录,登陆成功则返回1，否则返回0
    public int login(String username, String password) {
        ArrayList<User> list = getAllUsers();
        for(User u : list){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                //System.out.println("登陆成功！");
                return 1;
            }
        }
        //System.out.println("登录失败！");
        return 0;
    }

    //添加图书分类
    public void addBookCategory(int id, String categoryName, String description) {
        int flag = 0;   //0代表没有重复的id
        Map<String, Object> cate = new HashMap<>();
        cate.put("id", id);
        cate.put("categoryName", categoryName);
        cate.put("description", description);
        for(Map<String, Object> b : Book.getCateList()){
            if(id == (int)b.get("id")) flag = 1;
        }
        if(flag == 0) Book.getCateList().add(cate);
    }

    //获取图书表中的数据
    public ArrayList<Book> getAllBooks() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<Book>(); // 图书集合
        try {
            conn = DBHelper.getConnection();
            String sql = "select * from books;"; // SQL语句
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setCategory(rs.getString("category"));
                book.setPrice(rs.getInt("price"));
                book.setDescript(rs.getString("descript"));
                list.add(book);// 把一个商品加入集合
            }
            return list; // 返回集合。
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //判断指定的书籍ID在数据库是否存在,存在则返回1，不存在则返回0
    public int isBookExist(int id) {
        ArrayList<Book> list = getAllBooks();
        for(Book b : list){
            if(b.getId() == id) return 1;
        }
        return 0;
    }

    //图书添加
    public void addBook(Book book){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if(isBookExist(book.getId()) != 1){
                conn = DBHelper.getConnection();
                String sql = "INSERT INTO books(id, name, category, price, descript) VALUES(?, ?, ?, ?, ?);"; // SQL语句
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, book.getId());
                stmt.setString(2, book.getName());
                stmt.setString(3, book.getCategory());
                stmt.setInt(4, book.getPrice());
                stmt.setString(5, book.getDescript());
                stmt.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //根据条件来查询书籍信息
    public List<Book> getBooksByCondition(String bookID, String bookName, String categoryName) {
        ArrayList<Book> books = getAllBooks();
        List<Book> searchBooks = new ArrayList<>();
        if(bookID != "" && bookName != "" && categoryName != ""){
            for(Book book : books){
                if(book.getId() == Integer.parseInt(bookID) && book.getName().equals(bookName) && book.getCategory().equals(categoryName)) searchBooks.add(book);
            }
        }
        else if(bookID != "" && bookName != ""){
            for(Book book : books){
                if(book.getId() == Integer.parseInt(bookID) && book.getName().equals(bookName)) searchBooks.add(book);
            }
        }
        else if(bookName != "" && categoryName != ""){
            for(Book book : books){
                if(book.getName().equals(bookName) && book.getCategory().equals(categoryName)) searchBooks.add(book);
            }
        }
        else if(bookID != "" && categoryName != ""){
            for(Book book : books){
                if(book.getId() == Integer.parseInt(bookID) && book.getCategory().equals(categoryName)) searchBooks.add(book);
            }
        }
        else if(bookID != ""){
            for(Book book : books){
                if(book.getId() == Integer.parseInt(bookID)) searchBooks.add(book);
            }
        }
        else if(bookName != ""){
            for(Book book : books){
                if(book.getName().equals(bookName)) searchBooks.add(book);
            }
        }
        else if(categoryName != ""){
            for(Book book : books){
                if(book.getCategory().equals(categoryName)) searchBooks.add(book);
            }
        }
        else{

        }
        return searchBooks;
    }

    public static void main(String[] args) {
        LibDaoImpl test = new LibDaoImpl();

        System.out.println("--------用户注册测试--------");
        User registUser = new User("admin", "123456", "18795908137", "admin@qq.com");
        test.regist(registUser);

        System.out.println("-------用户登陆测试--------");
        System.out.println(test.login("admin", "123456"));
        System.out.println(test.login("abcdf", "123456"));
    }

}
