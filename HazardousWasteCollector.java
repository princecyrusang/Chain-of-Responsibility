public class HazardousWasteCollector extends WasteCollector {

    @Override
    protected boolean canHandle(WasteContainer container) {
        return container.getType() == WasteType.HAZARDOUS;
    }

    @Override
    protected void dispose(WasteContainer container) {
        if (!container.isFull()) {
            System.out.println("Hazardous container is not full yet.");
            return;
        }

        System.out.println("Handling hazardous waste with safety protocols...");
        container.emptyContainer();
    }
}