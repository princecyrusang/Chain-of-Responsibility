public class RecyclableWasteCollector extends WasteCollector {

    @Override
    protected boolean canHandle(WasteContainer container) {
        return container.getType() == WasteType.RECYCLABLE;
    }

    @Override
    protected void dispose(WasteContainer container) {
        if (!container.isFull()) {
            System.out.println("Recyclable container is not full yet.");
            return;
        }

        System.out.println("Recycling waste materials...");
        container.emptyContainer();
    }
}