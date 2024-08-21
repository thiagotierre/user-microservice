package com.ms.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
