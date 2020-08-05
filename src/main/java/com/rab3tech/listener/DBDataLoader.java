package com.rab3tech.listener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class DBDataLoader implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("()@(@(@*(contextInitialized@*@*@@*");
		// This is new code to access Spring Root Web Application Context
		ServletContext servletContext=arg0.getServletContext();
		ApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		// ProfileDao
		// profileDao=applicationContext.getBean(ProfileDaoImpl.class);
		try {
			File file = ResourceUtils.getFile("classpath:db/script.sql");
			String content = FileUtils.readFileToString(file);
			Connection conn = null;
			try {
				DataSource dataSource= (DataSource) applicationContext.getBean("pdataSource");
				conn = dataSource.getConnection();
				System.out.println("aadasd"+conn);
				boolean execute = false;
				try {
					PreparedStatement preparedStatement = conn.prepareStatement("select username from iuser_login_tbl");
					ResultSet rs = preparedStatement.executeQuery();
					if (!rs.next()) {
						execute = true;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					execute = true;
				}

				if (execute) {
					conn.setAutoCommit(false);
					ScriptUtils.executeSqlScript(conn, new ByteArrayResource(content.getBytes()));
					System.out.println("~~~~~~~~~~~~~~~~~~~~Script is executed successfully for the database ");
					conn.commit();//
				}

			} catch (Exception e) {
				if (conn != null) {
					try {
						conn.rollback();
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}