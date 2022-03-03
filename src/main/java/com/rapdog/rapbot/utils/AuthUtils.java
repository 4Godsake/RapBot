package com.rapdog.rapbot.utils;

import com.rapdog.rapbot.commands.BaseCommand;

/**
 * @author rapdog
 */
public class AuthUtils {

    private static final Long OWNER_ID = 1025744898L;

    public static boolean checkAuth(Long id){
        return OWNER_ID.equals(id);
    }

    public static boolean checkAuth(Long id, BaseCommand baseCommand){
        return baseCommand.getAuthIds().contains(id);
    }

}
