package ru.skypro.course_work_2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.course_work_2.exception.NotMoreQuestionException;
import ru.skypro.course_work_2.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestionTest_Numbers() {
        int amount = 2;
        List<Question> questionList = List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")
        );

        when(javaQuestionService.getAll()).thenReturn(questionList);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questionList.get(0),
                questionList.get(0),
                questionList.get(0),
                questionList.get(1)

        );

        Collection<Question> actualQuestions = examinerService.getQuestion(amount);

        Assertions.assertEquals(Set.of(questionList.get(0), questionList.get(1)), actualQuestions);
        Mockito.verify(javaQuestionService, times(4)).getRandomQuestion();
    }

    @Test
    public void getQuestionTest_Negative() {
        int amount = 5;
        List<Question> questionList = List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")
        );

        when(javaQuestionService.getAll()).thenReturn(questionList);

        Assertions.assertThrows(
                NotMoreQuestionException.class,
                () -> examinerService.getQuestion(amount)
        );
    }
}