public abstract class WasteCollector {

    protected WasteCollector nextCollector;

    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    public void handleRequest(WasteContainer container) {
        if (canHandle(container)) {
            dispose(container);
        } else if (nextCollector != null) {
            nextCollector.handleRequest(container);
        } else {
            System.out.println("No collector available for waste type: "
                    + container.getType());
        }
    }

    protected abstract boolean canHandle(WasteContainer container);

    protected abstract void dispose(WasteContainer container);
}