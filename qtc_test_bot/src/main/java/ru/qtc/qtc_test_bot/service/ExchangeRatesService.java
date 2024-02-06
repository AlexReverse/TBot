package ru.qtc.qtc_test_bot.service;

import ru.qtc.qtc_test_bot.exception.ServiceException;

public interface ExchangeRatesService {
    String getUSDExchangeRate() throws ServiceException;
    String getEURExchangeRate() throws ServiceException;
    void clearUSDCache();
    void clearEURCache();
}
