public class Race {
    String leader = "";
    int bestDistance = 0;

    public void updateLeader(Car newRacer) {
        int distance = 24 * newRacer.speed;
        //NOTE: The winner will be the first who passed equivalent distances
        if (distance > this.bestDistance) {
            this.leader = newRacer.name;
            this.bestDistance = distance;
        }
    }
}