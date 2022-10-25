package edu.self.algo.easy;

import java.util.Hashtable;

public class TournamentWinner {
    /*
        Programming algo tournament, round robin with each team facing all the other teams. Only two teams compete
        against each other at a time. One team is the home team and the other the visitor. There are no ties, winning
        team receives 3 pts and the loser 0. The winner of the tournament receives the most points.

        Given an array of pairs representing the teams that have competed against each other and an array containing
        the results of each competition, write a function that returns the winner of the tournament. The input arrays
        are named competitions and results. The competitions array has the elements in the form of [homeTeam, awayTeam],
        where each team has a max 30 character name. The results array contains information about the winner of each
        competition in the competitions array. Specifically, results[i] denotes the winner of competitions[i], where a 1
        in the results array indicates the home team won and 0 the away team.

        Its guaranteed that exactly one team will win the tournament and each team will compete against all other teams
        exactly once. Its also guaranteed the tournaments will have at least 2 teams.

     */

    public static String findWinningTeam(String[][] competitions, int[] results) {
        Hashtable<String, Integer> teamPoints = new Hashtable<String, Integer>();
        String currentLeader = "";
        int currentLeaderPts = 0;
        for (int i=0; i < results.length; i++) {
            String tmpTeam = "";
            int tmpPts = 3;
            if (results[i] == 1)
                tmpTeam = competitions[i][0];
            else
                tmpTeam = competitions[i][1];

            if (teamPoints.containsKey(tmpTeam))
                tmpPts = teamPoints.get(tmpTeam) + tmpPts;

            teamPoints.put(tmpTeam, tmpPts);

            if (tmpPts > currentLeaderPts) {
                currentLeader = tmpTeam;
                currentLeaderPts = tmpPts;
            }
        }

        return currentLeader;
    }

    public static void main(String[] args) {
        String[][] competitions = { {"tank", "sisters" }, { "sisters", "dogs"}, {"dogs", "tank"}, {"freaks", "geeks"}, {"geeks", "tank"}, {"sisters", "freaks"}, {"sisters", "geeks"}, {"tank", "freaks"}, {"dogs", "geeks"}, {"freaks", "dogs"}};
        int[] results = {1, 0, 1 , 0, 1, 0, 1, 0, 1, 0};

        System.out.println("Wining team: " + findWinningTeam(competitions, results) );
    }
}
