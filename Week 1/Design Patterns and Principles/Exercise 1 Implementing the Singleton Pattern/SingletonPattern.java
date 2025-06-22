public class SingletonPattern {
    static class Logger {
        private static volatile Logger instance;

        private Logger() {
            System.out.println("Logger instance created.");
        }

        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
        
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances detected! Singleton failed.");
        }
        
        Thread thread1 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Log from thread: " + Thread.currentThread().getName());
        }, "Thread-1");
        
        Thread thread2 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Log from thread: " + Thread.currentThread().getName());
        }, "Thread-2");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}