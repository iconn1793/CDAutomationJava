package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

public class TestNotifier extends RunNotifier {
	private final List<RunListener> listeners = new CopyOnWriteArrayList<RunListener>();
    private volatile boolean pleaseStop = false;
    
    private abstract class SafeNotifier {
        private final List<RunListener> currentListeners;

        SafeNotifier() {
            this(listeners);
        }

        SafeNotifier(List<RunListener> currentListeners) {
            this.currentListeners = currentListeners;
        }

        void run() {
            int capacity = currentListeners.size();
            List<RunListener> safeListeners = new ArrayList<RunListener>(capacity);
            List<Failure> failures = new ArrayList<Failure>(capacity);
            for (RunListener listener : currentListeners) {
                try {
                    notifyListener(listener);
                    safeListeners.add(listener);
                } catch (Exception e) {
                    failures.add(new Failure(Description.TEST_MECHANISM, e));
                }
            }
        }

        abstract protected void notifyListener(RunListener each) throws Exception;
    }
    
    public void fireTestStarted(final Description description) throws StoppedByUserException {
        new SafeNotifier() {
            @Override
            protected void notifyListener(RunListener each) throws Exception {
                each.testStarted(description);
            }
        }.run();
    }
    
	public void pleaseStop() {
		pleaseStop = true;
		System.out.println("Stopping");
	}
	
	public static void stop() {
		TestNotifier myNotifier = new TestNotifier();
		RunNotifier runNotifier = myNotifier;
		runNotifier.pleaseStop();
		
	}
}
