package ua.ithillel.work2;

public class MySumCount_2 implements Runnable {
    private int startIndex;
    private int stopIndex;
    private int[] myArray;
    private long resultSum;

    public MySumCount_2() {
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public int[] getMyArray() {
        return myArray;
    }

    public void setMyArray(int[] myArray) {
        this.myArray = myArray;
    }

    public long getResultSum() {
        long sum = 0;
        for (int i = getStartIndex(); i <= getStopIndex(); i++) {
            sum += myArray[i];
        }
        return sum;
    }

    @Override
    public void run() {
        if (getStopIndex() > getMyArray().length - 1 || getStartIndex() > getMyArray().length - 1) {
            System.out.println("Index must be between 0...99");
            return;
        }
        if (getStartIndex() > getStopIndex()) {
            int tempIndex = getStartIndex();
            setStartIndex(getStopIndex());
            setStopIndex(tempIndex);
        }
        System.out.println("MySumCount_2 (" + Thread.currentThread().getName() + ") Result: " + getResultSum());
    }
}
