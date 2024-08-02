package ru.skypro.course_work_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.course_work_2.model.Question;
import ru.skypro.course_work_2.service.QuestingService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestingController {

    private final QuestingService questingService;

    public JavaQuestingController(QuestingService questingService) {
        this.questingService = questingService;
    }

    @GetMapping("add")
    public Question addQuesting(String questing, String answer) {
        return questingService.add(questing, answer);
    }

    @GetMapping("remove")
    public Question removeQuesting(String questing, String answer) {
        return questingService.remove(new Question(questing, answer));
    }

    @GetMapping
    public Collection<Question> getQuesting() {
        return questingService.getAll();
    }
}
