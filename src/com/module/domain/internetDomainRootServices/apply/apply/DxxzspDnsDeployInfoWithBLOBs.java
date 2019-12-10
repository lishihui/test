package com.module.domain.internetDomainRootServices.apply.apply;

public class DxxzspDnsDeployInfoWithBLOBs extends DxxzspDnsDeployInfo {
    private String rootServerFlex;

    private String submitFlex;

    private String rootServerInfo;

    private String dnsTopology;

    private String dataTransTopology;

    private String rootManagerTopology;

    private String accessBroadband;

    private String ipaddressSegment;

    private String backupLink;

    public String getRootServerFlex() {
        return rootServerFlex;
    }

    public void setRootServerFlex(String rootServerFlex) {
        this.rootServerFlex = rootServerFlex == null ? null : rootServerFlex.trim();
    }

    public String getSubmitFlex() {
        return submitFlex;
    }

    public void setSubmitFlex(String submitFlex) {
        this.submitFlex = submitFlex == null ? null : submitFlex.trim();
    }

    public String getRootServerInfo() {
        return rootServerInfo;
    }

    public void setRootServerInfo(String rootServerInfo) {
        this.rootServerInfo = rootServerInfo == null ? null : rootServerInfo.trim();
    }

    public String getDnsTopology() {
        return dnsTopology;
    }

    public void setDnsTopology(String dnsTopology) {
        this.dnsTopology = dnsTopology == null ? null : dnsTopology.trim();
    }

    public String getDataTransTopology() {
        return dataTransTopology;
    }

    public void setDataTransTopology(String dataTransTopology) {
        this.dataTransTopology = dataTransTopology == null ? null : dataTransTopology.trim();
    }

    public String getRootManagerTopology() {
        return rootManagerTopology;
    }

    public void setRootManagerTopology(String rootManagerTopology) {
        this.rootManagerTopology = rootManagerTopology == null ? null : rootManagerTopology.trim();
    }

    public String getAccessBroadband() {
        return accessBroadband;
    }

    public void setAccessBroadband(String accessBroadband) {
        this.accessBroadband = accessBroadband == null ? null : accessBroadband.trim();
    }

    public String getIpaddressSegment() {
        return ipaddressSegment;
    }

    public void setIpaddressSegment(String ipaddressSegment) {
        this.ipaddressSegment = ipaddressSegment == null ? null : ipaddressSegment.trim();
    }

    public String getBackupLink() {
        return backupLink;
    }

    public void setBackupLink(String backupLink) {
        this.backupLink = backupLink == null ? null : backupLink.trim();
    }
}