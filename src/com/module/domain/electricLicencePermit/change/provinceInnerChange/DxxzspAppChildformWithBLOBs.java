package com.module.domain.electricLicencePermit.change.provinceInnerChange;

public class DxxzspAppChildformWithBLOBs extends DxxzspAppChildform {
    private String yumingzhengshu;

    private String shangbiaozhengshu;

    public String getYumingzhengshu() {
        return yumingzhengshu;
    }

    public void setYumingzhengshu(String yumingzhengshu) {
        this.yumingzhengshu = yumingzhengshu == null ? null : yumingzhengshu.trim();
    }

    public String getShangbiaozhengshu() {
        return shangbiaozhengshu;
    }

    public void setShangbiaozhengshu(String shangbiaozhengshu) {
        this.shangbiaozhengshu = shangbiaozhengshu == null ? null : shangbiaozhengshu.trim();
    }
}