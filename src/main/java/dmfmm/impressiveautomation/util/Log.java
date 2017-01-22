package dmfmm.impressiveautomation.util;

import dmfmm.impressiveautomation.ImpressiveAutomation;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

/**
 * File created by mincrmatt12 on 1/21/2017.
 * Originally written for ImpressiveAutomation.
 * <p>
 * See LICENSE.txt for license information.
 */
public class Log {
    public static void all(Object object)
    {
        log(Level.ALL, object);
    }


    public static void debug(Object object)
    {
        log(Level.DEBUG, object);
    }


    public static void error(Object object)
    {
        log(Level.ERROR, object);
    }


    public static void fatal(Object object)
    {
        log(Level.FATAL, object);
    }


    public static void info(Object object)
    {
        log(Level.INFO, object);
    }


    public static void off(Object object)
    {
        log(Level.OFF, object);
    }


    public static void trace(Object object)
    {
        log(Level.TRACE, object);
    }


    public static void warn(Object object)
    {
        log(Level.WARN, object);
    }

    private static void log(Level level, Object object) {
        FMLLog.log(ImpressiveAutomation.MOD_ID, level, object.toString());
    }

}
