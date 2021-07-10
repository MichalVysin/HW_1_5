package com.company;

public class StateTaxRate {

    private String abbreviation;
    private String stateName;
    private Float standardTaxRate;
    private Float reducedTaxRate;
    private Boolean specialTaxRate;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Float getStandardTaxRate() {
        return standardTaxRate;
    }

    public void setStandardTaxRate(Float standardTaxRate) {
        this.standardTaxRate = standardTaxRate;
    }

    public Float getReducedTaxRate() {
        return reducedTaxRate;
    }

    public void setReducedTaxRate(Float reducedTaxRate) {
        this.reducedTaxRate = reducedTaxRate;
    }

    public Boolean getSpecialTaxRate() {
        return specialTaxRate;
    }

    public void setSpecialTaxRate(Boolean specialTaxRate) {
        this.specialTaxRate = specialTaxRate;
    }
}
