package com.appmite.androiddataplayground.entities;

import com.appmite.androiddataplayground.types.CategoryTypes;
import com.parse.ParseClassName;
import com.parse.ParseObject;


import com.appmite.androiddataplayground.types.CategoryTypes;
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Category")
public class Goal extends ParseObject {

    private static final String GOAL_TITLE = "title";
    private static final String GOAL_DESCRIPTION = "description";
    private static final String GOAL_TEMPLATE = "template";

//    // name
//    public CategoryTypes getCategoryType() {
//        String categoryType = getString(CATEGORY_TYPE);
//        return CategoryTypes.valueOf(categoryType);
//    }
//
//    public void setTemplateType(CategoryTypes type) {
//        put(CATEGORY_TYPE, type.toString());
//    }

    // name
    public String getTitle() {
        return getString(GOAL_TITLE);
    }
    public void setTitle(String title) {
        put(GOAL_TITLE, title);
    }

    // description
    public String getDescription() {
        return getString(GOAL_DESCRIPTION);
    }
    public void setDescription(String description) {
        put(GOAL_DESCRIPTION, description);
    }

    // icon
    public String getTemplateName() {
        return getString(GOAL_TEMPLATE);
    }
    public void setTemplateName(String templateName) {
        put(GOAL_TEMPLATE, templateName);
    }

}
