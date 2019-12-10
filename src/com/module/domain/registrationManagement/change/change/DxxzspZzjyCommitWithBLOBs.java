package com.module.domain.registrationManagement.change.change;

public class DxxzspZzjyCommitWithBLOBs extends DxxzspZzjyCommit{
	private String attachment;
	
	public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}
