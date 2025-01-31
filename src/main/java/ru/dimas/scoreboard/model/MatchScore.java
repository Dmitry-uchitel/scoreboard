package ru.dimas.scoreboard.model;

import java.util.Objects;

public class MatchScore {

    private String nameOne;
    private String nameTwo;

    public MatchScore(String nameOne, String nameTwo) {
        this.nameOne = nameOne;
        this.nameTwo = nameTwo;
    }


    private Integer setsOne = 0;
    private Integer gamesOne = 0;
    private Integer pointsOne = 0;

    private Integer setsTwo = 0;
    private Integer gamesTwo = 0;
    private Integer pointsTwo = 0;

    private Boolean endMatch = false;
    private Boolean tayBreak = false;

    @Override
    public String toString() {
        return String.format("playerOne: %10s  --- g1: %d, s1: %d, p1: %d     endMatch = %b\n",nameOne,  setsOne, gamesOne, pointsOne, endMatch)+
                String.format("playerTwo: %10s  --- g2: %d, s2: %d, p2: %d     tayBreak = %b\n",nameTwo,  setsTwo, gamesTwo, pointsTwo, tayBreak);
    }

    private void addPointToPlayer(Point point) {
        if (point == Point.ONE) {
            switch (pointsOne) {
                case 0:
                case 15: {
                    pointsOne += 15;
                    break;
                }
                case 30: {
                    pointsOne += 10;
                    break;
                }
                case 40: {
                    pointsOne = 0;
                    pointsTwo = 0;
                    gamesOne++;
                }
            }
        }
        else {
            switch (pointsTwo) {
                case 0:
                case 15: {
                    pointsTwo += 15;
                    break;
                }
                case 30: {
                    pointsTwo += 10;
                    break;
                }
                case 40: {
                    pointsOne = 0;
                    pointsTwo = 0;
                    gamesTwo++;
                }
            }
        }
    }

    public void matchStep(Point point){
        if (endMatch == false) {
            switch (point) {
                case ONE: {
                    addPointToPlayer(Point.ONE);
                    break;
                }
                case TWO: {
                    addPointToPlayer(Point.TWO);
                }
            }
            if (isTayBreak()) {
                tayBreak = true;
            }
            if (isEndOfGame()) {
                switch (point) {
                    case ONE: {
                        setsOne++;
                        gamesOne=0;
                        gamesTwo=0;
                        break;
                    }
                    case TWO:
                        setsTwo++;
                        gamesTwo=0;
                        gamesOne=0;
                }
            }
        }
        if (isEndOfMatch()){
            endMatch = true;
        }
    }

    private boolean isEndOfMatch() {
        return setsTwo == 2 || setsOne == 2;
    }

    private boolean isTayBreak(){
        return Objects.equals(gamesOne, gamesTwo) && gamesOne == 6;
    }

    private Boolean isEndOfGame(){
        if (gamesOne == 6 && gamesTwo <= 4) {
            return true;
        }
        if (gamesTwo == 6 && gamesOne <= 4) {
            return true;
        }
        if (gamesOne == 7 && gamesTwo == 5) {
            return true;
        }
        if (gamesTwo == 7 && gamesOne == 5) {
            return true;
        }
        if (tayBreak && (gamesTwo==7 || gamesOne==7)){
            return true;
        }
        return false;
    }

    public Boolean getEndMatch() {
        return endMatch;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getNameTwo() {
        return nameTwo;
    }

    public void setNameTwo(String nameTwo) {
        this.nameTwo = nameTwo;
    }

    public Integer getSetsOne() {
        return setsOne;
    }

    public Integer getGamesOne() {
        return gamesOne;
    }

    public Integer getPointsOne() {
        return pointsOne;
    }

    public Integer getSetsTwo() {
        return setsTwo;
    }

    public Integer getGamesTwo() {
        return gamesTwo;
    }

    public Integer getPointsTwo() {
        return pointsTwo;
    }

}
