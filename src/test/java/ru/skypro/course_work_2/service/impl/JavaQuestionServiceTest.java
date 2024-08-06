package ru.skypro.course_work_2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course_work_2.model.Question;
import ru.skypro.course_work_2.service.QuestingService;

import java.util.Collection;
import java.util.Set;

public class JavaQuestionServiceTest {
    private  QuestingService questingService;

    @BeforeEach
    public void clear() {
        questingService = new JavaQuestionService();
    }

    @Test
    public void addTest() {
        Question expectedQuestion = new Question("question", "answer");

        Question actualQuestion1 = questingService.add(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        Question actualQuestion2 = questingService.add(expectedQuestion);


        Assertions.assertEquals(expectedQuestion.getQuestion(), actualQuestion1.getQuestion());
        Assertions.assertEquals(expectedQuestion.getAnswer(), actualQuestion1.getAnswer());
        Assertions.assertEquals(expectedQuestion, actualQuestion2);
    }

    @Test
    public void removeTest() {
        Question question = new Question("question", "answer");
        questingService.remove(question);

        Question actualQuestion = questingService.remove(question);

        Assertions.assertEquals(question, actualQuestion);

    }

    @Test
    public void getAllTest() {
        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question2", "answer2");

        questingService.add(question1);
        questingService.add(question2);

        Collection<Question> actualQuestion = questingService.getAll();

        Assertions.assertEquals(Set.of(question1, question2), actualQuestion);
    }

    @Test
    public void getRandomQuestionTest() {

        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question2", "answer2");

        questingService.add(question1);
        questingService.add(question2);

        Question randomQuestion = questingService.getRandomQuestion();

        Assertions.assertTrue(Set.of(question1, question2).contains(randomQuestion));

    }
}
