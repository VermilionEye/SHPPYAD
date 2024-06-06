package ru.tsarev.services.email;

public interface EmailService {
    void sendEmail(String to, String text);
}