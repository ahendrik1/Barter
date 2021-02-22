package com.example.barter.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Success {
    private int statusCode;
    private String statusMessage;
}
