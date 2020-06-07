package ru.raif.quizbot.util;

import ru.raif.quizbot.model.Quiz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.raif.quizbot.model.Quiz.QuizLevel.*;

public interface QuizRepo {

    Quiz getRandomQuiz();

    Quiz getRandomQuiz(Quiz.QuizLevel level);

    List<Quiz> take(Integer countAnyLevel);

    default List<Quiz> take(Integer countEasy, Integer countMedium, Integer countHard) {
        return Stream.of(take(countEasy, EASY), take(countMedium, MEDIUM), take(countHard, HARD))
                .flatMap(List::stream).unordered().collect(Collectors.toList());
    }

    List<Quiz> take(Integer count, Quiz.QuizLevel level);

}
