package com.tencent.kunpeng.utest;
import java.util.concurrent.CountDownLatch;  
  
public class TestNativeOutOfMemoryError {  
  
    public static void main(String[] args) {  
  
    	try {
    		for (int i = 0;; i++) {  
                System.out.println("i = " + i);  
                new Thread(new HoldThread()).start();  
            } 
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(1);
		}
         
    }  
  
}  
  
class HoldThread extends Thread {  
    CountDownLatch cdl = new CountDownLatch(1);  
  
    public HoldThread() {  
        this.setDaemon(true);  
    }  
  
    public void run() {  
       
            try {
				cdl.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.exit(1);
			}  
        
    }  
}  