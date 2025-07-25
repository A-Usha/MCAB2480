import java.util.Random;

public class GoBackN{
    static final int TOTAL_PACKETS = 10;   
    static final int WINDOW_SIZE = 4;      

    public static void main(String[] args) {
        int base = 0;  
        Random random = new Random();  

        while (base < TOTAL_PACKETS) {
            int end = Math.min(base + WINDOW_SIZE, TOTAL_PACKETS);

            
            for (int i = base; i < end; i++) {
                System.out.println("Sending packet:" + i);
            }

           
            int lostPacket = random.nextInt(WINDOW_SIZE);  
            
           
            boolean timeoutOccurred = random.nextBoolean();
            
            if (timeoutOccurred) {
               
                System.out.println("Timeout occurred. Resending from packet:" + (base + lostPacket));
                base = base + lostPacket; 
            } else {
               
                base = end;  
            }

            
            try {
                Thread.sleep(500);  
            } catch (InterruptedException ignored) {}
        }

       
        System.out.println("All packets sent and acknowledged successfully.");
    }
}
