package com.topgear.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class RegistrationService {
   
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int accountNumber;
	String userName;
	String password;
	String email;
	String securityQuestion;
	String answer;
	int amount;
	
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
public RegistrationService() {}
	public RegistrationService(String userName, String password) {
	
		this.userName = userName;
		this.password = password;
	}
	

	 public int getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegistrationService [accountNumber=" + accountNumber + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", securityQuestion=" + securityQuestion + ", answer=" + answer
				+ ", amount=" + amount + "]";
	}


	
}
