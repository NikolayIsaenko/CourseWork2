package ru.skypro.course_work_2.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.course_work_2.exception.NotMoreQuestionException;
import ru.skypro.course_work_2.model.Question;
import ru.skypro.course_work_2.service.ExaminerService;
import ru.skypro.course_work_2.service.QuestingService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestingService questingService;

    public ExaminerServiceImpl(QuestingService questingService) {
        this.questingService = questingService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > questingService.getAll().size()) {
            throw new NotMoreQuestionException("Вопросов нет!");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questingService.add(questingService.getRandomQuestion());
        }
        return questions;
    }
}
