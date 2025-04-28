package org.example.creationaldesignpattern;

//This can be used where you have to create an object with multiple attributes.
// Some may be optional and some may required.
public class BuilderDesignPattern {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.VehicleBuilder("XYZ", "CH1234").build();
        System.out.println(vehicle);
        Vehicle vehicle1 = new Vehicle.VehicleBuilder("ATOM", "765FXS") //required fields
                .launchYear("2025")
                .manufacturer("Maruti")
                .manufacturerId("PUNK1987")
                .model("Ertiga")
                .build();
        System.out.println(vehicle1);
    }
}

class Vehicle {
    private final String model;
    private final String launchYear;
    private final String number;
    private final String manufacturer;
    private final String manufacturerId;
    private final String engineNo;
    private final String chasisNo;

    //enfore client to use builder rather than directly instantiating.
    private Vehicle(String model, String launchYear, String number, String manufacturer, String manufacturerId, String engineNo, String chasisNo) {
        this.model = model;
        this.launchYear = launchYear;
        this.number = number;
        this.manufacturer = manufacturer;
        this.manufacturerId = manufacturerId;
        this.engineNo = engineNo;
        this.chasisNo = chasisNo;
    }

    public String getModel() {
        return model;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public String getNumber() {
        return number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public String getChasisNo() {
        return chasisNo;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", launchYear='" + launchYear + '\'' +
                ", number='" + number + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", manufacturerId='" + manufacturerId + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", chasisNo='" + chasisNo + '\'' +
                '}';
    }

    static class VehicleBuilder {
        private String model;
        private String launchYear;
        private String number;
        private String manufacturer;
        private String manufacturerId;
        private final String engineNo;
        private final String chasisNo;

        public VehicleBuilder(String engineNo, String chasisNo) { //required attributes
            this.engineNo = engineNo;
            this.chasisNo = chasisNo;
        }

        public VehicleBuilder model(String model) {
            this.model = model;
            return this;
        }

        public VehicleBuilder launchYear(String launchYear) {
            this.launchYear = launchYear;
            return this;
        }

        public VehicleBuilder number(String number) {
            this.number = number;
            return this;
        }

        public VehicleBuilder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public VehicleBuilder manufacturerId(String manufacturerId) {
            this.manufacturerId = manufacturerId;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(model, launchYear, number, manufacturer, manufacturerId, engineNo, chasisNo);
        }
    }

}
