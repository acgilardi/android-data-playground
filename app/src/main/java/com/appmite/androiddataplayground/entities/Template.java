package com.appmite.androiddataplayground.entities;

import com.appmite.androiddataplayground.types.TemplateTypes;
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Template")
public class Template extends ParseObject {

    public static final String TEMPLATE_TYPE = "TemplateType";

    private TemplateTypes type;

//    private String title;
//    private String description;
//    @DatabaseField(foreign=true,foreignAutoRefresh=true)
//    private Category category;
//    private String icon;
//    private boolean ismedication;
//    private boolean isserving;
//    private boolean isscheduled;
//    private boolean isgoaltracked;
//    private boolean issyncable;
//    private boolean allowmultiple;


    public TemplateTypes getTemplateType() {
        String templateType = getString(TEMPLATE_TYPE);
        return TemplateTypes.valueOf(templateType);
    }

    public void setTemplateType(TemplateTypes type) {
        put(TEMPLATE_TYPE, type.toString());
    }

}
