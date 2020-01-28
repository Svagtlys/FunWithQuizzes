package QuestionTypes;

import java.util.ArrayList;

public class Checkbox extends Question {

    public Checkbox(String question, ArrayList<String> options, ArrayList<String> correctAnswer) {
        super(question, options, correctAnswer);
    }

    public boolean giveAnswer(String answer){
        if(answer.toLowerCase().equals("answers")){
            System.out.println(showCurrentAnswer());
            return true;
        }

        for(int i = 0; i < this.options.size(); i++){
            if(this.options.get(i).toLowerCase().equals(answer.toLowerCase())){
                for (int j = 0; j < this.userAnswer.size(); j++){ //test if answer is already given
                    if(this.userAnswer.get(j).toLowerCase().equals(answer.toLowerCase())){
                        this.userAnswer.remove(j);
                        this.userAnswer.trimToSize();
                        System.out.println("I've removed that from your final answer.");
                        return true;
                    }
                }
                this.userAnswer.add(this.options.get(i));
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String result = "Checkbox: ";

        //Question at top!
        result += question;
        result += "\nPick as many of the below as you want.\n";

        //Answers below in one line
        result += options.toString();

        return result;
    }
}
