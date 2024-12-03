class BMSCollegeThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); 
            }
        } catch (InterruptedException e) {
            System.err.println("BMSCollegeThread interrupted.");
        }
    }
}

class CSEThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.err.println("CSEThread interrupted.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BMSCollegeThread bmsThread = new BMSCollegeThread();
        CSEThread cseThread = new CSEThread();

        bmsThread.start(); 
        cseThread.start(); 
    }
}
