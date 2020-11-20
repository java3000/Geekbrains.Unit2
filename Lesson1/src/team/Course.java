package team;

import java.util.Random;

public class Course {

    private Barrier[] barriers;

    public Course() {
        this.barriers = new Barrier[new Random().nextInt(10)];
        for (int i = 0; i < this.barriers.length; i++) {
            this.barriers[i] = new Barrier();
        }
    }

    public void doIt(Team team){
        for(Team.TeamMate t : team.getTeamMates()){
            for(Barrier b : barriers) {
                if (t.getDifficulty() > b.difficulty) t.setResult(true);
            }
        }
    }


    class  Barrier{
        private int difficulty;

        public Barrier() {
            this.difficulty = new Random().nextInt(10);
        }
    }
}
