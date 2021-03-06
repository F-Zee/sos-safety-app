package io.jachoteam.omurbek.saktan;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ContactModelTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("io.jachoteam.omurbek.saktan", appContext.getPackageName());
    }

    @Test
    public void testContact() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        Contact me = new Contact("Omurbek", "771333076");
        DatabaseHandler dbHandler = new DatabaseHandler(appContext);
        dbHandler.addContact(me);
        Contact omurbek = dbHandler.getContactByName("Omurbek");

        assertNotEquals(omurbek, null);
        assertEquals(omurbek.name, "Omurbek");
    }

}
