package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor
{
    public static Map<Operation,Command> oper_com = new HashMap<Operation,Command>();
    {
        oper_com.put(Operation.DEPOSIT,new DepositCommand());
        oper_com.put(Operation.EXIT,new ExitCommand());
        oper_com.put(Operation.INFO,new InfoCommand());
        oper_com.put(Operation.WITHDRAW,new WithdrawCommand());
    }

    private CommandExecutor (){

    }
    public static final void execute(Operation operation){
        oper_com.get(operation);
    }
}
