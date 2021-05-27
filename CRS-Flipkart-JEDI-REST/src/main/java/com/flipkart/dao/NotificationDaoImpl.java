package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;

public class NotificationDaoImpl implements NotificationDaoInterface {

	private static Logger logger = Logger.getLogger(NotificationDaoImpl.class);

	private static volatile NotificationDaoImpl instance = null;

	// private constructor
	private NotificationDaoImpl() {
	}

	public static NotificationDaoImpl getInstance() {
		if (instance == null) {
			synchronized (NotificationDaoImpl.class) {
				instance = new NotificationDaoImpl();
			}
		}
		return instance;
	}

	@Override
	public ArrayList<String> fetchMessages(int studentId) {

		ArrayList<String> messages = new ArrayList<String>();
		Connection conn = DBUtil.getConnection();
		try {

			String sql = "SELECT * FROM `crs-flipkart`.notifications where studentId=?";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				messages.add(rs.getString(2));
			}

		} catch (Exception ex) {
			logger.info("Exception occured");
		}

		return messages;

	}

	@Override
	public boolean deleteMessage(int notificationId) {
		Connection conn = DBUtil.getConnection();
		try {

			String sql = "DELETE FROM `crs-flipkart`.`notifications` WHERE (`notificationId` = ?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, notificationId);
			statement.executeUpdate();

			return true;

		} catch (Exception ex) {
			logger.info("Exception occured");
			return false;
		}
	}

	@Override
	public boolean insertNotification(String message, int studentId) {
		Connection conn = DBUtil.getConnection();
		try {
			System.out.println("inside insert notifiaction");
			String sql = "INSERT INTO `crs-flipkart`.`notifications` (`message`, `studentId`) VALUES (?,?);";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, message);
			statement.setInt(2, studentId);

			statement.executeUpdate();

			return true;

		} catch (Exception ex) {
			logger.info(ex);
			return false;
		}
	}	
}
