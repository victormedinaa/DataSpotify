package es.ulpgc.client.util;
public class Html {
    public static String begin() {
        return "<html><body>";
    }
    public static String end() {
        return "</body></html>";
    }
    public static String tag(String tag, String value, String... attributes) {
        return String.format("<%s%s>%s</%s>", tag, format(attributes), value, tag);
    }
    private static String format(String[] attributes) {
        if(attributes == null || attributes.length == 0) return "";
        return " " + String.join(" ", attributes);
    }
}
