<%@ page import="ru.dimas.scoreboard.hibernate.HibernatePlayers" %>
<%@ page import="ru.dimas.scoreboard.model.MatchScore" %>
<%@ page import="ru.dimas.scoreboard.model.Matches" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard | New Match</title>
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
                <a class="nav-link" href="matches">Matches</a>
            </nav>
        </div>
    </section>
</header>
<main>
    <div class="container">
        <div>
            <h1>Start new match</h1>
            <div class="new-match-image"></div>
            <div class="form-container center">
                <form method="post" action="/NewMatchServlet">
                    <p style="color: black;">Enter the players game</p>
                    <label class="label-player" for="playerOne">Player one</label>
                    <input class="input-player" placeholder="Name" type="text" id="playerOne"
                           name="playerOne" pattern="[A-Za-z]\. [A-Za-z]+" required
                           title="Enter a name in the format n. surname ">
                    <label class="label-player" for="playerTwo">Player two</label>
                    <input class="input-player" placeholder="Name" type="text" id="playerTwo"
                           name="playerTwo" pattern="[A-Za-z]\. [A-Za-z]+" required
                           title="Enter a name in the format n. surname ">
                    <input class="form-button" type="submit" value="Start" >
                </form>
            </div>
        </div>
    </div>
</main>
<footer>
    <div class="footer">
        <p>&copy; Tennis Scoreboard, project from <a href="https://zhukovsd.github.io/java-backend-learning-course/">zhukovsd/java-backend-learning-course</a> roadmap.</p>
    </div>
</footer>
</body>
</html>
