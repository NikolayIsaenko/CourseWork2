package ru.skypro.course_work_2.service;

import ru.skypro.course_work_2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
