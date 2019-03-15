package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) throws InterruptedException {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";
        int numberOfThreads[] = {2,5,8};
        int index = 0;
        System.out.println("\n================UNSAFE COPY===========================");
        System.out.println("======================================================");
        while(true) {

            System.out.println("Number of threads : " + numberOfThreads[index]);
            // Do all of the Monkey / Thread building here
            // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
            // A Tale Of Two Cities.
            UnsafeCopier copier = new UnsafeCopier(introduction);
            Thread threads[] = new Thread[numberOfThreads[index]];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(copier);
            }

            for (Thread thread : threads) {
                thread.start();
            }
            // This wait is here because main is still a thread and we want the main method to print the finished copies
            // after enough time has passed.
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("MAIN INTERRUPTED");
            }
            System.out.println("Output for number of threads : " + numberOfThreads[index]);
            System.out.println(copier.copied);
            System.out.println("You lost : " + (introduction.length() - copier.copied.length()) + " chars");
            System.out.println("--------------------------------------------------------" );

            index++;
            if(index == numberOfThreads.length)
                break;
        }
        System.out.println("\n==================SAFE COPY===========================");
        System.out.println("======================================================");

        index = 0;
        while(true) {

            System.out.println("Number of threads : " + numberOfThreads[index]);
            // Do all of the Monkey / Thread building here
            // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
            // A Tale Of Two Cities.
            SafeCopier copier = new SafeCopier(introduction);
            Thread threads[] = new Thread[numberOfThreads[index]];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(copier);
            }

            for (Thread thread : threads) {
                thread.start();
            }
            // This wait is here because main is still a thread and we want the main method to print the finished copies
            // after enough time has passed.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("MAIN INTERRUPTED");
            }
            System.out.println("Output for number of threads : " + numberOfThreads[index]);
            System.out.println(copier.copied);
            System.out.println("You lost : " + (introduction.length() - copier.copied.length()) + " chars");
            System.out.println("--------------------------------------------------------" );

            index++;
            if(index == numberOfThreads.length)
                break;
        }
    }
}