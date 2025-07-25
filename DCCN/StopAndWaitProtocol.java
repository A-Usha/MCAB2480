//stop and wait
import java.util.Random;

public class StopAndWaitProtocol {
    private static final int MAX_FRAMES = 10;
    private static final Random random = new Random();

    public static void main(String[] args) {
        int frameCount = 0;

        while (frameCount < MAX_FRAMES) {
            System.out.println("Sending frame " + (frameCount + 1));

            boolean ackReceived = sendFrame(frameCount);

            if (ackReceived) {
                frameCount++;
            } else {
                System.out.println("No acknowledgment received. Resending frame " + (frameCount + 1));
            }
        }

        System.out.println("All frames sent successfully.");
    }

    private static boolean sendFrame(int frameNumber) {
        return random.nextBoolean(); // Randomly return true or false
    }
}

