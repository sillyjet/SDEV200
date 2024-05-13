package com.example.mydigitalmischief;

import java.util.ArrayList;

public class Mischief {
    public Rat myRat1;
    public Rat myRat2;
    public Rat myRat3;
    public Rat question;

    // Currently, the option to have more than 3 rats is not available.
    public Mischief() {
    }

    public boolean adoptRat() {
        if (this.myRat1 == null) {
            this.myRat1 = this.question;
        } else if (this.myRat2 == null) {
            this.myRat2 = this.question;
        } else if (this.myRat3 == null) {
            this.myRat3 = this.question;
        } else {
            Main.dialogue.set("You already have too many rats! Upgrade to a bigger cage to adopt more.");
            return false;
        }
        return true;
    }

    public void setQuestion(Rat rat) {
        this.question = rat;
    }

    public Rat getQuestion() {
        return question;
    }

    public Rat getMyRat1() {
        return myRat1;
    }

    public Rat getMyRat2() {
        return myRat2;
    }

    public Rat getMyRat3() {
        return myRat3;
    }
}
