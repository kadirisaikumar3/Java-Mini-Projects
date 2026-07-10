public class Candidate {

    private int candidateId;
    private String candidateName;
    private int votes;

    // Constructor
    public Candidate(int candidateId, String candidateName) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.votes = 0;
    }

    // Getters
    public int getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getVotes() {
        return votes;
    }

    // Increase Vote Count
    public void addVote() {
        votes++;
    }

    @Override
    public String toString() {
        return "Candidate ID   : " + candidateId +
               "\nCandidate Name : " + candidateName +
               "\nVotes          : " + votes;
    }
}