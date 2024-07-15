package com.example.paperscissorrockgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class GameActionAbstract implements GameAction {

    private String action;
    List<Map<String, Integer>> rules;
    private String name;
    List<Hand> gestures;

    @Override
    public String getName() {
        return name;
    }

    public GameActionAbstract(String action){
        this.action = action;
        gestures = new ArrayList<Hand>();
    }

    // Add win and lose combination rule for rock, paper and scissors
    @Override
    public void addRule(GameAction gameAction, int action) {

        gestures.add(new Hand() {

            @Override
            public int getAction() {
                return action;
            }

            @Override
            public GameAction getHandSign() {
                return gameAction;
            }
        });
    }

    @Override
    public List<Hand> getRules() {
        return gestures;
    }
}
