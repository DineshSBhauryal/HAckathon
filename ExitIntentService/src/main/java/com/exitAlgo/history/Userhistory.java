package com.exitAlgo.history;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Userhistory {
	@Id
	
	public String username;
	public double userscore;
	public Userhistory(String name, int score) {
		super();
		this.username = name;
		this.userscore = score;
	}
	public Userhistory() {
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public double getScore() {
		return userscore;
	}
	public void setscore(double score) {
		this.userscore = score;
	}
	@Override
	public String toString() {
		return "Customer [name=" + username + ", score=" + userscore + "]";
	}
}
