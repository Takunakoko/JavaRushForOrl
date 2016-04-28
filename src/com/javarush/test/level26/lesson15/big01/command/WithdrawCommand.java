package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;


class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int cash;

        while (true)
        {
            ConsoleHelper.writeMessage("Введите сумму");
            try
            {
                cash = Integer.parseInt(ConsoleHelper.readString());
                if (cash <= 0)
                {
                    throw new NumberFormatException();
                }
                if (!manipulator.isAmountAvailable(cash))
                {
                    throw new NotEnoughMoneyException();
                }
                manipulator.withdrawAmount(cash);
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("Некорректные данные (NumberFormatException)");
                continue;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("В банкомате отсуствтвует номинал (NotEnoughMoneyException)");
                continue;
            }

            break;
        }
    }
}
