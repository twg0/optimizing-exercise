package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountRequest {
	private String account_number;
	private Long money;

}
