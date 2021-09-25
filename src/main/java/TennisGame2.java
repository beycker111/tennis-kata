import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String playerOneName, String playerTwoName) {
        this.player1Name = playerOneName;
        this.player2Name = playerTwoName;
    }

    public String getScore(){

        StringBuilder stringBuilder = new StringBuilder();

        if (isTie()){
            stringBuilder.append(equalScores());
        }else if(playerFourPointsMore()){
            int scoreDifference = playerOnePoints - playerTwoPoints;
            stringBuilder.append(getAdeventage(scoreDifference));
        }else {
            stringBuilder.append(getScore(playerOnePoints)).append("-").append(getScore(playerTwoPoints));
        }

        return stringBuilder.toString();
    }

    public void setPoints(String player) {
        if(player.equals(this.player1Name)){
            playerOnePoints++;
        }
        if(player.equals(this.player2Name)){
            playerTwoPoints++;
        }
    }

    public String equalScores() {
        List<String> scores = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return scores.get(playerOnePoints);
    }

    public String getScore(int scorePlayer){
        List<String> scores = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return scores.get(scorePlayer);
    }

    public String getAdeventage(int scoreDifference){
        switch (scoreDifference){
            case 1:
                return "Advantage ".concat(player1Name);
            case -1:
                return "Advantage ".concat(player2Name);
            default:
                return (scoreDifference >= 2)? "Win for ".concat(player1Name) : "Win for ".concat(player2Name);
        }
    }

    public boolean playerFourPointsMore(){
        return playerOnePoints >= 4 || playerTwoPoints >= 4;
    }

    public boolean isTie(){
        return playerOnePoints == playerTwoPoints;
    }
}