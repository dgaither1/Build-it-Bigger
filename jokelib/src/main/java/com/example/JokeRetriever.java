package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeRetriever {

    private static List<String> jokes;

    public static String getJoke() {

        if(jokes == null) {
            initializeJokes();
        }

        Random randomizer = new Random();
        return(jokes.get(randomizer.nextInt(jokes.size())));

    }

    private static void initializeJokes() {
        jokes = new ArrayList<>();

        jokes.add("Why did the chicken cross the road? To get to the other side!");
        jokes.add("So what if I can't spell armageddon? It's not the end of the world.");
        jokes.add("My parents didn't want to move to Florida, but they turned 60 and that's the law.");
        jokes.add("I admit that I live in the past, but only because housing is so much cheaper.");
    }


}
