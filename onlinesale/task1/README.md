# Task-1: Simulation of an Event that Follows Given Biasness
# Problem Statement:
Write a program that accepts a map of all possible outcomes of an event along with their probabilities and every occurrence of the event would generate outcomes based on the given probabilities. This could be seen as a generalization of events like rolling of a dice (could be biased) or flipping of a coin (could be biased). 
# Examples
Rolling of a six-faced biased dice
```bash
Input: [ {1, 10}, {2, 30}, {3, 15}, {4, 15}, {5, 30}, {6, 0} ]
```
Flipping of a coin
```bash
Input [ {“Head”: 35}, {“Tail”: 65} ]
```
# Rules
Input: Probabilities given are as integers and percentages.
Each occurrence of the event should only generate one of the outcomes given in input
The outcome of each occurrence is independent of that of others.
On observing a large number (say 1000) of occurrences, the probability distribution should roughly follow the given biasness.
Example
# Input:
```bash
Input: [ {1: 35}, {2: 65} ]  ## 1=Head, 2=Tail
```
# Output:
On triggering the event 1000 times, Head appeared 332 times and Tail 668 times which is roughly inline with the biasness given.
This is just one of the possibilities.
```bash
Head appeared 353 times
Tail appeared 647 times
```
# code:
```bash
package onlinesale.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventSimulation {

    // Define a class to hold outcome and its probability
    static class Outcome {
        String outcome;
        int probability;

        Outcome(String outcome, int probability) {
            this.outcome = outcome;
            this.probability = probability;
        }
    }

    // Method to simulate the event
    public static void simulateEvent(List<Outcome> outcomes, int numOccurrences) {
        int totalProbability = outcomes.stream().mapToInt(o -> o.probability).sum();

        // Validate probabilities
        if (totalProbability != 100) {
            System.out.println("Error: Probabilities do not add up to 100%");
            return;
        }

        Random rand = new Random();
        int[] occurrenceCount = new int[outcomes.size()];

        // Generate outcomes
        for (int i = 0; i < numOccurrences; i++) {
            int randNum = rand.nextInt(100) + 1; // Generate a random number between 1 and 100
            int cumulativeProbability = 0;

            // Determine the outcome based on probabilities
            for (int j = 0; j < outcomes.size(); j++) {
                cumulativeProbability += outcomes.get(j).probability;
                if (randNum <= cumulativeProbability) {
                    occurrenceCount[j]++;
                    break;
                }
            }
        }

        // Display results
        for (int i = 0; i < outcomes.size(); i++) {
            System.out.println(outcomes.get(i).outcome + " appeared " + occurrenceCount[i] + " times");
        }
    }

    public static void main(String[] args) {
        List<Outcome> outcomes = new ArrayList<>();

        // Define the outcomes and their probabilities
        outcomes.add(new Outcome("Head", 35));
        outcomes.add(new Outcome("Tail", 65));

        int numOccurrences = 1000; // Number of times to trigger the event
        simulateEvent(outcomes, numOccurrences);
    }
}

// output : 
// Head appeared 353 times
// Tail appeared 647 times
```

