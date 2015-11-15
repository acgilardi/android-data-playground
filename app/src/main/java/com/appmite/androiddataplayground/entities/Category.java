package com.appmite.androiddataplayground.entities;


import com.appmite.androiddataplayground.types.CategoryTypes;
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Category")
public class Category extends ParseObject {

    private static final String CATEGORY_TYPE = "type";
    private static final String CATEGORY_NAME = "name";
    private static final String CATEGORY_DESCRIPTION = "description";
    private static final String CATEGORY_ICON = "icon";

    // name
    public CategoryTypes getCategoryType() {
        String categoryType = getString(CATEGORY_TYPE);
        return CategoryTypes.valueOf(categoryType);
    }

    public void setTemplateType(CategoryTypes type) {
        put(CATEGORY_TYPE, type.toString());
    }

    // name
    public String getName() {
        return getString(CATEGORY_NAME);
    }
    public void setName(String name) {
        put(CATEGORY_NAME, name);
    }

    // description
    public String getDescription() {
        return getString(CATEGORY_DESCRIPTION);
    }
    public void setDescription(String name) {
        put(CATEGORY_DESCRIPTION, name);
    }

    // icon
    public String getIcon() {
        return getString(CATEGORY_ICON);
    }
    public void setIcon(String name) {
        put(CATEGORY_ICON, name);
    }

}
