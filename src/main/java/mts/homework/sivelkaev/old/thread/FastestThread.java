package mts.homework.sivelkaev.old.thread;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FastestThread {
    private int threadId;
    private long threadTime;

    public FastestThread() {
        this.threadId = -1;
        this.threadTime = Long.MAX_VALUE;
    }
}
