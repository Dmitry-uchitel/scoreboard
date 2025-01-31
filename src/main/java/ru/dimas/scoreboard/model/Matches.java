package ru.dimas.scoreboard.model;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Matches {
    private static Map<Integer, MatchScore> matchScoreMap = null;
    private static Integer UUID = 0;
    private static Integer selectedUUID=1;


    public static Map<Integer, MatchScore> getMatchScoreMap(){
        if (matchScoreMap==null){
            matchScoreMap = new HashMap<>();
        }
        return matchScoreMap;
    }

    private static Integer generateUUID(){
        for (int i = 1; i <= UUID; i++) {
            if (!getMatchScoreMap().containsKey(i)){
                return i;
            }
        }
        return ++UUID;
    }

    public static Integer addNewMatch(MatchScore matchScore){
        Integer ID = generateUUID();
        getMatchScoreMap().put(ID, matchScore);
        setSelectedUUID(ID);
        return ID;
    }

    public static Integer getSelectedUUID() {
        return selectedUUID;
    }

    public static void setSelectedUUID(Integer selectedUUID) {
        Matches.selectedUUID = selectedUUID;
    }


    public static void deleteCurrentMatch(){
        matchScoreMap.remove(selectedUUID);
    }

}
