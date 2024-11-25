package com.examportal.util;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Connection;

public class DBUtil {
  private static Properties properties = new Properties();

  static {
    try (InputStream input = DBUtil.class.getClassLoader()
        .getResourceAsStream("application.properties")) {
      properties.load(input);
      Class.forName(properties.getProperty("db.driver"));
    } catch (Exception e) {
      throw new RuntimeException("Failed to load database properties", e);
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(
        properties.getProperty("db.url"),
        properties.getProperty("db.username"),
        properties.getProperty("db.password"));
  }
}
