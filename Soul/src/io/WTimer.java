package io;

public class WTimer {

	private OnTimerListener onTimerListener;
	private long pTime, lastTime, nowTime;
	private boolean isRunning = false;

	private WTimer(OnTimerListener onTimerListener) {
		this.onTimerListener = onTimerListener;
	}

	private WTimer(long pTime, OnTimerListener onTimerListener) {
		this.pTime = pTime;
		this.onTimerListener = onTimerListener;
	}

	public static WTimer createWTimer(long pTime, OnTimerListener onTimerListener) {
		WTimer wTimer = new WTimer(pTime, onTimerListener);
		return wTimer;
	}

	public void start() {
		isRunning = true;
		lastTime = System.currentTimeMillis();
	}

	public void update() {
		if (isRunning) {
			nowTime = System.currentTimeMillis();

			if (nowTime - lastTime >= pTime) {
				if (onTimerListener != null) {
					onTimerListener.onTimerRunning(this);
				}
				lastTime = nowTime;
			}
		}
	}

	public void stop() {
		isRunning = false;
	}

	public interface OnTimerListener {
		void onTimerRunning(WTimer mTimer);
	}
}
