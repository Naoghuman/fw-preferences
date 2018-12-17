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
import java.io.File;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @since   0.2.0-PRERELEASE
 * @version 0.2.0-PRERELEASE
 * @author  Naoghuman
 */
public class DefaultPreferencesJsonReaderTest implements PreferencesJson {
    
    public DefaultPreferencesJsonReaderTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRead() {
        String fileName = "test-write100.json";
        
        PreferencesCategory rootSection = new PreferencesCategory();
        rootSection.setTitle("root-category-title-100");
        
        List<PreferencesCategory> cs = FXCollections.observableArrayList();
        PreferencesCategory pc1 = new PreferencesCategory();
        pc1.setTitle("category-title-100-1");
        pc1.setDescription("category-description-100-1");
        cs.add(pc1);
        
        PreferencesCategory pc2 = new PreferencesCategory();
        pc2.setTitle("category-title-100-2");
        pc2.setDescription("category-description-100-2");
        cs.add(pc2);
        
        rootSection.setCategories(cs);
        
        DefaultPreferencesJsonWriter.write(fileName, rootSection);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
        
        Optional<PreferencesCategory> result = DefaultPreferencesJsonReader.read(fileName);
        assertTrue(result.isPresent());
        assertEquals("root-category-title-100", result.get().getTitle());
        assertEquals(2, result.get().getCategories().size());
    }
    
}
