package model;

public class VillaHouseStandard {
    private String villaHouseStandardId;
    private String villaHouseStandardName;

    public VillaHouseStandard(String villaHouseStandardId, String VillaHouseStandardName) {
        this.villaHouseStandardId = villaHouseStandardId;
        this.villaHouseStandardName = VillaHouseStandardName;
    }

    public String getVillaHouseStandardId() {
        return villaHouseStandardId;
    }

    public void setVillaHouseStandardId(String villaHouseStandardId) {
        this.villaHouseStandardId = villaHouseStandardId;
    }

    public String getVillaHouseStandardName() {
        return villaHouseStandardName;
    }

    public void setVillaHouseStandardName(String villaHouseStandardName) {
        this.villaHouseStandardName = villaHouseStandardName;
    }
}