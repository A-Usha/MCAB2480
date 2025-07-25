import java.util.*;

public class SelectiveRepeatProtocol {

    private static final int WINDOW_SIZE = 4;      // Sliding window size
    private static final int TIMEOUT = 3000;       // Timeout in milliseconds
    private static final int TOTAL_PACKETS = 10;   // Total number of packets to send

    private static int base = 0;                   // Base of the sender window
    private static int nextSeqNum = 0;             // Next sequence number to send
    private static boolean[] ackReceived = new boolean[TOTAL_PACKETS]; // Track ACKs
    private static Timer timer = new Timer();      // Timer for retransmissions
    private static final Object lock = new Object(); // Lock for thread safety

    public static void main(String[] args) {
        // Start sender and receiver threads
        new Thread(SelectiveRepeatProtocol::sender).start();
        new Thread(SelectiveRepeatProtocol::receiver).start();
    }

    // Sender Logic
    private static void sender() {
        while (base < TOTAL_PACKETS) {
            synchronized (lock) {
                if (nextSeqNum < base + WINDOW_SIZE && nextSeqNum < TOTAL_PACKETS) {
                    sendPacket(nextSeqNum);
                    nextSeqNum++;
                }
            }
            sleep(500); // Simulate waiting before sending next packet
        }

        // Wait until all ACKs are received
        while (!allAcksReceived()) {
            sleep(500);
        }

        System.out.println("Sender: All packets acknowledged.");
    }

    // Receiver Logic
    private static void receiver() {
        // Simulate receiving packets
        for (int i = 0; i < TOTAL_PACKETS; i++) {
            sleep(1000); // Simulate network delay
            receivePacket(i);
        }
        System.out.println("Receiver: All packets processed.");
    }

    // Send a packet
    private static void sendPacket(int seqNum) {
        System.out.println("Sender: Sending packet with seqNum " + seqNum);
        startTimer(seqNum); // Start the timer for this packet
    }

    // Receive a packet (simulated)
    private static void receivePacket(int seqNum) {
        System.out.println("Receiver: Received packet with seqNum " + seqNum);
        sendAck(seqNum); // Send ACK for the received packet
    }

    // Send acknowledgment for the received packet
    private static void sendAck(int seqNum) {
        System.out.println("Receiver: Sending ACK for seqNum " + seqNum);

        synchronized (lock) {
            ackReceived[seqNum] = true; // Mark ACK as received

            // Slide the window
            while (base < TOTAL_PACKETS && ackReceived[base]) {
                base++;
            }

            // Cancel the timer for the acknowledged packet
            cancelTimer(seqNum);
        }
    }

    // Start the timer for retransmission
    private static void startTimer(int seqNum) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (lock) {
                    if (!ackReceived[seqNum]) {
                        System.out.println("Sender: Timeout! Resending packet with seqNum " + seqNum);
                        sendPacket(seqNum);
                    }
                }
            }
        }, TIMEOUT);
    }

    // Cancel the timer when ACK is received
    private static void cancelTimer(int seqNum) {
        timer.cancel();
        timer = new Timer(); // Create a new timer for the next timeout
    }

    // Check if all ACKs are received
    private static boolean allAcksReceived() {
        for (boolean ack : ackReceived) {
            if (!ack) return false;
        }
        return true;
    }

    // Simple sleep method
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


