package com.module.domain.registrationManagement.apply.apply;

public class DxxzspTechnologyImplementationWithBLOBs extends DxxzspTechnologyImplementation {
    private String networkTopologyFlex;

    private String networkScale;

    private String managementTopology;

    private String technicalPlan;

    public String getNetworkTopologyFlex() {
        return networkTopologyFlex;
    }

    public void setNetworkTopologyFlex(String networkTopologyFlex) {
        this.networkTopologyFlex = networkTopologyFlex == null ? null : networkTopologyFlex.trim();
    }

    public String getNetworkScale() {
        return networkScale;
    }

    public void setNetworkScale(String networkScale) {
        this.networkScale = networkScale == null ? null : networkScale.trim();
    }

    public String getManagementTopology() {
        return managementTopology;
    }

    public void setManagementTopology(String managementTopology) {
        this.managementTopology = managementTopology == null ? null : managementTopology.trim();
    }

    public String getTechnicalPlan() {
        return technicalPlan;
    }

    public void setTechnicalPlan(String technicalPlan) {
        this.technicalPlan = technicalPlan == null ? null : technicalPlan.trim();
    }
}