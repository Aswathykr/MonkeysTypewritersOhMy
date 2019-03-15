package io.zipcoder;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    private boolean stop = false;

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (hasNextString()) {
            String str = getNextString();
            if(str != null)
                copy(str);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized void copy(String str){
        copied += str ;
    }
}
