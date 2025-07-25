import java.util.*;
import java.util.concurrent.*;

public class SlidingWindowProtocol {

    // Constants
    private static final int WINDOW_SIZE = 4;  // Sliding window size
    private static final int TIMEOUT = 5000;   // Timeout in milliseconds

    // Sender variables
    private static int seqNum = 0;             // Sequence number for the sender
    private static int ackNum = 0;             // Acknowledgment number for the sender
    private static Queue<Packet> sendWindow = new LinkedList<>();  // Sender's sliding window
    private static Map<Integer, Packet> sentPackets = new HashMap<>();  // Map to track sent packets
    private static Timer timer = new Timer();  // Timer for retransmission

    // Receiver variables
    private static int expectedSeqNum = 0;    // Expected sequence number for the receiver

    public static void main(String[] args) {
        SlidingWindowProtocol protocol = new SlidingWindowProtocol();
        protocol.run();
    }

    public void run() {
        // Simulate packets to send (10 packets in this case)
        for (int i = 0; i < 10; i++) {
            sendWindow.add(new Packet(seqNum++, false));  // Add packets to sender's window
        }

        // Start sender and receiver simulation
        Thread senderThread = new Thread(this::runSender);
        Thread receiverThread = new Thread(this::runReceiver);
        
        senderThread.start();
        receiverThread.start();
    }

    // Sender Logic
    public void runSender() {
        while (!sendWindow.isEmpty()) {
            for (Packet packet : sendWindow) {
                if (!packet.isAckReceived()) {
                    sendPacket(packet);
                }
            }

            // Timeout handling (Resend unacknowledged packets)
            startTimer();

            // Simulate receiving an acknowledgment (for demonstration)
            try {
                Thread.sleep(2000);  // Simulate waiting for an Ack
                handleAck(ackNum++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sender: Transmission complete.");
    }

    // Receiver Logic
    public void runReceiver() {
        // Simulate receiving packets
        for (int i = 0; i < 10; i++) {
            Packet packet = new Packet(i);
            receivePacket(packet);
        }
        System.out.println("Receiver: All packets processed.");
    }

    // Send a packet
    private void sendPacket(Packet packet) {
        System.out.println("Sender: Sending packet with seqNum " + packet.getSeqNum());
        sentPackets.put(packet.getSeqNum(), packet);  // Track sent packets
        // In a real scenario, we would send the packet over the network.
    }

    // Handle acknowledgment
    private void handleAck(int ack) {
        System.out.println("Sender: Received Ack for seqNum " + ack);
        // Move the window forward by acknowledging the received packet
        sendWindow.removeIf(packet -> packet.getSeqNum() == ack);  // Remove acknowledged packet
    }

    // Start the retransmission timer
    private void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resendUnacknowledgedPackets();
            }
        }, TIMEOUT);
    }

    // Resend unacknowledged packets
    private void resendUnacknowledgedPackets() {
        System.out.println("Sender: Resending unacknowledged packets.");
        for (Packet packet : sendWindow) {
            if (!packet.isAckReceived()) {
                sendPacket(packet);  // Resend the unacknowledged packet
            }
        }
    }

    // Receiver: Process received packet
    private void receivePacket(Packet packet) {
        System.out.println("Receiver: Received packet with seqNum " + packet.getSeqNum());

        if (packet.getSeqNum() == expectedSeqNum) {
            // Valid packet, in-order
            System.out.println("Receiver: Acknowledging packet " + packet.getSeqNum());
            sendAck(packet.getSeqNum());
            expectedSeqNum++;  // Move the window forward
        } else if (packet.getSeqNum() < expectedSeqNum) {
            // Duplicate packet, acknowledge the last in-order packet received
            System.out.println("Receiver: Duplicate packet " + packet.getSeqNum());
            sendAck(expectedSeqNum - 1);
        } else {
            // Out-of-order packet, discard it
            System.out.println("Receiver: Out-of-order packet " + packet.getSeqNum() + " discarded.");
        }
    }

    // Send acknowledgment for the received packet
    private void sendAck(int ack) {
        System.out.println("Receiver: Sending Ack for seqNum " + ack);
        // In a real scenario, the acknowledgment would be sent back to the sender.
    }

    // Packet class (represents a data packet)
    private static class Packet {
        private final int seqNum;
        private boolean ackReceived;

        public Packet(int seqNum) {
            this.seqNum = seqNum;
            this.ackReceived = false;
        }

        public int getSeqNum() {
            return seqNum;
        }

        public boolean isAckReceived() {
            return ackReceived;
        }

        public void setAckReceived(boolean ackReceived) {
            this.ackReceived = ackReceived;
        }
    }
}
