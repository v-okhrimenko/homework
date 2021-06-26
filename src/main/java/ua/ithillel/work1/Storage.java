package ua.ithillel.work1;

public class Storage {
    private int storageCounter;
    private boolean hasChange = true;

    public boolean isHasChange() {
        return hasChange;
    }

    public void setHasChange(boolean hasChange) {
        this.hasChange = hasChange;
    }

    public int getStorageCounter() {
        return storageCounter;
    }

    public void setStorageCounter(int storageCounter) {
        this.storageCounter = storageCounter;
    }

}
