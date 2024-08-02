package ru.skypro.course_work_2.service;

import ru.skypro.course_work_2.model.Question;

import java.util.Collection;

public interface QuestingService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}