/*
 * Copyright (C) 2018 Naoghuman's dream
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.fw.preferences.core;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @since   0.2.0-PRERELEASE
 * @version 0.2.0-PRERELEASE
 * @author Naoghuman
 */
public final class PreferencesGroup implements PreferencesJson {
    
    public PreferencesGroup() {
        
    }
    
    // START  DESCRIPTION ------------------------------------------------------
    private StringProperty descriptionProperty = null;
    private String _description = ""; // NOI18N
    
    public String getDescription() {
        if (descriptionProperty == null) {
            return _description;
        } else {
            return descriptionProperty.get();
        }
    }
    
    public void setDescription(String description) {
        if (descriptionProperty == null) {
            _description = description;
        } else {
            descriptionProperty.set(description);
        }
    }
    
    public StringProperty descriptionProperty() {
        if (descriptionProperty == null) {
            descriptionProperty = new SimpleStringProperty(this, ATTR__DESCRIPTION, _description);
        }
        
        return descriptionProperty;
    }
    // END  DESCRIPTION --------------------------------------------------------
    
    // START  TITLE ------------------------------------------------------------
    private StringProperty titleProperty;
    private String _title = ""; // NOI18N

    public String getTitle() {
        if (titleProperty == null) {
            return _title;
        } else {
            return titleProperty.get();
        }
    }

    public final void setTitle(final String title) {
        if (titleProperty == null) {
            _title = title;
        } else {
            titleProperty.set(title);
        }
    }

    public StringProperty titleProperty() {
        if (titleProperty == null) {
            titleProperty = new SimpleStringProperty(this, ATTR__TITLE, _title); // NOI18N
        }
        return titleProperty;
    }
    // END  TITLE --------------------------------------------------------------

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PreferencesGroup [").append("\n");
        
        sb.append("  ").append("title="      ).append(this.getTitle()      ).append(",\n");
        sb.append("  ").append("description=").append(this.getDescription()).append(",\n");
        
        sb.append("]");
        
        return sb.toString();
    }
    
}
