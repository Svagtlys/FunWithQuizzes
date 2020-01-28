package QuestionTypes;

import java.util.ArrayList;

public class TrueOrFalse extends MultipleChoice {

    private static final ArrayList<String> OPTIONS = new ArrayList<String>(){{add("True"); add("False");}};

    public TrueOrFalse(String question, String correctAnswer) {
        super(question, OPTIONS, correctAnswer);
    }

    public String toString(){
        String result = "True or False: ";

        //Question at top!
        result += question;

        return result;
    }

}
