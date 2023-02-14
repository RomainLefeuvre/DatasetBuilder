package fr.inria.diverse.tools;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class Executor extends ThreadPoolExecutor {
	public Executor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @NotNull TimeUnit unit,
			@NotNull BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public Executor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @NotNull TimeUnit unit,
			@NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
	}

	public Executor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @NotNull TimeUnit unit,
			@NotNull BlockingQueue<Runnable> workQueue, @NotNull RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}

	public Executor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @NotNull TimeUnit unit,
			@NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory,
			@NotNull RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}

	public Executor(int corePoolSize) {
		super(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
	}

	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if (t == null && r instanceof Future<?>) {
			try {
				Object result = ((Future<?>) r).get();
			} catch (CancellationException ce) {
				t = ce;
			} catch (ExecutionException ee) {
				t = ee.getCause();
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt(); // ignore/reset
			}
		}
		if (t != null)
			System.out.println(t);
	}
}