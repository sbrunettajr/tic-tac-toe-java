package br.com.sbrunettajr.tictactoe;

public class Player {

    private String nickname;
    private String option;

    public Player() {}

    public Player(String nickname, String option) {
        super();
        this.nickname = nickname;
        this.option = option;
    }

    public String getNickname() {
        return nickname;
    }

    public String getOption() {
        return option;
    }

}
