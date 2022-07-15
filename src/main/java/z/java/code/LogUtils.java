package z.java.code;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;

public class LogUtils {
    public static final int DEBUG = Level.CONFIG.intValue();
    public static final int WARNING = Level.WARNING.intValue();
    public static final int ERROR = Level.SEVERE.intValue();
    private static final int CALL_STACK_INDEX = 3;

    public static void d(String tag, String msg) {
        prepareLog(DEBUG, tag, msg);
    }

    public static void w(String tag, String msg) {
        prepareLog(WARNING, tag, msg);
    }

    public static void e(String tag, Throwable err) {
        prepareLog(ERROR, tag, getStackTraceString(err));
    }

    /**
     * 打印信息
     *
     * @param level   优先级
     * @param tag     标签
     * @param message 信息
     */
    private static void prepareLog(int level, String tag, String message) {
        String log = tag + getStackElementMethodFileLine() + ": " + message;
        System.out.println(log);
    }

    private static String getStackElementMethodFileLine() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement element = stackTrace[CALL_STACK_INDEX];
        return "(" + element.getFileName() + ":" + element.getLineNumber() + ")";
    }

    private static String getStackTraceString(Throwable t) {
        StringWriter sw = new StringWriter(256);
        PrintWriter pw = new PrintWriter(sw, false);
        t.printStackTrace();
        pw.flush();
        return sw.toString();
    }

}