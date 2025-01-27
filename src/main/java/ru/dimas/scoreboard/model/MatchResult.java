package ru.dimas.scoreboard.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matchResults")
public class MatchResult {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_one_id", referencedColumnName = "id")
    private Player playerOne;

    @ManyToOne
    @JoinColumn(name = "player_two_id", referencedColumnName = "id")
    private Player playerTwo;

    @ManyToOne
    @JoinColumn(name = "player_win_id", referencedColumnName = "id")
    private Player playerWin;

    public MatchResult(Player PlayerOne, Player PlayerTwo, Player PlayerWin) {
        this.id = id;
        this.playerOne = PlayerOne;
        this.playerTwo = PlayerTwo;
        this.playerWin = PlayerWin;
    }

    public MatchResult() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPlayerOne(Player playerOne) {
        playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        playerTwo = playerTwo;
    }

    public void setPlayerWin(Player playerWin) {
        playerWin = playerWin;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerWin() {
        return playerWin;
    }


    @Override
    public String toString() {
        return "pl1: " + playerOne + "   pl2: "+ playerTwo + "   plWin: "+ playerWin;
    }
}
