package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int summ = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            summ += pair.getKey() * pair.getValue();
        }
        return summ;
    }

    public boolean hasMoney()
    {
        return (denominations.size() > 0);
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return (expectedAmount <= getTotalAmount());
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> mapToCash = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> denominationsReverse = new TreeMap<>(Collections.reverseOrder());
        denominationsReverse.putAll(denominations);
        int tempAmount = expectedAmount;

        for (Map.Entry<Integer, Integer> pair : denominationsReverse.entrySet())
        {
            if (pair.getKey() <= tempAmount)
            {
                int quotient = tempAmount / pair.getKey();

                if (quotient <= pair.getValue())
                {
                    mapToCash.put(pair.getKey(), quotient);
                    tempAmount -= pair.getKey() * quotient;
                    pair.setValue(pair.getValue() - quotient);
                    if (pair.getValue() == 0)
                        denominations.remove(pair.getKey());
                    else
                        denominations.put(pair.getKey(), pair.getValue());
                } else
                {
                    mapToCash.put(pair.getKey(), pair.getValue());
                    tempAmount -= pair.getKey() * pair.getValue();
                    pair.setValue(0);
                    denominations.remove(pair.getKey());
                }
            } else
                continue;
            if (tempAmount == 0)
                break;
        }

        if (!hasMoney())
            CurrencyManipulatorFactory.getAllCurrencyManipulators().remove(CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode));
        if (tempAmount != 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : mapToCash.entrySet())
            {
                ConsoleHelper.writeMessage(String.format("\t%d - %d", pair.getKey(), pair.getValue()));
            }
            ConsoleHelper.writeMessage("Транзакция проведена успешно!");
        }

        return mapToCash;
    }
}
