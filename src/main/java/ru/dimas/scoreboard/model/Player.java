package ru.dimas.scoreboard.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy ="playerOne")
    private List<MatchResult> matchResultListOne;

    @OneToMany(mappedBy ="playerTwo")
    private List<MatchResult> matchResultListTwo;

    @OneToMany(mappedBy ="playerWin")
    private List<MatchResult> matchResultListWin;

    public Player(String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID = " + getId() + ", name = " + getName();
    }

    public List<MatchResult> getMatchResultListOne() {
        return matchResultListOne;
    }

    public List<MatchResult> getMatchResultListTwo() {
        return matchResultListTwo;
    }

    public List<MatchResult> getMatchResultListWin() {
        return matchResultListWin;
    }

    public void setMatchResultListOne(List<MatchResult> matchResultListOne) {
        this.matchResultListOne = matchResultListOne;
    }

    public void setMatchResultListTwo(List<MatchResult> matchResultListTwo) {
        this.matchResultListTwo = matchResultListTwo;
    }

    public void setMatchResultListWin(List<MatchResult> matchResultListWin) {
        this.matchResultListWin = matchResultListWin;
    }
}
