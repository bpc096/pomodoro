package time;

public class Time {

private final int totalTimeInSeconds;
	
	public Time(int minutes) {
		this(minutes, 0);
	}

	public Time(int minutes, int seconds) {
		this.totalTimeInSeconds = minutes * 60 + seconds;
	}

    public static Time seconds(int seconds) {
        return new Time(0, seconds);
    }

    public static Time minutes(int minutes) {
        return new Time(minutes, 0);
    }

	public boolean isZero() {
		return totalTimeInSeconds == 0;
	}

	public Time minusOneSecond() {
		return new Time(0, totalTimeInSeconds - 1);
	}

	public int minutes() {
		return (int) Math.floor((double) totalTimeInSeconds / 60.0);
	}

	public int seconds() {
		return totalTimeInSeconds % 60;
	}

	public String shortestString() {
		return String.valueOf(minutes() > 0 ? minutes() : seconds());
	}

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Time))
            return false;

        Time anotherTime = (Time) obj;
        return totalTimeInSeconds == anotherTime.totalTimeInSeconds;
    }

    @Override
	public String toString() {
		int minutes = minutes();
		int secs = seconds();
		return (minutes < 10 ? "0" : "") + minutes + ":"
				+ (secs < 10 ? "0" : "") + secs;
	}

}
