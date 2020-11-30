package com.topgear.service;

import org.springframework.stereotype.Service;

import com.topgear.entity.RegistrationService;
@Service
public interface ServiceLayer {

	public void Save(RegistrationService reg);
 public void FundTransfer(int fromAccount,int toAccount,int amount,String senderName,String payeeName, String remarks);
}
