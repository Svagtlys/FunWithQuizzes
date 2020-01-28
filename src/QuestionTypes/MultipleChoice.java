package QuestionTypes;

import java.util.ArrayList;

public class MultipleChoice extends Question {
    public MultipleChoice(String question, ArrayList<String> options, String correctAnswer) {
        super(question, options, new ArrayList<String>(){{add(correctAnswer);}});
    }

    public boolean giveAnswer(String answer){
        if(answer.toLowerCase().equals("answers")){
            System.out.println(showCurrentAnswer());
            return true;
        }

        for(int i = 0; i < this.options.size(); i++){
            if(this.options.get(i).toLowerCase().equals(answer.toLowerCase())){
                this.userAnswer = new ArrayList<String>();
                this.userAnswer.add(this.options.get(i));
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String result = "Multiple Choice: ";

        //Question at top!
        result += question;
        result += "\nPick ONE of the below.\n";

        //Answers below in one line
        result += options.toString();

        return result;
    }

}
