package model;

public class Service {
    private String serviceId;
    private ServiceType serviceType;
    private String serviceName;
    private int useArea;
    private int rentalPrice;
    private int maxPerson;
    private RentalForm rentalForm;
    private VillaHouseStandard villaHouseStandard;
    private String otherConvenientVillaHouse;
    private int pollVillaArea;
    private int numberFloorVillaHouse;
    private String freeServiceRoom;

    public Service(String serviceId, ServiceType serviceType, String serviceName, int useArea, int rentalPrice, int maxPerson, RentalForm rentalForm, VillaHouseStandard villaHouseStandard, String otherConvenientVillaHouse, int pollVillaArea, int numberFloorVillaHouse, String freeServiceRoom) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalPrice = rentalPrice;
        this.maxPerson = maxPerson;
        this.rentalForm = rentalForm;
        this.villaHouseStandard = villaHouseStandard;
        this.otherConvenientVillaHouse = otherConvenientVillaHouse;
        this.pollVillaArea = pollVillaArea;
        this.numberFloorVillaHouse = numberFloorVillaHouse;
        this.freeServiceRoom = freeServiceRoom;
    }

    public Service(String serviceId, ServiceType serviceType, String serviceName, int useArea, int rentalPrice, int maxPerson, RentalForm rentalForm, VillaHouseStandard villaHouseStandard, String otherConvenientVillaHouse, int pollVillaArea, int numberFloorVillaHouse) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalPrice = rentalPrice;
        this.maxPerson = maxPerson;
        this.rentalForm = rentalForm;
        this.villaHouseStandard = villaHouseStandard;
        this.otherConvenientVillaHouse = otherConvenientVillaHouse;
        this.pollVillaArea = pollVillaArea;
        this.numberFloorVillaHouse = numberFloorVillaHouse;
    }

    public Service(String serviceId, ServiceType serviceType, String serviceName, int useArea, int rentalPrice, int maxPerson, RentalForm rentalForm, VillaHouseStandard villaHouseStandard, String otherConvenientVillaHouse, int numberFloorVillaHouse) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalPrice = rentalPrice;
        this.maxPerson = maxPerson;
        this.rentalForm = rentalForm;
        this.villaHouseStandard = villaHouseStandard;
        this.otherConvenientVillaHouse = otherConvenientVillaHouse;
        this.numberFloorVillaHouse = numberFloorVillaHouse;
    }

    public Service(String serviceId, ServiceType serviceType, String serviceName, int useArea, int rentalPrice, int maxPerson, RentalForm rentalForm, String freeServiceRoom) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalPrice = rentalPrice;
        this.maxPerson = maxPerson;
        this.rentalForm = rentalForm;
        this.freeServiceRoom = freeServiceRoom;
    }

    public Service(String serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getUseArea() {
        return useArea;
    }

    public void setUseArea(int useArea) {
        this.useArea = useArea;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public RentalForm getRentalForm() {
        return rentalForm;
    }

    public void setRentalForm(RentalForm rentalForm) {
        this.rentalForm = rentalForm;
    }

    public VillaHouseStandard getVillaHouseStandard() {
        return villaHouseStandard;
    }

    public void setVillaHouseStandard(VillaHouseStandard villaHouseStandard) {
        this.villaHouseStandard = villaHouseStandard;
    }

    public String getOtherConvenientVillaHouse() {
        return otherConvenientVillaHouse;
    }

    public void setOtherConvenientVillaHouse(String otherConvenientVillaHouse) {
        this.otherConvenientVillaHouse = otherConvenientVillaHouse;
    }

    public int getPollVillaArea() {
        return pollVillaArea;
    }

    public void setPollVillaArea(int pollVillaArea) {
        this.pollVillaArea = pollVillaArea;
    }

    public int getNumberFloorVillaHouse() {
        return numberFloorVillaHouse;
    }

    public void setNumberFloorVillaHouse(int numberFloorVillaHouse) {
        this.numberFloorVillaHouse = numberFloorVillaHouse;
    }

    public String getFreeServiceRoom() {
        return freeServiceRoom;
    }

    public void setFreeServiceRoom(String freeServiceRoom) {
        this.freeServiceRoom = freeServiceRoom;
    }
}