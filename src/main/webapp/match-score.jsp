<%@ page import="ru.dimas.scoreboard.hibernate.HibernateMatchResult" %>
<%@ page import="ru.dimas.scoreboard.hibernate.HibernatePlayers" %>
<%@ page import="java.util.Map" %>
<%@ page import="ru.dimas.scoreboard.model.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard | Match Score</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@300&display=swap" rel="stylesheet">
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
    <%Map<Integer, MatchScore> matchScoreMap = Matches.getMatchScoreMap();
    MatchScore matchScore = Matches.getMatchScoreMap().get(Matches.getSelectedUUID());%>
    <div class="container">
        <h1>Current match <%=Matches.getSelectedUUID() %></h1>
        <div class="current-match-image"></div>
        <form action="selectGameServlet" method="post">
            <label for="dropdown">Select unfinished game:</label>
            <select name="dropdown" id="dropdown" onchange="this.form.submit()">
                <%
                    // Перебираем ключи из matchScoreMap
                    for (Integer key : matchScoreMap.keySet()) {
                        // Проверяем, является ли текущий ключ выбранным значением
                        boolean isSelected = (key.equals(Matches.getSelectedUUID())); // Сравниваем ключ с выбранным UUID
                %>
                <option value="<%= key %>" <%= isSelected ? "selected" : "" %>><%= key %></option>
                <%
                    }
                %>
            </select>
<%--            <button type="submit">Go</button>--%>

        </form>
        <section class="score">
            <table class="table">
                <thead class="result">
                <tr>
                    <th class="table-text">Player</th>
                    <th class="table-text">Sets</th>
                    <th class="table-text">Games</th>
                    <th class="table-text">Points</th>
                </tr>
                </thead>
                <tbody>
                <tr class="player1">
                    <td class="table-text"><%= matchScore.getNameOne()%></td>
                    <td class="table-text"><%= matchScore.getSetsOne()%></td>
                    <td class="table-text"><%= matchScore.getGamesOne()%></td>
                    <td class="table-text"><%= matchScore.getPointsOne()%></td>
                    <td class="table-text">
<%--                        <div class="score-btn">Score--%>
                            <form method="post" action="/matchScoreServlet">
                                <input class="score-btn" type="submit" value="playerOne" id="playerOne" name ="playerOne">
                            </form>
<%--                        </div>--%>
                    </td>
                </tr>
                <tr class="player2">
                    <td class="table-text"><%= matchScore.getNameTwo()%></td>
                    <td class="table-text"><%= matchScore.getSetsTwo()%></td>
                    <td class="table-text"><%= matchScore.getGamesTwo()%></td>
                    <td class="table-text"><%= matchScore.getPointsTwo()%></td>
                    <td class="table-text">

<%--                            <div class="score-btn">Score--%>
                                <form method="post" action="/matchScoreServlet">
                                    <input class="score-btn" type="submit" value="playerTwo" id="playerTwo" name ="playerTwo">
                                </form>
<%--                            </div>--%>

                    </td>
                </tr>
                </tbody>
            </table>
        </section>
    </div>
</main>
<footer>
    <div class="footer">
        <p>&copy; Tennis Scoreboard, project from <a href="https://zhukovsd.github.io/java-backend-learning-course/">zhukovsd/java-backend-learning-course</a> roadmap.</p>
    </div>
</footer>
</body>
</html>
