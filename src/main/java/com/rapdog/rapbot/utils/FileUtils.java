package com.rapdog.rapbot.utils;

import com.google.common.base.MoreObjects;
import com.google.common.io.Resources;

import java.net.URL;

public class FileUtils {

    public static URL getResource(String resourceName) {
        ClassLoader loader = MoreObjects.firstNonNull(
                Thread.currentThread().getContextClassLoader(),
                Resources.class.getClassLoader());
        return loader.getResource(resourceName);
    }
}
