package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountRequest {
	private Long id;
	private String account_number;
	private Long money;

}
