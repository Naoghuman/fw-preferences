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
import com.github.naoghuman.fw.preferences.core.PreferencesGroup;
import com.github.naoghuman.fw.preferences.core.PreferencesJson;
import com.github.naoghuman.fw.preferences.core.PreferencesSetting;
import java.io.File;
import java.util.List;
import javafx.collections.FXCollections;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
    public void testWriteWithCategory() {
        String fileName = "test-write1.json";
        
        PreferencesCategory rootCategory = new PreferencesCategory();
        rootCategory.setTitle("root-category-title-1");
        
        DefaultPreferencesJsonWriter.write(fileName, rootCategory);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithCategoryAndGroup() {
        String fileName = "test-write1a.json";
        
        PreferencesCategory pc = new PreferencesCategory();
        pc.setTitle("root-category-title-1a");
        
        List<PreferencesGroup> pgs = FXCollections.observableArrayList();
        PreferencesGroup pg = new PreferencesGroup();
        pg.setTitle("group-title-1a");
        pg.setDescription("group-description-1a");
        pgs.add(pg);
        
        pc.setGroups(pgs);
        
        DefaultPreferencesJsonWriter.write(fileName, pc);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithCategoryAndGroupAndSetting() {
        String fileName = "test-write1b.json";
        
        PreferencesCategory pc = new PreferencesCategory();
        pc.setTitle("root-category-title-1b");
        
        List<PreferencesGroup> pgs = FXCollections.observableArrayList();
        PreferencesGroup pg = new PreferencesGroup();
        pg.setTitle("group-title-1b");
        pg.setDescription("group-description-1b");
        
        List<PreferencesSetting> pss = FXCollections.observableArrayList();
        PreferencesSetting ps = new PreferencesSetting();
        ps.setTitle("setting-title-1b");
        ps.setDescription("setting-description-1b");
        pss.add(ps);
        pg.setSettings(pss);
        
        pgs.add(pg);
        pc.setGroups(pgs);
        
        DefaultPreferencesJsonWriter.write(fileName, pc);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithCategoryAndCategories() {
        String fileName = "test-write2.json";
        
        PreferencesCategory rc = new PreferencesCategory();
        rc.setTitle("root-category-title-2");
        
        List<PreferencesCategory> pcs = FXCollections.observableArrayList();
        PreferencesCategory pc1 = new PreferencesCategory();
        pc1.setTitle("category-title-1");
        pc1.setDescription("category-description-1");
        pcs.add(pc1);
        
        PreferencesCategory pc2 = new PreferencesCategory();
        pc2.setTitle("category-title-2");
        pc2.setDescription("category-description-2");
        pcs.add(pc2);
        
        rc.setCategories(pcs);
        
        DefaultPreferencesJsonWriter.write(fileName, rc);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithCategoryAndCategoriesAndGroup() {
        String fileName = "test-write2a.json";
        
        PreferencesCategory rc = new PreferencesCategory();
        rc.setTitle("root-category-title-2");
        
        List<PreferencesCategory> pcs = FXCollections.observableArrayList();
        PreferencesCategory pc1 = new PreferencesCategory();
        pc1.setTitle("category-title-1");
        pc1.setDescription("category-description-1");
        pcs.add(pc1);
        
        PreferencesCategory pc2 = new PreferencesCategory();
        pc2.setTitle("category-title-2");
        pc2.setDescription("category-description-2");
        
        List<PreferencesGroup> pgs = FXCollections.observableArrayList();
        PreferencesGroup pg = new PreferencesGroup();
        pg.setTitle("group-title-2_1");
        pg.setDescription("group-description-2_1");
        pgs.add(pg);
        pc2.setGroups(pgs);
        pcs.add(pc2);
        
        rc.setCategories(pcs);
        
        DefaultPreferencesJsonWriter.write(fileName, rc);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }

    @Test
    public void testWriteWithCategoryAndCategoriesAndCategory() {
        String fileName = "test-write3.json";
        
        PreferencesCategory rc = new PreferencesCategory();
        rc.setTitle("root-category-title-3");
        
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
        
        rc.setCategories(pcs);
        
        DefaultPreferencesJsonWriter.write(fileName, rc);
        
        final File file1 = new File(DEFAULT_PATH_TO_CONFIG_FOLDER + File.separator + fileName);
        assertTrue(file1.exists());
    }
    
}
