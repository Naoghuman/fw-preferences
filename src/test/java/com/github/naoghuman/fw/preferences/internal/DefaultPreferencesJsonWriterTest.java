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
public class DefaultPreferencesJsonWriterTest implements PreferencesJson {
    
    public DefaultPreferencesJsonWriterTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateConfigDirectory() {
//        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER);
//        if (file1.exists()) {
//            file1.delete();
//        }
//        
//        boolean result = DefaultPreferencesJsonWriter.createConfigDirectory();
//        assertTrue(result);
//        
//        File file2 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER);
//        assertTrue(file2.exists());
//        
//        if (file2.exists()) {
//            file2.delete();
//        }
    }

    @Test
    public void testWriteWithMainSection() {
        String fileName = "test-write1.json";
        
        PreferencesCategory rootCategory = new PreferencesCategory();
        rootCategory.setTitle("root-category-title-1");
        
        DefaultPreferencesJsonWriter.write(fileName, rootCategory);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithMainSectionAndMainSections() {
        String fileName = "test-write2.json";
        
        PreferencesCategory rs = new PreferencesCategory();
        rs.setTitle("root-category-title-2");
        
        List<PreferencesCategory> pcs = FXCollections.observableArrayList();
        PreferencesCategory pc1 = new PreferencesCategory();
        pc1.setTitle("category-title-1");
        pc1.setDescription("category-description-1");
        pcs.add(pc1);
        
        PreferencesCategory pc2 = new PreferencesCategory();
        pc2.setTitle("category-title-2");
        pc2.setDescription("category-description-2");
        pcs.add(pc2);
        
        rs.setCategories(pcs);
        
        DefaultPreferencesJsonWriter.write(fileName, rs);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithMainSectionAndMainSectionsAndMainSection() {
        String fileName = "test-write3.json";
        
        PreferencesCategory rs = new PreferencesCategory();
        rs.setTitle("root-category-title-3");
        
        List<PreferencesCategory> pcs = FXCollections.observableArrayList();
        PreferencesCategory pc1 = new PreferencesCategory();
        pc1.setTitle("category-title-1");
        pc1.setDescription("category-description-1");
        pcs.add(pc1);
        
        PreferencesCategory pc2 = new PreferencesCategory();
        pc2.setTitle("category-title-2");
        pc2.setDescription("category-description-2");
        
        List<PreferencesCategory> pcs2 = FXCollections.observableArrayList();
        PreferencesCategory pc2_1 = new PreferencesCategory();
        pc2_1.setTitle("category-title-2_1");
        pc2_1.setDescription("category-description-2_1");
        pcs2.add(pc2_1);
        
        pc2.setCategories(pcs2);
        pcs.add(pc2);
        
        rs.setCategories(pcs);
        
        DefaultPreferencesJsonWriter.write(fileName, rs);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }
    
}
