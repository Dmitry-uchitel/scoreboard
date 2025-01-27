package ru.dimas.scoreboard.model;

import java.util.Objects;

public class MatchScore {

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
        return String.format("g1: %d, s1: %d, p1: %d     endMatch = %b\n",gamesOne, setsOne, pointsOne, endMatch)+
                String.format("g2: %d, s2: %d, p2: %d     tayBreak = %b\n",gamesTwo, setsTwo, pointsTwo, tayBreak);
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
        switch (point){
            case ONE: {addPointToPlayer(Point.ONE);
                break;}
            case TWO: {addPointToPlayer(Point.TWO); }
        }
        if (isTayBreak()){
            tayBreak=true;
        }
        if (isEndOfGame()){
            switch (point){
                case ONE: {
                    setsOne++;
                    break;
                }
                case TWO: setsTwo++;
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
        if (tayBreak && (setsTwo==7 || setsOne==7)){
            return true;
        }
        return false;
    }

    public Boolean getEndMatch() {
        return endMatch;
    }
}
