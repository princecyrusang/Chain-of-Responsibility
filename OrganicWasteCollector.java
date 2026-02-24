public class OrganicWasteCollector extends WasteCollector {

    @Override
    protected boolean canHandle(WasteContainer container) {
        return container.getType() == WasteType.ORGANIC;
    }

    @Override
    protected void dispose(WasteContainer container) {
        if (!container.isFull()) {
            System.out.println("Organic container is not full yet.");
            return;
        }

        System.out.println("Disposing organic waste...");
        container.emptyContainer();
    }
}