package team;

import java.util.Random;

public class Team {

    private final String name;
    private final TeamMate[] teamMates;

    public Team() {
        this.name = "Team#" + new Random().nextInt(1000);
        this.teamMates = new TeamMate[4];
        for (int i = 0; i < 4; i++) {
            this.teamMates[i] = new TeamMate("mate#" + new Random().nextInt(10));
        }
    }

    public Team(String name) {
        this.name = name;
        this.teamMates = new TeamMate[4];
        for (int i = 0; i < 4; i++) {
            this.teamMates[i] = new TeamMate("mate#" + new Random().nextInt(10));
        }
    }

    public Team(String name, String... teamMates) {
        this.name = name;
        this.teamMates = new TeamMate[teamMates.length];
        if (teamMates.length > 0) {
            for (int i = 0; i < teamMates.length; i++) {
                this.teamMates[i] = new TeamMate(teamMates[i]);
            }
        }
    }

    public void showResults(){
        StringBuilder sb = new StringBuilder();

        for (TeamMate mate: teamMates) {
            sb.append(mate.toString() + "\n");
        }
        System.out.println( sb.toString());
    }

    public TeamMate[] getTeamMates() {
        return teamMates;
    }

    public class TeamMate{

        private final String name;
        private boolean result;
        private final int difficulty;

        public TeamMate(String name) {
            this.name = name;
            this.result = false;
            this.difficulty = new Random().nextInt(10);
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public String toString(){
            return String.format("Имя: %s, результат %s", this.name, this.result);
        }

        public int getDifficulty() {
            return difficulty;
        }
    }
}
