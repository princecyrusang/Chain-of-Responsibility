public class WasteManagementSystem {

    public static void main(String[] args) {

        WasteCollector organicCollector = new OrganicWasteCollector();
        WasteCollector recyclableCollector = new RecyclableWasteCollector();
        WasteCollector hazardousCollector = new HazardousWasteCollector();


        organicCollector.setNextCollector(recyclableCollector);
        recyclableCollector.setNextCollector(hazardousCollector);

        System.out.println("=== Automated Waste Management System Demo ===\n");

        WasteContainer organicBin = new WasteContainer(WasteType.ORGANIC, 100);
        WasteContainer recyclableBin = new WasteContainer(WasteType.RECYCLABLE, 200);
        WasteContainer hazardousBin = new WasteContainer(WasteType.HAZARDOUS, 50);

        System.out.println("---- Scenario 1: Attempt disposal when NOT FULL ----");

        organicBin.addWaste(40);
        System.out.println("Organic Bin Level: " + organicBin.getCurrentLevel());

        organicCollector.handleRequest(organicBin);  

        System.out.println("\n---- Scenario 2: Fill to FULL and dispose ----");

        organicBin.addWaste(60); 
        System.out.println("Organic Bin Level: " + organicBin.getCurrentLevel());

        organicCollector.handleRequest(organicBin);  

        System.out.println("Organic Bin Level After Disposal: "
                + organicBin.getCurrentLevel());

        System.out.println("\n---- Scenario 3: Recyclable Waste ----");

        recyclableBin.addWaste(200);
        organicCollector.handleRequest(recyclableBin); 

        System.out.println("\n---- Scenario 4: Hazardous Waste ----");

        hazardousBin.addWaste(50);
        organicCollector.handleRequest(hazardousBin); 

        System.out.println("\n---- Scenario 5: Invalid Waste Addition ----");

        try {
            organicBin.addWaste(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n---- Scenario 6: Partial Recyclable Bin ----");

        recyclableBin.addWaste(50);
        organicCollector.handleRequest(recyclableBin); 

        System.out.println("\n=== Demo Completed ===");
    }
}