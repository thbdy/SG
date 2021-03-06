package com.zhangf.unnamed.enums;

import com.zhangf.unnamed.R;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public enum  LevelEnum {
    LEVEL_1("LV1", R.drawable.icon_level_1),
    LEVEL_2("LV2", R.drawable.icon_level_2),
    LEVEL_3("LV3", R.drawable.icon_level_3),
    LEVEL_4("LV4", R.drawable.icon_level_4),
    LEVEL_5("LV5", R.drawable.icon_level_5),
    LEVEL_6("LV6", R.drawable.icon_level_6),
    LEVEL_7("LV7", R.drawable.icon_level_7),
    LEVEL_8("LV8", R.drawable.icon_level_8),
    LEVEL_9("LV9", R.drawable.icon_level_9),
    LEVEL_10("LV10", R.drawable.icon_level_10),
    LEVEL_11("LV11", R.drawable.icon_level_11),
    LEVEL_12("LV12", R.drawable.icon_level_12),
    LEVEL_13("LV13", R.drawable.icon_level_13),
    LEVEL_14("LV14", R.drawable.icon_level_14),
    LEVEL_15("LV15", R.drawable.icon_level_15);


    public static int getImgByLevel(String level){
        for (LevelEnum c : LevelEnum.values()) {
            if (c.getLevel().equals(level)) {
                return c.img;
            }
        }
        return LEVEL_1.img;

    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private String level;
    private int img;

    LevelEnum(String level, int img) {
        this.level = level;
        this.img = img;
    }

    //二货 -999999999
    //新人 0
    //LV1 >=10
    //LV2 >=100
    //LV3 >=400
    //LV4 >=800
    //LV5 >=1700
    //LV6 >=2800
    //LV7 >=4000
    //LV8 >=6000
    //LV9 >=9000
    //LV10 >=15000
    //LV11 >=25000
    //LV12 >=50000
    //LV13 >=100000
    //LV14 >=200000
    //LV15 >=500000

}
