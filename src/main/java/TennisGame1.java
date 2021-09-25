
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void setPoints(String playerName) {
        if (playerName.equals(this.player1Name))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        if (scorePlayer1 ==scorePlayer2)
        {
            score = setScoreWhenScoresEquals();
        }
        else if (scorePlayer1 >=4 || scorePlayer2>=4)
        {
            score = setScoreWhenPlayers4orMore();
        }
        else
        {
            score = getResult(score, 1);
            score = getResult(score, 2);
        }
        return score;
    }

    private String setScoreWhenPlayers4orMore() {
        int minusResult = scorePlayer1 -scorePlayer2;
        switch (minusResult){
            case 1:
                return "Advantage ".concat(this.player1Name);
            case -1:
                return "Advantage ".concat(this.player2Name);
            default:
                return (minusResult>=2 ? "Win for ".concat(this.player1Name) : "Win for ".concat(this.player2Name));
        }
    }

    private String setScoreWhenScoresEquals() {

        switch (scorePlayer1)
        {
            case 0:
                return "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return  "Deuce";

        }
    }

    private String getResult(String score, int i) {
        int tempScore;
        if (i ==1) tempScore = scorePlayer1;
        else { score +="-"; tempScore = scorePlayer2;}
        score = getScore(score, tempScore);
        return score;
    }

    private String getScore(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                return score.concat("Love");
            case 1:
                return score.concat("Fifteen");
            case 2:
                return score.concat("Thirty");
            default:
                return score.concat("Forty");
        }
    }
}
