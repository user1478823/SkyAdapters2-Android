package com.example.skyadapters;

/**
 * Created by ttlnisoffice on 11/24/17.
 */

public class ToolbarIDs {

    private Integer rvId;
    private Integer customLayoutId;
    private Integer itemImageId;
    private Integer itemTitleId;

    public ToolbarIDs(Integer rvId, Integer customLayoutId, Integer itemImageId, Integer itemTitleId) {
        this.rvId = rvId;
        this.customLayoutId = customLayoutId;
        this.itemImageId = itemImageId;
        this.itemTitleId = itemTitleId;
    }

    public Integer getRvId() {
        return rvId;
    }

    public Integer getCustomLayoutId() {
        return customLayoutId;
    }

    public Integer getItemImageId() {
        return itemImageId;
    }

    public void setItemImageId(Integer itemImageId) {
        this.itemImageId = itemImageId;
    }

    public Integer getItemTitleId() {
        return itemTitleId;
    }

    public void setItemTitleId(Integer itemTitleId) {
        this.itemTitleId = itemTitleId;
    }
}
