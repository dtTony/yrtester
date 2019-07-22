package indi.tony.yrtester.core;

import java.util.Vector;

public abstract class TestCase {
    private String case_name;
    private String case_description;

    public abstract Vector<?> getSteps();

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getCase_description() {
        return case_description;
    }

    public void setCase_description(String case_description) {
        this.case_description = case_description;
    }
}
