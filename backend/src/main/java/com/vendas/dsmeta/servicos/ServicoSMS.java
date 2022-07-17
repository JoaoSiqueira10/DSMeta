package com.vendas.dsmeta.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vendas.dsmeta.entidades.Sale;
import com.vendas.dsmeta.repositorios.RepositorioVenda;

@Service
public class ServicoSMS {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private RepositorioVenda repositorioVenda;
	
	public void sendSms(Long vendaId) {
		
		Sale venda = repositorioVenda.findById(vendaId).get();
		
		String date = venda.getDate().getMonthValue() + "/" + venda.getDate().getYear();
		
		String msg = "O vendedor " + venda.getSellerName() + " foi destaque " + date
				+ " com um total de R$ " + String.format("%.2f", venda.getAmount()); 

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
