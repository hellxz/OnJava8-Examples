package lowlevel;

// lowlevel/ExceptionThread.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ThrowsException}
import java.util.concurrent.*;

public class ExceptionThread implements Runnable {
  @Override public void run() {
    throw new RuntimeException();
  }
  public static void main(String[] args) {
    ExecutorService es =
      Executors.newCachedThreadPool();
    es.execute(new ExceptionThread());
    es.shutdown();
  }
}
/* Output:
___[ Error Output ]___
Exception in thread "pool-1-thread-1"
java.lang.RuntimeException
        at ExceptionThread.run(ExceptionThread.java:7)
        at java.util.concurrent.ThreadPoolExecutor.runW
orker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Work
er.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
*/
