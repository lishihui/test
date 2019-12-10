package com.module.domain.registrationManagement.change.change;

public class DxxzspTechplanChangedWithBLOBs extends DxxzspDxxzspTechplanChangedCha {
    private String topologyDiagramFlex;

    private String networkScale;

    private String manaTopology;

    private String techPlan;

    public String getTopologyDiagramFlex() {
        return topologyDiagramFlex;
    }

    public void setTopologyDiagramFlex(String topologyDiagramFlex) {
        this.topologyDiagramFlex = topologyDiagramFlex == null ? null : topologyDiagramFlex.trim();
    }

    public String getNetworkScale() {
        return networkScale;
    }

    public void setNetworkScale(String networkScale) {
        this.networkScale = networkScale == null ? null : networkScale.trim();
    }

    public String getManaTopology() {
        return manaTopology;
    }

    public void setManaTopology(String manaTopology) {
        this.manaTopology = manaTopology == null ? null : manaTopology.trim();
    }

    public String getTechPlan() {
        return techPlan;
    }

    public void setTechPlan(String techPlan) {
        this.techPlan = techPlan == null ? null : techPlan.trim();
    }
}