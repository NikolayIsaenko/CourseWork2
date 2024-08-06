package ru.skypro.course_work_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotMoreQuestionException extends RuntimeException {
    public NotMoreQuestionException(String message) {
        super(message);
    }
}
