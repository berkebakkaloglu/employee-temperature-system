package com.yabim.ets.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfiguration {

	@Value("smtp.mailtrap.io")
	private String host;
	
	@Value("2525")
	private int port;
	
	@Value("b6bce439cf7a07")
	private String username;
	
	@Value("cea3db5aa10346")
	private String password;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmailConfiguration [host=" + host + ", port=" + port + ", username=" + username + ", password="
				+ password + "]";
	}
}
