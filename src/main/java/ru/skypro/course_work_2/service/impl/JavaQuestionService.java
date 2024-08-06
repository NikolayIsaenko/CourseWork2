package ru.skypro.course_work_2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.course_work_2.model.Question;
import ru.skypro.course_work_2.service.QuestingService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestingService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("Что такое bytecode?", "Bytecode в Java - это набор инструкций, разработанных для исполнения на виртуальной машине Java (JVM).");
        add("Что такое конструкторы?", "Конструкторы - это методы класса в Java, которые вызываются при создании нового объекта этого класса. Их основная задача - инициализировать поля нового объекта.");
        add("Что такое ООП?", "OOП - это методология программирования, в которой программа строится на основе объектов, которые имеют свойства и поведение.");
        add("Что такое SOLID?", "SOLID - это аббревиатура, используемая для описания пяти основных принципов объектно-ориентированного программирования (ООП), которые помогают разработчикам создавать более поддерживаемый и расширяемый код.");
        add("Что такое перегрузка (overloading) метода?", "Перегрузка метода (method overloading) в Java - это возможность определения нескольких методов с одним и тем же именем, но с разными параметрами. Компилятор определяет, какой из перегруженных методов нужно вызвать на основе типов аргументов, переданных в вызове.");

    }

    @Override
    public Question add(String question, String answer) {

        Question questionAdd = new Question(question, answer);
        questions.add(questionAdd);
        return questionAdd;
    }


    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}
