package tobi01.conangam.user.dao;

import tobi01.conangam.user.domain.User;

import java.sql.*;

public class UserDao {

    /*중복된 코드를 독립적인 메소드로 만들어 중복 제거*/
    /*private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobi", "root", "1234");
        return c;
    }*/

    /*구현 코드는 제거되고 추상 메소드로 바뀌었다.
    메소드의 구현은 서브클래스가 담당한다.*/
    /*public abstract Connection getConnection() throws ClassNotFoundException, SQLException;*/

    /*private SimpleConnectionMaker simpleConnectionMaker;*/

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        /*Connection c = getConnection(); // DB 연결이 필요할 때, getConnection()메소드 이용*/
        /*Connection c = simpleConnectionMaker.makeNewConnection();*/
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("01");
        user.setName("ChordPlaylist");
        user.setPassword("playlist");

        userDao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + "조회 성공");
    }
}
