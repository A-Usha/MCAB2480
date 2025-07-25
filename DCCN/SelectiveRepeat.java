
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SelectiveRepeat {

    static int WINDOW_SIZE;
    static int TOTAL_PACKETS;
    static long TIMEOUT;
    static double LOSS_PROBABILITY;

    static class Packet {
        int seqNum;
        boolean acknowledged;

        Packet(int seqNum) {
            this.seqNum = seqNum;
            this.acknowledged = false;
        }
    }

    static int sendBase = 0;
    static Packet[] packets;
    static boolean[] sent;
    static Timer[] timers;
    static int[] retryCount; // Track retries for each packet
    static Scanner scanner = new Scanner(System.in); // For reading Enter input

    public static void main(String[] args) {
        // Taking user inputs for the simulation
        System.out.print("Enter window size (number of packets in one frame): ");
        WINDOW_SIZE = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter total number of packets to be sent: ");
        TOTAL_PACKETS = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter timeout value (milliseconds): ");
        TIMEOUT = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter packet loss probability (0.0 to 1.0): ");
        LOSS_PROBABILITY = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Initialize the packets, sent flags, timers, and retryCount
        packets = new Packet[TOTAL_PACKETS];
        sent = new boolean[TOTAL_PACKETS];
        timers = new Timer[TOTAL_PACKETS];
        retryCount = new int[TOTAL_PACKETS]; // Initialize retry counts to 0

        // Initialize packets with sequence numbers
        for (int i = 0; i < TOTAL_PACKETS; i++) {
            packets[i] = new Packet(i);
        }

        // Send packets in frames (group of `WINDOW_SIZE` packets) on Enter press
        while (sendBase < TOTAL_PACKETS) {
            System.out.println("\nPress Enter to send next frame (group of " + WINDOW_SIZE + " packets)...");
            scanner.nextLine(); // Wait for the user to press Enter

            sendPacketsInWindow();
            try {
                TimeUnit.SECONDS.sleep(1); // Simulate some delay between each user action
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All packets sent and acknowledged successfully.");
    }

    static void sendPacketsInWindow() {
        // Send packets in the current window (frame)
        for (int i = sendBase; i < sendBase + WINDOW_SIZE && i < TOTAL_PACKETS; i++) {
            if (!sent[i] && !packets[i].acknowledged) {
                System.out.println("Sending frame " + i);
                simulateReceive(packets[i]);
                startTimer(i);
                sent[i] = true;
            }
        }
    }

    static void startTimer(int seqNum) {
        if (timers[seqNum] != null) {
            timers[seqNum].cancel();
        }

        timers[seqNum] = new Timer();
        int packetNum = seqNum;

        timers[seqNum].schedule(new TimerTask() {
            public void run() {
                if (!packets[packetNum].acknowledged) {
                    retryCount[packetNum]++;
                    System.out.println("Frame " + packetNum + " lost or not acknowledged. Retry count: " + retryCount[packetNum]);
                    System.out.println("Resending frame " + packetNum);
                    resendFrame(packetNum); // Resend the specific packet that timed out
                }
            }
        }, TIMEOUT);
    }

    static void resendFrame(int seqNum) {
        simulateReceive(packets[seqNum]);
        startTimer(seqNum);
    }

    static void simulateReceive(Packet p) {
        int seqNum = p.seqNum;
        if (Math.random() > LOSS_PROBABILITY) {  // Simulate packet loss based on probability
            System.out.println("ACK received for frame " + seqNum);
            sendAck(seqNum);
        } else {
            System.out.println("Frame " + seqNum + " lost (simulated). No ACK sent.");
        }
    }

    static void sendAck(int seqNum) {
        System.out.println("Sending ACK for " + seqNum);
        receiveAck(seqNum);
    }

    static void receiveAck(int ackNum) {
        System.out.println("Received ACK for frame " + ackNum);
        if (ackNum >= sendBase && ackNum < sendBase + WINDOW_SIZE) {
            packets[ackNum].acknowledged = true;
            if (timers[ackNum] != null) {
                timers[ackNum].cancel();
            }

            // Move the window forward
            while (sendBase < TOTAL_PACKETS && packets[sendBase].acknowledged) {
                sendBase++;
            }
        }
    }
}


