package ru.qtc.qtc_test_bot.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.qtc.qtc_test_bot.exception.ServiceException;

import java.io.IOException;
import java.util.Optional;

@Component
public class CbrClient {
    @Autowired
    private OkHttpClient client;

    @Value("${cbr.currency.rates.xml.url}")
    private String url;

    public Optional<String> getCurrencyRatesXML() throws ServiceException {
        var request = new Request.Builder()
                .url(url)
                .build();
        try (var response = client.newCall(request).execute()) {
            var body = response.body();
            return body == null ? Optional.empty() : Optional.of(body.string());
        } catch (IOException e){
            throw new ServiceException("Ошибка получения курсов валют", e);
        }
    }
}
