import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class OKHttpUtil {
    public static final OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        StopWatch stopWatch = new StopWatch();

        String url = "http://localhost:8801";

        stopWatch.start("okHttpClient");
        String asString = OKHttpUtil.getAsString(url);
        stopWatch.stop();

        log.info(stopWatch.prettyPrint());
        log.info("url: " + url);
        log.info("response: " + asString);
    }

    public static String getAsString(String url) throws IOException {

        Request request = new Request.Builder().get().url(url).build();

        try(Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }



}
