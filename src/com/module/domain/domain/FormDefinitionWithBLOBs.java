package com.module.domain.domain;

public class FormDefinitionWithBLOBs extends FormDefinition {
    private String formHtml;

    private String divJs;

    public String getFormHtml() {
        return formHtml;
    }

    public void setFormHtml(String formHtml) {
        this.formHtml = formHtml == null ? null : formHtml.trim();
    }

    public String getDivJs() {
        return divJs;
    }

    public void setDivJs(String divJs) {
        this.divJs = divJs == null ? null : divJs.trim();
    }
}