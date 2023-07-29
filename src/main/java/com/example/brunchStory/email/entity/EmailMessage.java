package com.example.brunchStory.email.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailMessage {

    private String from;
    private String to;
    private String subject;
    private String message;
}
