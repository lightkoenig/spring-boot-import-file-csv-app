package com.project.springbootimportfilecsvapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication
public class SpringBootImportFileCsvAppApplication {

	public static void main(String[] args) {

		String sql_create_db = "create database if not exists csvdatadb";
		String jdbcUrl="jdbc:mysql://localhost:3434/csvdatadb";
		String username="root";
		String password="admin";

		String filePath="src\\main\\resources\\data.csv";

		Connection connection=null;

		try{
			connection= DriverManager.getConnection(jdbcUrl,username,password);
			connection.setAutoCommit(false);

			String sql_create = "create table betriebsstelle(name varchar(40), kurs_name varchar(40),typ varchar(40))";
			String sql="insert into betriebsstelle(name,kurs_name,typ) values(?,?,?)";
			String sql_delete = "drop table if exists betriebsstelle";

			PreparedStatement createStatement = connection.prepareStatement(sql_create_db);
			PreparedStatement removeStatement = connection.prepareStatement(sql_delete);
			PreparedStatement preparedStatement = connection.prepareStatement(sql_create);
			PreparedStatement statement=connection.prepareStatement(sql);

			createStatement.execute();
			removeStatement.execute();
			preparedStatement.execute();

			BufferedReader lineReader=new BufferedReader(new FileReader(filePath));

			String lineText=null;
			lineReader.readLine();

			while ((lineText=lineReader.readLine())!=null){
				String[] data=lineText.split(",");

				//String id=data[0];
				String name=data[1];
				String kurs_name=data[2];
				String typ=data[3];

				//statement.setInt(1,parseInt(id));
				statement.setString(1,name);
				statement.setString(2,kurs_name);
				statement.setString(3,typ);
				statement.addBatch();
				statement.executeBatch();
			}
			lineReader.close();

			statement.executeBatch();
			connection.commit();
			connection.close();
			//System.out.println("Data has been inserted successfully.");
		}
		catch (Exception exception){
			exception.printStackTrace();
		}

		SpringApplication.run(SpringBootImportFileCsvAppApplication.class, args);
	}

}
