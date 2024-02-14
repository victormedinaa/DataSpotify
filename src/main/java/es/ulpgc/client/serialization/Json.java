package es.ulpgc.client.serialization;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {
    private static final Gson GsonInstance = createGsonInstance();


    public static String toJson(Object object) { //serializar
      return GsonInstance.toJson(object);}


    public static <T> T fromJson(String json, Class<T> type) { //deserializar
        return GsonInstance.fromJson(json,type);
    }
    private static Gson createGsonInstance() {  //realización específica u ocurrencia de una determinada clase
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = builder.create();
        return gson;
    }
}
