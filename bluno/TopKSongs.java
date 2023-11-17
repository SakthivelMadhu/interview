package bluno;


// Using HashMap and PriorityQueue

import java.util.*;

public class TopKSongs {

    static class Song {
        String name;
        int count;

        Song(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public static List<String> topKSongs(List<String> songs, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String song : songs) {
            frequencyMap.put(song, frequencyMap.getOrDefault(song, 0) + 1);
        }

        PriorityQueue<Song> minHeap = new PriorityQueue<>((a, b) ->{ 
            if (a.count != b.count) {
                return a.count - b.count;
            } else {
                return songs.indexOf(a.name) - songs.indexOf(b.name);
            }
            });

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(new Song(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().name);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {

        // List<String> songs = Arrays.asList("uptown funk", "paint the town red", "paint the town red",
        // "believers", "snooze", "uptown funk", "uptown funk", "believers", "believers", "believers");
        // int k = 3;

        // test 2:
        // List<String> songs = Arrays.asList("snooze", "daylight" , "snooze", "daylight");
        // int k = 1;

        // test 3:
        // List<String> songs = Arrays.asList("snooze", "daylight","daylight" , "snooze", "daylight");
        // int k = 3;

        List<String> songs = Arrays.asList( "counting stars","counting stars" ,"believers", "believers");
        int k = 3;

        List<String> topSongs = topKSongs(songs, k);

        for (String song : topSongs) {
            System.out.println(song);
        }
    }
}

// Time Complexity : O(n log k)
// space complexity : O(n)



// "Input:
// List<String> songs = Arrays.asList(""counting stars"", ""believers"", ""believers"", ""counting stars"");
//         int k = 3;
// Output:
// believers
// counting stars
// Expected Output:
// counting stars
// believers"