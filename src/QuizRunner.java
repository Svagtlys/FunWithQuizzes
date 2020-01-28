import QuestionTypes.Checkbox;
import QuestionTypes.MultipleChoice;
import QuestionTypes.TrueOrFalse;

import java.util.ArrayList;

public class QuizRunner {
    public static void main(String[] args){

        Quiz myFirstQuiz = new Quiz("My First Quiz");

        myFirstQuiz.addQuestion(
                new MultipleChoice(
                        "What is the first letter of the alphabet?",
                        new ArrayList<String>(){{add("B"); add("Z"); add("A"); add("F");}},
                        "A")
        );
        myFirstQuiz.addQuestion(
                new Checkbox(
                        "What years are in the 21st century?",
                        new ArrayList<String>(){{add("1991"); add("2001"); add("2006"); add("2099"); add("2100");}},
                        new ArrayList<String>(){{add("2001"); add("2006"); add("2099");}}
                )
        );
        myFirstQuiz.addQuestion(
                new TrueOrFalse(
                        "Java is an object-oriented programming language?",
                        "True"
                )
        );

        myFirstQuiz.runQuiz();

        myFirstQuiz.getLatestGrade();

    }
}
