import QuestionTypes.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    protected ArrayList<Question> quizQuestions;
    protected String quizName;
    protected int grade;

    public Quiz(ArrayList<Question> quizQuestions, String quizName) {
        this.quizQuestions = quizQuestions;
        this.quizName = quizName;
        this.grade = 0;
    }

    public Quiz(String quizName) {
        this.quizName = quizName;
        this.quizQuestions = new ArrayList<>();
        this.grade = 0;
    }

    public void addQuestion(Question q){
        this.quizQuestions.add(q);
    }

    public void runQuiz(){
        System.out.println(this.quizName);
        System.out.println("This quiz contains " + this.quizQuestions.size() + " questions. \n" +
                "Please allocate a reasonable amount of time to complete the quiz.\n" +
                "Type \"Next\" after you are done answering the question.\n" +
                "If you choose the wrong answer on a checkbox question, simply type it again to remove it.\n" +
                "To see your current answer(s), type \"ANSWERS\"");

        Scanner input = new Scanner(System.in);
        String answer = "";



        for(int i = 0; i < this.quizQuestions.size(); i++){

            Question q = this.quizQuestions.get(i);

            System.out.println(q.toString());

            boolean given = true;

            do{
                if(given == false){
                    System.out.println("That wasn't a viable answer.");
                }
                answer = input.nextLine();
                given = q.giveAnswer(answer);


            }while(! answer.toLowerCase().equals("next"));

            if(q.checkAnswer() == true){
                this.grade += 1;
            }
        }
    }

    public void getLatestGrade(){
        System.out.println("You last scored " + this.grade + " correct answers out of " + this.quizQuestions.size() + " questions.");
    }
}
