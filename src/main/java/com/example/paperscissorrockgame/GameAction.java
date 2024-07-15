package com.example.paperscissorrockgame;

import java.util.List;
import java.util.Optional;

import static com.example.paperscissorrockgame.Constant.*;

public interface GameAction {

    String getName();
    void addRule(GameAction gameAction, int action);
    List<Hand> getRules();

    //Decide if the player won or lost
    default String getDecision(GameAction gameAction, Score score){

        if(this.getClass().isAssignableFrom(gameAction.getClass())){
            return TIE_MESSAGE;
        }

        Optional<Hand> result = getRules().stream().filter(hand -> hand.getHandSign().getClass().isAssignableFrom(gameAction.getClass())).findAny();

        if(result.isPresent()){
            if(result.get().getAction() == 1){
                score.gameWon++;
                return WIN_MESSAGE;
            }
                score.gameLost++;
                return LOST_MESSAGE;
        }
        score.gameLost++;
        return LOST_MESSAGE;

    }

    default String playAgainst(GameAction gameActionGesture, Score score){
        return getDecision(gameActionGesture, score);
    }
}
