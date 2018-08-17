package com.zhangf.unnamed.module.main.model;

/**
 * Created by 75232 on 2018/8/17
 * Email：zhangfu@ylzinfo.com
 */
public class UserGoldResult {

    @Override
    public String toString() {
        return "UserGoldResult{" +
                "gold=" + gold +
                ", issign=" + issign +
                '}';
    }

    /**
     * gold : 668
     * issign : 0
     */

    private int gold;
    private int issign;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getIssign() {
        return issign;
    }

    public void setIssign(int issign) {
        this.issign = issign;
    }
}
