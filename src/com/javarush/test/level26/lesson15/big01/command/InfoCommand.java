package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;


class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().size() == 0)
            ConsoleHelper.writeMessage("No money available.");
        else
        {
        for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (currencyManipulator.hasMoney())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d",
                        currencyManipulator.getCurrencyCode(), currencyManipulator.getTotalAmount()));
            } else
                ConsoleHelper.writeMessage("No money available.");
        }
        }
    }
}
