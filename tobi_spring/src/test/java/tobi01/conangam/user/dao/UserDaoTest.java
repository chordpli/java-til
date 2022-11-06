package tobi01.conangam.user.dao;

import java.sql.SQLException;

class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new ChordpliConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
    }
}