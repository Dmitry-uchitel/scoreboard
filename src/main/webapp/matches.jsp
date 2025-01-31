<%@ page import="ru.dimas.scoreboard.hibernate.HibernateMatchResult" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.dimas.scoreboard.model.MatchResult" %>
<%@ page import="ru.dimas.scoreboard.service.Pagination" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard | Finished Matches</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">

    <script src="js/app.js"></script>
</head>

<body>
<header class="header">
    <section class="nav-header">
        <div class="brand">
            <div class="nav-toggle">
                <img src="images/menu.png" alt="Logo" class="logo">
            </div>
            <span class="logo-text">TennisScoreboard</span>
        </div>
        <div>
            <nav class="nav-links">
                <a class="nav-link" href="/">Home</a>
                <a class="nav-link" href="/matches">Matches</a>
            </nav>
        </div>
    </section>
</header>
<main>

    <div class="container">
        <h1>Matches</h1>
<%--        <div class="input-container">--%>
<%--            <input class="input-filter" placeholder="Filter by name" type="text" />--%>
<%--            <div>--%>
<%--                <a href="/matchesServlet">--%>
<%--                    <button class="btn-filter">Reset Filter</button>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </div>--%>
        <form action="/matchesServlet" method="get">
            <div>
                <label for="playerName">Find player games</label>
                <input name="playerName" id="playerName" value="Enter player name" />
                <button>Find</button>
            </div>
        </form>

        <%
            List<MatchResult> matchResultList= HibernateMatchResult.getMatchResultList();
            Pagination.getMatchResultFiltr(matchResultList);
        %>
        <table class="table-matches">
            <tr>
                <th>Player One</th>
                <th>Player Two</th>
                <th>Winner</th>
            </tr>
            <%
                if (matchResultList != null) { // Проверяем на null
                    for (int i = Pagination.getStartNumber(); i < Pagination.getEndNumber(); i++) {
                        MatchResult matchResult = matchResultList.get(i);
                        if (matchResult != null) { // Проверяем каждый элемент на null
                            String playerOneName = matchResult.getPlayerOne() != null ? matchResult.getPlayerOne().getName() : "Unknown";
                            String playerTwoName = matchResult.getPlayerTwo() != null ? matchResult.getPlayerTwo().getName() : "Unknown";
                            String winnerName = matchResult.getPlayerWin() != null ? matchResult.getPlayerWin().getName() : "No Winner";
            %>
            <tr>
                <td><%= playerOneName %></td>
                <td><%= playerTwoName %></td>
                <td><span class="winner-name-td">"<%= winnerName %>"</span></td>
            </tr>
            <%
                    }
                }
            } else {
            %>
            <tr>
                <td colspan="3">No match results available.</td>
            </tr>
            <%
                }
            %>
        </table>

        <form action="/matchesPageServlet" method="get">
            <div>
                <label for="page"><%=Pagination.getCurrentPage()%></label>
                <input name="page" id="page" value="<%=Pagination.getCurrentPage()%>" />
                <button>Find</button>
            </div>
        </form>
        <div class="pagination">
            <%if (Pagination.getCurrentPageMinus1()!=null){ %>
            <a class="num-page" href="#"><%=Pagination.getCurrentPageMinus1()%></a>
            <%}%>
            <a class="num-page current" href="#"><%=Pagination.getCurrentPage()%></a>
            <%if (Pagination.getCurrentPagePlus1()!=null){ %>
            <a class="num-page" href="#"><%=Pagination.getCurrentPagePlus1()%></a>
            <%}%>
        </div>
    </div>
</main>
<footer>
    <div class="footer">
        <p>&copy; Tennis Scoreboard, project from <a href="https://zhukovsd.github.io/java-backend-learning-course/">zhukovsd/java-backend-learning-course</a>
            roadmap.</p>
    </div>
</footer>
</body>
</html>
