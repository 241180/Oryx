package com.oryx.core.vo;

import com.oryx.core.model.system.ref.Person;

import java.util.List;

public class PersonListVO {
    private int pagesCount;
    private long totalPersonModels;

    private String actionMessage;
    private String searchMessage;

    private List<Person> persons;

    public PersonListVO() {
    }

    public PersonListVO(int pages, long totalPersonModels, List<Person> persons) {
        this.pagesCount = pages;
        this.persons = persons;
        this.totalPersonModels = totalPersonModels;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public long getTotalPersonModels() {
        return totalPersonModels;
    }

    public void setTotalPersonModels(long totalPersonModels) {
        this.totalPersonModels = totalPersonModels;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public void setSearchMessage(String searchMessage) {
        this.searchMessage = searchMessage;
    }
}