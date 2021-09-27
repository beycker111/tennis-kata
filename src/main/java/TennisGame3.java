
public class TennisGame3 implements TennisGame {

    private int player2Points;
    private int player1Points;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        String scoreCaseOne = getScoreCaseOne();
        String scoreCaseTwo = getScoreCaseTwo(scoreCaseOne);

        String score = player2Points < player1Points ? player1Name : player2Name;

        if (scoreCaseTwo != null){
            return scoreCaseTwo;
        }

        return getAdvantageOrWin(score);
    }

    private String getAdvantageOrWin(String score) {

        return (Math.pow((player1Points - player2Points) ,2) == 1 ? "Advantage " + score : "Win for " + score);
    }

    private String getFinalMessage(String score, String[] listMessages) {

        if(player1Points == player2Points){
            return score + "-" + "All";
        }
        return score + "-" + listMessages[player2Points];
    }

    private String getScoreCaseOne() {

        if (getScoreWhenPointsMoreThanFour()) {
            String[] arrayScoreMessages = {"Love", "Fifteen", "Thirty", "Forty"};
            String score = arrayScoreMessages[player1Points];
            return getFinalMessage(score, arrayScoreMessages);
        }
        return null;
    }

    private String getScoreCaseTwo(String score) {
        if (score != null) return score;
        if (this.player1Points == this.player2Points)
            return "Deuce";
        return null;
    }

    public void setPoints(String playerName) {
        if (playerName.equals(this.player1Name))
            this.player1Points += 1;
        else
            this.player2Points += 1;
        
    }

    private boolean getScoreWhenPointsMoreThanFour() {
        return (player1Points < 4 && player2Points < 4 && (player1Points + player2Points != 6));
    }

}
