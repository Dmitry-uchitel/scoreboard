package ru.dimas.scoreboard.service;

import ru.dimas.scoreboard.model.MatchResult;

import java.util.List;

public class Pagination {
    private static Boolean filtration;
    private static Integer numberOfPages=1;
    private static Integer currentPage=1;
    private static Integer currentPageMinus1=null;
    private static Integer currentPagePlus1=null;
    private static List matchResultFiltr;
    private static Integer startNumber=0;
    private static Integer endNumber=4;

    public static Integer getStartNumber() {
        return startNumber;
    }

    public static Integer getEndNumber() {
        return endNumber;
    }

    public static void getMatchResultFiltr(List matchResultListBeforeOutput){
        setNumberOfPages((matchResultListBeforeOutput.size()+4)/5);

        matchResultFiltr=matchResultListBeforeOutput;
        setCurrentPage(1);
    }

    public static Integer getCurrentPageMinus1() {
        return currentPageMinus1;
    }

    public static void setCurrentPageMinus1(Integer currentPageMinus1) {
        Pagination.currentPageMinus1 = currentPageMinus1;
    }

    public static Integer getCurrentPagePlus1() {
        return currentPagePlus1;
    }

    public static void setCurrentPagePlus1(Integer currentPagePlus1) {
        Pagination.currentPagePlus1 = currentPagePlus1;
    }



    public static void setCurrentPage(Integer currentPag) {
        currentPage = currentPag;

        currentPagePlus1=currentPage+1;
        if (currentPagePlus1>numberOfPages){
            currentPagePlus1=null;
        }
        currentPageMinus1=currentPage-1;
        if (currentPageMinus1<1){
            currentPageMinus1=null;
        }

        startNumber=currentPage*5-5;
        endNumber= Math.min(startNumber + 5, matchResultFiltr.size());

    }

    public static Integer getNumberOfPages() {
        return numberOfPages;
    }

    public static void setNumberOfPages(Integer numberOfPag) {
        numberOfPages = numberOfPag;
    }

    public static Integer getCurrentPage() {
        return currentPage;
    }

    public static Boolean getFiltration() {
        return filtration;
    }

    public static void setFiltration(Boolean filtration) {
        filtration = filtration;
    }
}
