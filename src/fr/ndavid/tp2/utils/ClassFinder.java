package fr.ndavid.tp2.utils;

public class ClassFinder {
        public static String getCallerClassName() {
            StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
                StackTraceElement ste = stElements[stElements.length - 1];
                if (!ste.getClassName().equals(ClassFinder.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
                    return ste.getClassName();
                }
            return null;
        }

    public static String getCallerMethodName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
            StackTraceElement ste = stElements[stElements.length - 1];
            if (!ste.getClassName().equals(ClassFinder.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
                return ste.getMethodName();
            }
        return null;
    }
}
