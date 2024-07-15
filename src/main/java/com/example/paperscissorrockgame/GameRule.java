package com.example.paperscissorrockgame;

import com.example.paperscissorrockgame.models.Paper;
import com.example.paperscissorrockgame.models.Rock;
import com.example.paperscissorrockgame.models.Scissors;

public class GameRule {
    private static GameRule instance;

    protected GameRule(){}

    public static GameRule getInstance(){

        if(instance == null){
            instance = new GameRule();
        }
        return instance;
    }

    public GameAction paperRule(){

        //Set rules for paper
        Paper paper = new Paper();
        paper.addRule(new Rock(), 1);
        paper.addRule(new Scissors(), -1);
        return paper;

    }
    public GameAction rockRule(){

        //Set rules for rock
        Rock rock = new Rock();
        rock.addRule(new Paper(), -1);
        rock.addRule(new Scissors(), 1);
        return rock;

    }
    public GameAction scissorRule(){

        //Set rules for scissors
        Scissors scissors = new Scissors();
        scissors.addRule(new Rock(), -1);
        scissors.addRule(new Paper(), 1);
        return scissors;

    }
}
