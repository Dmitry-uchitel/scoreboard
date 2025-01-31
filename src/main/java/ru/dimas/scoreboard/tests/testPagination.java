package ru.dimas.scoreboard.tests;

import ru.dimas.scoreboard.model.MatchResult;
import ru.dimas.scoreboard.model.Player;
import ru.dimas.scoreboard.service.Pagination;

import java.util.ArrayList;
import java.util.List;

public class testPagination {
    public static void main(String[] args) {
        List<MatchResult> integerList = new ArrayList<>();
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));
        integerList.add(new MatchResult(new Player("dimas"), new Player("max"), new Player("dimas")));



        Pagination.getMatchResultFiltr(integerList);
        System.out.println("tek: "+Pagination.getCurrentPage()+" k-vo stranic:  "+Pagination.getNumberOfPages()+"  str-1:  "+Pagination.getCurrentPageMinus1()+"  str+1: "+Pagination.getCurrentPagePlus1());
        System.out.println(Pagination.getStartNumber()+"   "+ Pagination.getEndNumber());

        Pagination.setCurrentPage(2);
        System.out.println("tek: "+Pagination.getCurrentPage()+" k-vo stranic:  "+Pagination.getNumberOfPages()+"  str-1:  "+Pagination.getCurrentPageMinus1()+"  str+1: "+Pagination.getCurrentPagePlus1());
        System.out.println(Pagination.getStartNumber()+"   "+ Pagination.getEndNumber());
    }

}
