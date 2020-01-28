package QuestionTypes;

import java.util.ArrayList;

public abstract class Question{
    protected String question;
    protected ArrayList<String> options;
    protected ArrayList<String> correctAnswer;
    protected ArrayList<String> userAnswer;

    Question(String question, ArrayList<String> options, ArrayList<String> correctAnswer){
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.userAnswer = new ArrayList<>();
    }

    public boolean checkAnswer(){
        //compare correctAnswer and userAnswer: if lengths differ, incorrect. if answers different, incorrect
        //(len > 1, userAnswer may be out of order but correct). else correct
        if(this.userAnswer.size() != this.correctAnswer.size()){
            return false;
        }

        int numCorrect = 0;
        for(String user : this.userAnswer){
            for(String correct : this.correctAnswer){
                if(user == correct){
                    numCorrect += 1;
                    break;
                }
            }
        }

        if(numCorrect != this.correctAnswer.size() || numCorrect != this.userAnswer.size()) //If more answers than correct or more correct than answered
            return false;

        return true;
    }

    public boolean giveAnswer(String answer){
        if(answer.toLowerCase().equals("answers")){
            System.out.println(showCurrentAnswer());
            return true;
        }

        for(int i = 0; i < this.options.size(); i++){
            if(this.options.get(i).toLowerCase().equals(answer.toLowerCase())){
                this.userAnswer.add(this.options.get(i));
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String result = "";

        //Question at top!
        result += question;
        result += "\n";

        //Answers below in one line
        result += options.toString();

        return result;
    }

    public String showCurrentAnswer(){
        return this.userAnswer.toString();
    }

}
