package com.threads;

import java.util.concurrent.Semaphore;

public class AlternateEx {

	public static void main(String[] args) {
		
		Semaphore in = new Semaphore(1);
		Semaphore out = new Semaphore(0);
		
		ThreadPrinter tp1 = new ThreadPrinter(1, in, out);
		ThreadPrinter tp2 = new ThreadPrinter(2, out, in);
		
		tp1.start();
		tp2.start();
	}

}


class ThreadPrinter extends Thread {
	
	int counter;
    Semaphore ins, outs;

    ThreadPrinter(int counter, Semaphore ins, Semaphore outs) {
        this.counter = counter;
        this.ins = ins;
        this.outs = outs;
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
				ins.acquire();
				
				System.out.println("" + counter);
	            outs.release();  // allow another thread to run
	            counter += 2;
	            Thread.sleep(1000);
	            
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // wait for permission to run
            
        }
    }
}