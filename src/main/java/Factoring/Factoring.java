package Factoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factoring {
private Integer tableSize;
private Integer whichOneMax;
private List <Integer> table = new ArrayList();
    public Factoring () {

    }

    public Integer getLookingForNumber() {
        List<Integer> workingTable = this.table.stream().sorted().collect(Collectors.toList());
        while (workingTable.size()!=tableSize-whichOneMax+1) {
            workingTable.remove(workingTable.size()-1);
        }
        return workingTable.get(workingTable.size()-1);
    }

    public String firstLine(String input) {
        String[] split = input.split(" ");
        tableSize = null;
        whichOneMax = null;
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[0-9]*") && split.length == 2 && Integer.valueOf(split[i]) > 0) {
                if (i == 0) {
                    tableSize = Integer.valueOf(split[0]);
                }
                if (i == 1 && tableSize!=null) {
                    if(Integer.valueOf(split[1])>Integer.valueOf(split[0])) {
                        return "Wrong input! The number from the end which one you want cant be lower than table size";
                    }
                    whichOneMax = Integer.valueOf(split[1]);
                }
            }
        }
        if (tableSize == null || whichOneMax == null) {
            return "Wrong format! Write only two(2) numbers!"+"\n"+ "Format: number(space)number"+"\n"+"Example:X X";
        }
        return "Correct";
    }

    public String secondLine(String inputTable) {
        table.clear();
        String[] splitTable = inputTable.split(" ");
        for (int i = 0; i < splitTable.length; i++) {
            if (splitTable[i].matches("[0-9]*") && splitTable.length == tableSize) {
                table.add(Integer.valueOf(splitTable[i]));
            }

        }
        if(splitTable.length!=tableSize) {
            return "Incorrect number of numbers! You set size table as "+tableSize+" but you give "+splitTable.length+" numbers";
        }

        if (table.size()!=tableSize) {
            return "Incorrect format, write only numbers!";
        }

        if(table.isEmpty()) {

            return "Incorrect format, write only numbers!";
        }
        return "Correct";
    }


    public Integer getTableSize() {
        return tableSize;
    }

    public Integer getWhichOneMax() {
        return whichOneMax;
    }

    public List getTable() {
        return table;
    }
}
