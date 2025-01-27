package ru.dimas.scoreboard.model;

public class Match {
    private Integer matchId;
    private Integer idPlayerOne;
    private Integer idPlayerTwo;
    private MatchScore matchScore;

    public Match(Integer matchId, Integer idPlayerOne, Integer idPlayerTwo, MatchScore matchScore) {
        this.matchId = matchId;
        this.idPlayerOne = idPlayerOne;
        this.idPlayerTwo = idPlayerTwo;
        this.matchScore = matchScore;
    }
}
