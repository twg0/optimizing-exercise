package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Account;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public class AccountDTO {
	private Long id;
	private String account_number;
	private Long money;

	public AccountDTO fromEntity(Account account) {
		return AccountDTO.builder()
			.id(account.getId())
			.account_number(account.getAccount_number())
			.money(account.getMoney())
			.build();
	}
}
