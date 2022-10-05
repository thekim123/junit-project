package com.thekim12.junitproject.util;

import org.springframework.stereotype.Component;

@Component
public class MailSenderStub implements MailSender {

	@Override
	public boolean send() {
		// TODO Auto-generated method stub
		return true;
	}

}
