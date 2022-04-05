//package com.epam.web.dao;
//
//import com.epam.web.entity.User;
//import com.epam.web.exception.DaoException;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Optional;
//
//public class SimpleUserDao implements UserDao {
//
//    @Override
//    public Optional<User> findUserByLoginAndPassword(final String login, final String password) throws DaoException {
//        try {
//            Class.forName("org.h2.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction",
//                    "root", "123qwe123");
//            try (PreparedStatement statement = connection.prepareStatement("SELECT ID, LOGIN FROM USER WHERE LOGIN = ? " +
//                    "AND PASSWORD = MD5(?)")) {
//                statement.setString(1, login);
//                statement.setString(2, password);
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    if (resultSet.next()) {
//                        return Optional.of(new User(resultSet.getLong("ID"), resultSet.getString("LOGIN")));
//                    }
//                }
//            }
//            return Optional.empty();
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new DaoException(e);
//        }
//    }
//}
