package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Account;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountDTO {
	private Long id;
	private String account_number;
	private Long money;

	public static AccountDTO fromEntity(Account account) {
		return AccountDTO.builder()
			.id(account.getId())
			.account_number(account.getAccountNumber())
			.money(account.getMoney())
			.build();
	}
}
