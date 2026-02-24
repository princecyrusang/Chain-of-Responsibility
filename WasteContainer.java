public class WasteContainer {

    private final WasteType type;
    private final int capacity;
    private int currentLevel;

    public WasteContainer(WasteType type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.currentLevel = 0;
    }

    public WasteType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void addWaste(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        currentLevel += amount;
        if (currentLevel > capacity) {
            currentLevel = capacity;
        }
    }

    public boolean isFull() {
        return currentLevel >= capacity;
    }

    public void emptyContainer() {
        currentLevel = 0;
    }
}