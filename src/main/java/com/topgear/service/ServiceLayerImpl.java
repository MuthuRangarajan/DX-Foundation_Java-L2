package com.topgear.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topgear.entity.Payments;
import com.topgear.entity.RegistrationService;
import com.topgear.repo.H2;
import com.topgear.repo.H2Payments;

@Service
public class ServiceLayerImpl implements ServiceLayer{

	@Autowired
	H2 h2;
	@Autowired
	H2Payments h2Payments;
	
	@Transactional
	public void FundTransfer(int fromAccount,int toAccount,int amount,String senderName,String payeeName, String remarks)
	{
		h2.fundTransferFrom(fromAccount,amount);
		h2.fundTransferTo(toAccount,amount);
		Payments payments=new Payments();
		payments.setAmount(amount);
		payments.setFromAccount(fromAccount);
		payments.setToAccount(toAccount);
		payments.setPayeeName(payeeName);
		payments.setRemarks(remarks);
		payments.setSenderName(senderName);
	
		h2Payments.save(payments);

	}
	public void Save(RegistrationService reg)
	{
		h2.save(reg);
	}
}
