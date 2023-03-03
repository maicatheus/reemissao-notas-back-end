package com.softwares.factory;


import com.softwares.dto.ClienteDto;

public class ClienteFactory {
    public static ClienteDto cliente01() {
        return ClienteDto.builder()
                .email("email01@gmail.com")
                .cnpjCpf(12345678909L)
                .ie(123456L)
                .build();
    }
}
