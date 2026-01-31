class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // players[i] = strength required by ith player
        // trainers[j] = capacity of jth trainer

        int n = players.length; // number of players
        int m = trainers.length; // number of trainers

        int i = 0; // pointer for players
        int j = 0; // pointer for trainers

        // Sort both arrays so we try to match weakest player with smallest possible trainer
        Arrays.sort(players);
        Arrays.sort(trainers);

        // Try to match players with trainers
        while (i < n && j < m) {

            // If current trainer can handle current player
            if (players[i] <= trainers[j]) {
                // Player i gets matched with trainer j
                i++; // move to next player
            }

            // Move to next trainer (used or not strong enough)
            j++;
        }

        // i represents total matched player-trainer pairs
        return i;
    }
}
