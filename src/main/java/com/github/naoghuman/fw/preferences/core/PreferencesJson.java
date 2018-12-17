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

import java.io.File;

/**
 *
 * @since   0.2.0-PRERELEASE
 * @version 0.2.0-PRERELEASE
 * @author  Naoghuman
 */
public interface PreferencesJson {
    
    /**
     * 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String DEFAULT_PATH_TO_CONFIG_FOLDER =
            System.getProperty("user.dir") // NOI18N
            + File.separator
            + "config"; // NOI18N
    
    /**
     * 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ATTR__CATEGORIES = "categories"; // NOI18N
    
    /**
     * 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ATTR__DESCRIPTION  = "description"; // NOI18N
    
    /**
     * 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ATTR__GROUPS = "groups"; // NOI18N
    
    /**
     * 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ATTR__SETTINGS = "settings"; // NOI18N
    
    /**
     * 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ATTR__TITLE = "title"; // NOI18N
    
}
