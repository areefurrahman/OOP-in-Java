import java.util.Arrays;

class Learner {
    private int learnerId;
    String fullName;
    private int yearsOld;
    private float[] scores;
    private char rating;

    public Learner() {
        learnerId = 0;
        fullName = "----";
        yearsOld = 0;
        scores = new float[3];
        rating = 'F';
    }
    public Learner(int learnerId, String fullName, int yearsOld, float[] scores) {
        this.learnerId = learnerId;
        this.fullName = fullName;
        this.yearsOld = yearsOld;
        this.scores = Arrays.copyOf(scores, scores.length);
        computeRating();
    }

    public Learner(Learner anotherLearner) {
        this.learnerId = anotherLearner.learnerId;
        this.fullName = anotherLearner.fullName;
        this.yearsOld = anotherLearner.yearsOld;
        this.scores = Arrays.copyOf(anotherLearner.scores, anotherLearner.scores.length);
        this.rating = anotherLearner.rating;
    }
    private void computeRating() {
        float sum = 0;
        for (float score : scores) {
            sum += score;
        }
        float average = sum / scores.length;

        if (average >= 90) {
            rating = 'A';
        } else if (average >= 80) {
            rating = 'B';
        } else if (average >= 70) {
            rating = 'C';
        } else if (average >= 60) {
            rating = 'D';
        } else {
            rating = 'F';
        }
    }
    public boolean isSame(Learner anotherLearner) {
        return this.learnerId == anotherLearner.learnerId && this.fullName.equals(anotherLearner.fullName);
    }
    @Override
    public String toString() {
        return "Learner{" +
                "learnerId=" + learnerId +
                ", fullName='" + fullName + '\'' +
                ", yearsOld=" + yearsOld +
                ", scores=" + Arrays.toString(scores) +
                ", rating=" + rating +
                '}';
    }
}
public class LearnerManagementSystem {
    public static void main(String[] args) {

        Learner learner1 = new Learner(201, "Ahmed Khan", 22, new float[]{88, 92, 79});

        System.out.println("Original Learner:");
        System.out.println(learner1);
        Learner learner2 = new Learner(learner1);
        learner2.fullName = "Saad Ali";
        boolean isSame = learner1.isSame(learner2);
        System.out.println("\nCopied Learner:");
        System.out.println(learner2);

        System.out.println("\nAre the two learners identical? " + isSame);
    }
}
