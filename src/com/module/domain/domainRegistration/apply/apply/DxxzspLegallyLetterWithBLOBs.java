package com.module.domain.domainRegistration.apply.apply;

public class DxxzspLegallyLetterWithBLOBs extends DxxzspLegallyLetter{
	private String legallyLetterFlex;
	
	public String getLegallyLetterFlex() {
        return legallyLetterFlex;
    }

    public void setLegallyLetterFlex(String legallyLetterFlex) {
        this.legallyLetterFlex = legallyLetterFlex == null ? null : legallyLetterFlex.trim();
    }
}
