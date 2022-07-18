import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicOperation {

  public static void main(String[] args) {

    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(() -> {
      System.out.println("Hello");
    });
    executor.submit(() -> {
      System.out.println("World");
    });
    executor.shutdown();


    ExecutorService executor2 = Executors.newSingleThreadExecutor();
    executor2.submit(() -> {
      System.out.println("Hello");
    });
    executor2.submit(() -> {
      System.out.println("World");
    });
    executor2.shutdown();

    ExecutorService executor3 = Executors.newScheduledThreadPool(2);
    executor3.submit(() -> {
      System.out.println("Hello");
    });
    executor3.submit(() -> {
      System.out.println("World");
    });
    executor3.shutdown();
    CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {}
      System.out.println("Hello");
      return null;
    });
    CompletableFuture.supplyAsync(() -> {
      System.out.println("World");
      return null;
    });

  }
}
