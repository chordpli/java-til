package tobi01.conangam.user.dao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new ChordpliConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
    }
}