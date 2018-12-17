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
package com.github.naoghuman.fw.preferences.internal;

import com.github.naoghuman.fw.preferences.core.PreferencesCategory;
import com.github.naoghuman.fw.preferences.core.PreferencesJson;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @since   0.2.0-PRERELEASE
 * @version 0.2.0-PRERELEASE
 * @author Naoghuman
 */
public class DefaultPreferencesJsonWriter implements PreferencesJson {

    /**
     * 
     * @return 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static boolean createConfigDirectory() {
        final File configDirectory = new File(DEFAULT_PATH_TO_CONFIG_FOLDER);
        
        return configDirectory.mkdirs();
    }
    
    /**
     * 
     * @param   fileName
     * @param   rootCategory 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void write(final String fileName, final PreferencesCategory rootCategory) {
        
        final String pathAndFile = DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName;
        LoggerFacade.getDefault().debug(DefaultPreferencesJsonWriter.class, 
                String.format("write(String, PreferencesCategory): %s", pathAndFile));
        
        // Check directory
        DefaultPreferencesJsonWriter.createConfigDirectory();
        
        // Write data
        final File          file           = new File(pathAndFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            final Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            
            bufferedWriter.write(gson.toJson(rootCategory));
            bufferedWriter.flush();
        } catch (IOException ex) {
            LoggerFacade.getDefault().error(
                    DefaultPreferencesJsonWriter.class,
                    String.format("Error during writing the 'json' file: %s", pathAndFile), // NOI18N
                    ex);
        }
    }
    
}
